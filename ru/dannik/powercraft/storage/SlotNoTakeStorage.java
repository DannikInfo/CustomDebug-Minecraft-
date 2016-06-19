package ru.dannik.powercraft.storage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotNoTakeStorage extends Slot {

public SlotNoTakeStorage(IInventory inv, int id, int x, int y) {
	super(inv, id, x, y);
	}
	
	//Нельзя взять из этого слота, если это находиться в руке игрока.
	//Хотя по стандарту, можно только для хот-бара, но я не уверен на счёт других модов.
	@Override
	public boolean canTakeStack(EntityPlayer player) {
		ItemStack is = inventory.getStackInSlot(getSlotIndex());
		if (is != null && is == player.getCurrentEquippedItem()) return false;
		return super.canTakeStack(player);
	}

}