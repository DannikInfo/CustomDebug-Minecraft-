package ru.dannik.powercraft.BlocksL.Laser;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;

public class Laser extends Block implements ITileEntityProvider {

	public NBTTagCompound nbt = new NBTTagCompound();
	
	public Laser() {
		super(Material.rock);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(0.25F);
		setBlockTextureName("cobblestone");
		setBlockName(Main.MODID + ".Laser");
	}    
    
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityLaser();
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
	
	  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is)
	    {
	        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	        world.setBlockMetadataWithNotify(x, y, z, l, 2);
	    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int n1, float f1, float f2, float f3){
		return true;
	}
}
