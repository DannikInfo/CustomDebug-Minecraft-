package ru.dannik.powercraft.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.dannik.powercraft.storage.InventoryBigCompressor;
import ru.dannik.powercraft.storage.InventoryCompressor;
import ru.dannik.powercraft.storage.InventoryHighStackCompressor;

public class GuiHandler implements IGuiHandler{
	
	
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
    	 ItemStack current = player.getCurrentEquippedItem();
    	switch(id){//В зависимости от id выбираем контейнер   
        	case 1:
                return new ContainerCompressor(player, new InventoryCompressor(current));
        	case 2:
                return new ContainerBigCompressor(player, new InventoryBigCompressor(current));
        	case 3:
                return new ContainerHighStackCompressor(player, new InventoryHighStackCompressor(current));
        	case 4:
                return new ContainerPowerPortal();
            default:
                return null;
        }
    }
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
    	ItemStack current = player.getCurrentEquippedItem();
    	switch(id){//В зависимости от id выбираем gui        
        	case 1:      
            	return new GuiCompressor(player, new InventoryCompressor(current));
            case 2:
            	return new GuiBigCompressor(player, new InventoryBigCompressor(current));
            case 3:
            	return new GuiHighStackCompressor(player, new InventoryHighStackCompressor(current));
            case 4:
            	return new GuiPowerPortal(player);
            default:
                return null;
        }
    }
}