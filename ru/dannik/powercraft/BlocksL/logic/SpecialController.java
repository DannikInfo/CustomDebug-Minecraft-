package ru.dannik.powercraft.BlocksL.logic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.BlocksL.BlockList;

public class SpecialController extends Block{

	public Object blockIcon_back;
	public Object blockIcon_front;
	public Object blockIcon_top;
	public Object blockIcon_bottom;
	public Object blockIcon_side;
	
	public SpecialController(){
		super(Material.rock);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(1F);
		setStepSound(soundTypeStone);
		setBlockTextureName("powercraftreloaded:specialcontroller");
		setBlockName(Main.MODID + ".SpecialController");
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.15F, 1.0F);
    }
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		blockIcon_front = reg.registerIcon("powercraftreloaded:logic" + "_" + "side");
		blockIcon_back = reg.registerIcon("powercraftreloaded:logic" + "_" + "side");
		blockIcon_top = reg.registerIcon("powercraftreloaded:specialcontroller" + "_" + "top_off");
		blockIcon_bottom = reg.registerIcon("powercraftreloaded:logic" + "_" + "bottom");
		blockIcon_side = reg.registerIcon("powercraftreloaded:logic" + "_" + "side");
	}
	
    public IIcon getIcon(int side, int meta) {
        ForgeDirection dir = ForgeDirection.getOrientation(side);
        ForgeDirection block_dir;
        if (meta != 0)
            block_dir = ForgeDirection.getOrientation(meta);
        else
            block_dir = ForgeDirection.EAST; // Блок в инвентаре.
        if (block_dir == dir) return (IIcon) blockIcon_front;
        if (block_dir.getOpposite() == dir) return (IIcon) blockIcon_back;
        if (dir == ForgeDirection.UP) return (IIcon) blockIcon_top;
        if (dir == ForgeDirection.DOWN) return (IIcon) blockIcon_bottom;
        return (IIcon) blockIcon_side;
    }
	
    public void onBlockPlacedBy(World world, int x, int y, int z,
            EntityLivingBase entity, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entity, itemStack);
        int dir = (MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
        int[] r = {2, 5, 3, 4};
        world.setBlockMetadataWithNotify(x, y, z, r[dir], 3);
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
