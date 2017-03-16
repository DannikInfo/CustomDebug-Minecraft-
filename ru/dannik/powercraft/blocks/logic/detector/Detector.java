package ru.dannik.powercraft.blocks.logic.detector;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.blocks.BlockList;

public class Detector extends Block implements ITileEntityProvider {

	NBTTagCompound nbt = new NBTTagCompound();
	
    public static final String[] metadata = new String[] {
            "Player_on",
            "Entity_on",
            "Item_on",
        };
	
	public Detector() {
		super(Material.rock);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(1F);
		setBlockTextureName("cobblestone");
		setBlockName(Main.MODID + ".Detector");
		
	}
	
    public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
    
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityDetector();
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is){
		if(!world.isRemote){
			int meta = is.getItemDamage();
			world.setBlock(x, y, z, BlockList.detectoroff, meta, 1);
			nbt.setInteger("Distance", 3);
			TileEntityDetector tile = new TileEntityDetector();
			tile.writeToNBT(nbt);
		}
	}

	public int getRenderType() {
		return -1;
	}
	
	public boolean canProvidePower(){
	    return true;
	}
	 public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_){
		 int i1 = p_149709_1_.getBlockMetadata(p_149709_2_, p_149709_3_, p_149709_4_);
	     return i1 == 5 && p_149709_5_ == 1 ? 0 : (i1 == 3 && p_149709_5_ == 3 ? 0 : (i1 == 4 && p_149709_5_ == 2 ? 0 : (i1 == 1 && p_149709_5_ == 5 ? 0 : (i1 == 2 && p_149709_5_ == 4 ? 0 : 15))));
	}
	
	public int getRange(){
		int range;
		TileEntityDetector tile = new TileEntityDetector();
		tile.readFromNBT(nbt);
		range = nbt.getInteger("Distance");
		return range;
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
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){	
	    player.openGui(Main.instance, 8, world, x, y, z);
	    return true;
    }
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (int j = 0; j < metadata.length; ++j) {
            
            list.add(new ItemStack(item, 1, j));
            
        }
    }

}
