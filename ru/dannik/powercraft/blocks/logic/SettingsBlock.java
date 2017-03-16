package ru.dannik.powercraft.blocks.logic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.blocks.BlockList;
import ru.dannik.powercraft.items.ItemList;

public class SettingsBlock extends Block{

	public SettingsBlock(){
		super(Material.iron);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(0.25F);
		setBlockTextureName("cobblestone");
		setBlockName(Main.MODID + ".SettingsBlock");
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
	    if(!world.isRemote){
	    	 ItemStack currentItem = player.getCurrentEquippedItem();    	
	    	 if(currentItem != null && currentItem.getItem() == ItemList.ActivationCrystal){
	    		 Block mechX = world.getBlock(x + 1, y, z);
	    		 Block mechY = world.getBlock(x, y + 1, z);
	    		 Block mechZ = world.getBlock(x, y, z + 1);
	    		 Block mechXD = world.getBlock(x - 1, y, z);
	    		 Block mechYD = world.getBlock(x, y - 1, z);
	    		 Block mechZD = world.getBlock(x, y, z - 1);
	    		 if(mechX == BlockList.pulsar){player.openGui(Main.instance, 9, world, x, y, z);}
	    		 if(mechY == BlockList.pulsar){player.openGui(Main.instance, 9, world, x, y, z);}
	    		 if(mechZ == BlockList.pulsar){player.openGui(Main.instance, 9, world, x, y, z);}
	    		 if(mechXD == BlockList.pulsar){player.openGui(Main.instance, 9, world, x, y, z);}
	    		 if(mechYD == BlockList.pulsar){player.openGui(Main.instance, 9, world, x, y, z);}
	    		 if(mechZD == BlockList.pulsar){player.openGui(Main.instance, 9, world, x, y, z);}
	    		 player.openGui(Main.instance, 9, world, x, y, z);
	    	 }
	    }
		return true;
	}
}