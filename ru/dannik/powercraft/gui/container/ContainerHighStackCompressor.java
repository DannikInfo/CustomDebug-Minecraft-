package ru.dannik.powercraft.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.dannik.powercraft.storage.HighSlot;
import ru.dannik.powercraft.storage.InventoryHighStackCompressor;

public class ContainerHighStackCompressor extends Container {

	private InventoryHighStackCompressor inv;
	private int numRows;
		
	public ContainerHighStackCompressor(EntityPlayer player, InventoryHighStackCompressor invent) {
		inv = invent;
		inv.openInventory();//Типа инициализируем открытия инвентаря
		numRows = inv.getSizeInventory() / 9;
		int i = (numRows - 4) * 18;
		int j;
		int k;

		//Слоты инвентаря Item Storage
        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 3; ++j)
            {
                this.addSlotToContainer(new HighSlot(inv, j + i * 3, 62 + j * 18, 17 + i * 18));
            }
        }

		//Слоты инвентаря игрока
        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

		//Слоты хот-бара игрока

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return inv.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_i) {
		ItemStack is = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if (slot != null && slot.getHasStack()) {
			ItemStack is1 = slot.getStack();
			is = is1.copy();

			//if (is1.getItem() instanceof IItemStorage) return null;

			if (slot_i < inv.getSizeInventory()) {
				if (!mergeItemStack(is1, inv.getSizeInventory(), inventorySlots.size(), true)) return null;
				} else if (!mergeItemStack(is1, 0, inv.getSizeInventory(), false))
					return null;
	
			if (is1.stackSize == 0) slot.putStack((ItemStack)null);
			else slot.onSlotChanged();
		}

		return is;
	}

	@Override
	public ItemStack slotClick(int slot, int button, int modifier, EntityPlayer player) {
		if (player == null) return null;
		if (modifier == 2) return null;//Блокируем возможность использование игроком цифровых кнопок, чтобы не было попытки подмены
		return super.slotClick(slot, button, modifier, player);
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		inv.closeInventory();//Типа инициализируем закрытия инвентаря
	}

	public ItemStack update(EntityPlayer player) {
		return (inv != null && player.getCurrentEquippedItem() != null) ? inv.update(player) : null;
	}

}