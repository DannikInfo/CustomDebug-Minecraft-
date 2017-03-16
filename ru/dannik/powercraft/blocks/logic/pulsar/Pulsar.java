package ru.dannik.powercraft.blocks.logic.pulsar;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;

public class Pulsar extends Block implements ITileEntityProvider{
	
	NBTTagCompound nbt = new NBTTagCompound();
	
	public Pulsar() {
		super(Material.redstoneLight);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(1F);
		setLightLevel(1F);
		setStepSound(soundTypeStone);
		setBlockTextureName("powercraftreloaded:pulsar");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityPulsar();
	}
	
	public boolean canProvidePower(){
	    return true;
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block b) {
	}
	
    public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_)
    {
    	int i1 = p_149709_1_.getBlockMetadata(p_149709_2_, p_149709_3_, p_149709_4_);
        return i1 == 5 && p_149709_5_ == 1 ? 0 : (i1 == 3 && p_149709_5_ == 3 ? 0 : (i1 == 4 && p_149709_5_ == 2 ? 0 : (i1 == 1 && p_149709_5_ == 5 ? 0 : (i1 == 2 && p_149709_5_ == 4 ? 0 : 15))));
    }
	

}