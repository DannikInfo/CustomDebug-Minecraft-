package ru.dannik.powercraft.utils;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BaseUtils {
	protected static BaseUtils instance;
	
	public static void spawnMobs(World world, int x, int y, int z, String type) {
		byte count = 5;
		
		for (int q = 0; q < count; q++) {
			EntityLiving entityliving = (EntityLiving) EntityList.createEntityByName(type, world);
			
			if (entityliving == null) {
				return;
			}
			
			int c = world.getEntitiesWithinAABB(entityliving.getClass(), AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1).expand(8D, 4D, 8D)).size();
			
			if (c >= 6) {
					double d = world.rand.nextGaussian() * 0.02D;
					double d1 = world.rand.nextGaussian() * 0.02D;
					double d2 = world.rand.nextGaussian() * 0.02D;
					world.spawnParticle("smoke", x + 0.5D, y + 0.4D, z + 0.5D, d, d1, d2);
				
				return;
			}
			double d3 = x + (world.rand.nextDouble() - world.rand.nextDouble()) * 3D;
			double d4 = (y + world.rand.nextInt(3)) - 1;
			double d5 = z + (world.rand.nextDouble() - world.rand.nextDouble()) * 3D;
			entityliving.setLocationAndAngles(d3, d4, d5, world.rand.nextFloat() * 360F, 0.0F);
			
			if (world.checkNoEntityCollision(entityliving.boundingBox) && world.getCollidingBoundingBoxes(entityliving, entityliving.boundingBox).size() == 0) {
				world.spawnEntityInWorld(entityliving);
				world.playAuxSFX(2004, x, y, z, 0);
				entityliving.spawnExplosionParticle();
				
				return;
			}
		}
	}
}
