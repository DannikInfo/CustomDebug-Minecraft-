package ru.dannik.powercraft;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;

public class CommonProxy {

	public void preInit() {
		// TODO Auto-generated method stub
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Returns a side-appropriate EntityPlayer for use during message handling
	 */
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}
}
