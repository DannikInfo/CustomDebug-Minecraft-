package ru.dannik.powercraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.world.World;

public class ContainerCraftingTool extends ContainerWorkbench
{
    public ContainerCraftingTool(InventoryPlayer p_i1808_1_, World p_i1808_2_, int p_i1808_3_, int p_i1808_4_, int p_i1808_5_) {
		super(p_i1808_1_, p_i1808_2_, p_i1808_3_, p_i1808_4_, p_i1808_5_);
	}

	public boolean canInteractWith(EntityPlayer player) {
    	return true;
    }
}
