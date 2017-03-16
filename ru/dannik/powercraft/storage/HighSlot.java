package ru.dannik.powercraft.storage;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class HighSlot extends Slot{
    public HighSlot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }
    
    
    public int getSlotStackLimit() {
        return 512;
    }
    
    public boolean isItemValid(ItemStack par1ItemStack) {
        return true;
    }

}