package ru.dannik.powercraft.blocks.teleporter;

import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.items.ItemList;
import ru.dannik.powercraft.utils.TeleporterManager;

public class Teleporter extends Block implements ITileEntityProvider {

	NBTTagCompound nbt = new NBTTagCompound(); 	//initialization NBT
	NBTTagCompound tdata = new NBTTagCompound(); //initialization NBT
	
	public Teleporter() {
		super(Material.portal);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(0.25F);
		setStepSound(soundTypeMetal);
		setBlockTextureName("iron_block");
		setBlockName(Main.MODID + ".Teleporter");
		
	}    
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
    
    //create TileEntity for this block
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityTeleporter();
	}

	public int getRenderType() {
		return -1;
	}

    @Override
    public int getRenderBlockPass()
    {
        return 1;
    }
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	//block set in world => write in NBT base data
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is){
		if(!world.isRemote){
			String sX = Integer.toString(x);
			String sY = Integer.toString(y);
			String sZ = Integer.toString(z);
			String preUdid = DigestUtils.md5Hex(sX)+DigestUtils.md5Hex(sY)+DigestUtils.md5Hex(sZ); 
			String udid = DigestUtils.md5Hex(preUdid);
			nbt.setString("udid", udid);
			nbt.setString("name", "default");
			nbt.setInteger("x", x);
			nbt.setInteger("y", y);
			nbt.setInteger("z", z);
			nbt.setBoolean("Shift", false);
			TileEntityTeleporter tile = new TileEntityTeleporter();
			tile.writeToNBT(nbt);
			TeleporterManager manager = new TeleporterManager();
				manager.start(world.getWorldInfo().getWorldName());
		}
	}
	
	

	//if right click on block => open base gui & checked exists activationCrystal in hand & checked pressed key shift
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int n1, float f1, float f2, float f3){
		ItemStack currentItem = player.getCurrentEquippedItem();    	
   		if(currentItem != null && currentItem.getItem() == ItemList.ActivationCrystal){
   			player.openGui(Main.instance, 6, world, x, y, z);
   		}else if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)){
   			if(nbt.getBoolean("Shift") == true){
   				player.openGui(Main.instance, 7, world, x, y, z);
   			}
   		}else{
   			player.openGui(Main.instance, 4, world, x, y, z);
   		}
		return true;
	}

	//spawning portal particles
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {

        for (int l = 0; l < 4; ++l)
        {
            double d0 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            double d2 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;

            if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this)
            {
                d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
                d3 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            }
            else
            {
                d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)i1;
                d5 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            }

            p_149734_1_.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }

}
