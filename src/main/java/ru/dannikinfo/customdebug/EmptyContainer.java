package ru.dannikinfo.customdebug;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class EmptyContainer extends Container{
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
