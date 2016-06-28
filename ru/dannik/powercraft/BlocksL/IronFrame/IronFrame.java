package ru.dannik.powercraft.BlocksL.IronFrame;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;

public class IronFrame extends Block implements ITileEntityProvider {

	public IronFrame() {
		super(Material.iron);
		setCreativeTab(Main.tabPowerCraft);
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

}
