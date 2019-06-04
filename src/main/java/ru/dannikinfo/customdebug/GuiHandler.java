package ru.dannikinfo.customdebug;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
    	switch(id){ 
        	default:
                return null;
        }
    }
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
    	switch(id){     
        	case 1:      
            	return new GuiSettings();
        	default:
                return null;
        }
    }
}