package ru.dannik.powercraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.dannik.powercraft.Main;

public class CorePortal extends Item{

	protected CorePortal(){
		this.setCreativeTab(Main.tabPowerCraft);
		this.setTextureName("powercraftreloaded:CorePortal");
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
	
}
