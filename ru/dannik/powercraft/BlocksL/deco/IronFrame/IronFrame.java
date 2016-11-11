package ru.dannik.powercraft.BlocksL.deco.IronFrame;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;

public class IronFrame extends Block implements ITileEntityProvider {

	public IronFrame() {
		super(Material.iron);
		setCreativeTab(Main.tabPowerCraftDeco);
		setHardness(4F);
		setStepSound(soundTypeMetal);
		setBlockTextureName("iron_block");
		setBlockName(Main.MODID + ".IronFrame");
		
	}
    
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityIronFrame();
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		if(entity instanceof EntityEnderEye)
			return;
		if(entity instanceof EntityFireworkRocket)
			return;
		if(entity instanceof EntityItem)
			return;
		if(entity instanceof EntityXPOrb)
			return;
		if(entity==null)
			return;
		setBlockBounds(0, 0, 0, 1, 1, 1);
		AxisAlignedBB axisalignedbb1 = super.getCollisionBoundingBoxFromPool(world, x, y, z);

        if (axisalignedbb1 != null && axisAlignedBB.intersectsWith(axisalignedbb1))
        {
        	list.add(axisalignedbb1);
        }
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return null;
	}

}
