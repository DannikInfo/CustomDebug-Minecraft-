package ru.dannik.powercraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import ru.dannik.powercraft.items.ItemList;

public class TabPowerCraftDeco extends CreativeTabs{
	
	public World world;
	
	public TabPowerCraftDeco(int position, String tabID){
		super(position, tabID);
	}
	 
	public String getTranslatedTabLabel(){
		return "Power Craft decoration";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem(){
		return ItemList.CraftingTool;
	}
}
