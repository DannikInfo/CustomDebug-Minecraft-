package ru.dannik.powercraft.BlocksL.Crystal;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;

public class Crystal extends Block implements ITileEntityProvider {

    public static final String[] metadata = new String[] {
            "Cyan",
            "DarkBlue",
            "Green",
            "LightBlue",
            "Orange",
            "Purple",
            "Red",
            "Yellow",  
        };
	
	public Crystal() {
		super(Material.glass);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(1F);
		setBlockTextureName("glass");
		setBlockName(Main.MODID + ".Crystal");
		
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
		return new TileEntityCrystal();
	}

	public int getRenderType() {
		return -1;
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
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (int j = 0; j < metadata.length; ++j) {
            
            list.add(new ItemStack(item, 1, j));
            
        }
    }

}
