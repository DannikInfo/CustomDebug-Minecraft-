package ru.dannik.powercraft.BlocksL.logic;

import java.util.Random;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityPulsar extends TileEntity{
	
	public static int tick = 0;
	
	public void updateEntity(){
		if(tick <= 20){
			tick++;
		}
		else{
			tick = 0;
		}
	}
}
