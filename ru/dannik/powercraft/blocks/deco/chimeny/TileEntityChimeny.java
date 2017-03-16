package ru.dannik.powercraft.blocks.deco.chimeny;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ru.dannik.powercraft.blocks.BlockList;

public class TileEntityChimeny extends TileEntity {
	
	private static Random rand = new Random();

	public TileEntityChimeny() {

	}
	
	@Override
	public void updateEntity() {
		World world = worldObj;
		if (rand.nextInt(5) == 0) {
			tryToSmoke(world);
		}

	}
	
	@Override
	public boolean canUpdate() {
		return true;
	}

	private void doSmoke(World world) {
		for (int l = 0; l < 12; l++) {
			double smI = xCoord + rand.nextFloat() * 0.4F + 0.2F;
			double smJ = yCoord + 0.4F + rand.nextFloat() * 0.6F + 0.5F;
			double smK = zCoord + rand.nextFloat() * 0.4F + 0.2F;

			world.spawnParticle("smoke", smI, smJ, smK, 0.0D, 0.0D, 0.0D);
			
		}
	}
	
	private void tryToSmoke(World world){
		for(int i = 1; i < 256; ++i){
			if(world.getBlock(xCoord, yCoord - i, zCoord) != Blocks.bedrock){
				if(world.isAirBlock(xCoord, yCoord + 1, zCoord)){
					if(world.getBlock(xCoord, yCoord - i, zCoord) == Blocks.fire){
						doSmoke(world);
						break;
					}
					if(world.getBlock(xCoord, yCoord - i, zCoord) == Blocks.lit_furnace){
						doSmoke(world);
						break;
					}
				}
				else{
					break;
				}
			}
			else{
				break;
			}
		}
	}

}
