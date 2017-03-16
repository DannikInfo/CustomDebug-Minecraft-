package ru.dannik.powercraft.gui;

import org.apache.commons.codec.digest.DigestUtils;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.dannik.powercraft.gui.Gui.GuiBigCompressor;
import ru.dannik.powercraft.gui.Gui.GuiCompressor;
import ru.dannik.powercraft.gui.Gui.GuiDetector;
import ru.dannik.powercraft.gui.Gui.GuiHighStackCompressor;
import ru.dannik.powercraft.gui.Gui.GuiPulsar;
import ru.dannik.powercraft.gui.Gui.GuiSpawner;
import ru.dannik.powercraft.gui.Gui.GuiTeleporter;
import ru.dannik.powercraft.gui.Gui.GuiTeleporterSettings;
import ru.dannik.powercraft.gui.Gui.GuiTeleporterShift;
import ru.dannik.powercraft.gui.container.ContainerBigCompressor;
import ru.dannik.powercraft.gui.container.ContainerCompressor;
import ru.dannik.powercraft.gui.container.ContainerDetector;
import ru.dannik.powercraft.gui.container.ContainerHighStackCompressor;
import ru.dannik.powercraft.gui.container.ContainerPulsar;
import ru.dannik.powercraft.gui.container.ContainerSpawner;
import ru.dannik.powercraft.gui.container.ContainerTeleporter;
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
                return new ContainerTeleporter();
        	case 5:
        		return new ContainerSpawner();
        	case 6:
        		return new ContainerTeleporter();
        	case 7:
        		return new ContainerTeleporter();
        	case 8:
        		return new ContainerDetector();
        	case 9:
        		return new ContainerPulsar();
        	default:
                return null;
        }
    }
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
    	ItemStack current = player.getCurrentEquippedItem();
		String sX = Integer.toString(x);
		String sY = Integer.toString(y);
		String sZ = Integer.toString(z);
		String preUdid = DigestUtils.md5Hex(sX)+DigestUtils.md5Hex(sY)+DigestUtils.md5Hex(sZ); 
		String udid = DigestUtils.md5Hex(preUdid);
    	switch(id){//В зависимости от id выбираем gui        
        	case 1:      
            	return new GuiCompressor(player, new InventoryCompressor(current));
            case 2:
            	return new GuiBigCompressor(player, new InventoryBigCompressor(current));
            case 3:
            	return new GuiHighStackCompressor(player, new InventoryHighStackCompressor(current));
            case 4:
            	return new GuiTeleporter(player, udid);
            case 5:
            	return new GuiSpawner(player, world, x, y, z);
            case 6:
            	return new GuiTeleporterSettings(player, udid);
            case 7:
            	return new GuiTeleporterShift(player, udid);
            case 8:
            	return new GuiDetector(player, world, x, y, z);
            case 9:
            	return new GuiPulsar();
            default:
                return null;
        }
    }
}