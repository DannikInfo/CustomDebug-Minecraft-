package ru.dannik.powercraft.BlocksL.logic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.BlocksL.BlockList;

public class SpecialController extends Block{

	public SpecialController(){
		super(Material.rock);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(1F);
		setStepSound(soundTypeStone);
		setBlockTextureName("powercraftreloaded:specialcontroller");
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
    }
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block b) {
    	if(world.isBlockIndirectlyGettingPowered(x, y, z)) {
  
			if (world.getBlock(x + 1, y, z) == BlockList.spawner){
				TileEntity spawner = world.getTileEntity(x + 1, y, z);
				MobSpawnerBaseLogic logic = ((TileEntityMobSpawner)spawner).func_145881_a();
				logic.spawnDelay = 0;
			}else if(world.getBlock(x, y, z + 1) == BlockList.spawner){
				TileEntity spawner = world.getTileEntity(x, y, z + 1);
				MobSpawnerBaseLogic logic = ((TileEntityMobSpawner)spawner).func_145881_a();
				logic.spawnDelay = 0;
			}else if(world.getBlock(x - 1, y, z) == BlockList.spawner){
				TileEntity spawner = world.getTileEntity(x - 1, y, z);
				MobSpawnerBaseLogic logic = ((TileEntityMobSpawner)spawner).func_145881_a();
				logic.spawnDelay = 0;
			}else if(world.getBlock(x, y, z - 1) == BlockList.spawner){
				TileEntity spawner = world.getTileEntity(x, y, z - 1);
				MobSpawnerBaseLogic logic = ((TileEntityMobSpawner)spawner).func_145881_a();
				logic.spawnDelay = 0;
			}
		}
	}
}
