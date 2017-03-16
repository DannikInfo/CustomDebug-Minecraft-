package ru.dannik.powercraft.blocks.logic.pulsar;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;

public class PulsarOff extends Block implements ITileEntityProvider{
	
	NBTTagCompound nbt = new NBTTagCompound();
	
	public PulsarOff() {
		super(Material.redstoneLight);
		setHardness(1F);
		setStepSound(soundTypeStone);
		setBlockTextureName("powercraftreloaded:pulsaroff");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityPulsar();
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block b) {

	}
	
	public boolean canProvidePower(){
	    return true;
	}
	

}
