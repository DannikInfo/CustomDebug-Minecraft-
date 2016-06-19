package ru.dannik.powercraft.storage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class InventoryBigCompressor implements IInventory {

	private ItemStack current;//Предмет в котором будет хранить вещи
	private ItemStack[] inventory;//Массив слотов инвентаря в виде ItemStack
	
	public InventoryBigCompressor(ItemStack is) {
		if (!is.hasTagCompound()) is.setTagCompound(new NBTTagCompound());
		current = is;
		load(is);
	}
	
	@Override
	public int getSizeInventory() {
		return inventory.length;//Количество слотов инвентаря
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) {
		return slot >= 0 && slot < inventory.length ? inventory[slot] : null;
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (inventory[slot] != null) {
			ItemStack is;
		
			if (inventory[slot].stackSize <= amount) {
				is = inventory[slot];
				inventory[slot] = null;
				markDirty();
				return is;
			} else {
				is = inventory[slot].splitStack(amount);
				if (inventory[slot].stackSize == 0) inventory[slot] = null;
				markDirty();
				return is;
			}
		} else return null;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (inventory[slot] != null) {
			ItemStack itemstack = inventory[slot];
			inventory[slot] = null;
			return itemstack;
		} else return null;
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack is) {
		inventory[slot] = is;
		
		if (is != null && is.stackSize > getInventoryStackLimit())
			is.stackSize = getInventoryStackLimit();
			markDirty();
	}
	
	@Override
	public String getInventoryName() {
		String Inventory_name = "Big compressor";
		return Inventory_name;//Своё имя
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return true;//Есть-ли своё имя
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;//Лимит размер стака в слоте
	}
	
	@Override
	public void markDirty() {
		//У меня этот метод от 3 и более раза за раз вызывается, так-что я с ним ни чего не делаю.
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		//Может-ли игрок использовать этот инвентарь
		return true;
	}
	
	//Открытие инвентаря
	@Override
	public void openInventory() {
		load();
	}
	
	//Закрытие инвентаря
	@Override
	public void closeInventory() {
		save();
	}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {
		//Можно-ли взаимодействовать со слотом(-ами).
		return true;
	}
	
	//Методы "load" должны из предмета драть нужные теги для простой работы с инвентарём.
	public void load() {
		load(current);
	}
	
	public void load(ItemStack is) {
		load(is.getTagCompound());
	}
	
	public void load(NBTTagCompound nbt) {
		if (nbt != null) {
			NBTTagList nbttaglist = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
			
			//Мне так показалось проще сделать, чем брать значение из "nbttagcompound1.getByte("Slot")"
			//Наш NBT тег из которого будем брать максимальное количества слотов для нашего инвентаря Item Storage
			//Желательно, чтобы размеры инвентаря были [9 * n]
			if (nbt.hasKey("CustomSize", Constants.NBT.TAG_BYTE))
				inventory = new ItemStack[nbt.getByte("CustomSize") & 255];
				//Если нету нужно тега, то замер инвентаря Item Storage будет в 27 слотов.
			else inventory = new ItemStack[(9 * 6)];
			
			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound1.getByte("Slot") & 255;
			
				if (j >= 0 && j < inventory.length)
					inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		
		}
	}
	
	//Методы "save" должны в предмет сохранять инвентарь Item Storage в теги.
	public void save() {
		current = save(current);
	}
	
	public ItemStack save(ItemStack is) {
		if (is != null && current != null) {
			NBTTagCompound nbt = save(current.getTagCompound());
		if (nbt != null) is.setTagCompound(nbt);
			return current;
		}
		return is;
	}
	
	public NBTTagCompound save(NBTTagCompound nbt) {
		if (nbt != null) {
			NBTTagList nbttaglist = new NBTTagList();
		
			nbt.setByte("CustomSize", (byte)getSizeInventory());
		
			for (int i = 0; i < inventory.length; ++i) {
				if (inventory[i] != null) {
					NBTTagCompound nbttagcompound1 = new NBTTagCompound();
					nbttagcompound1.setByte("Slot", (byte)i);
					inventory[i].writeToNBT(nbttagcompound1);
					nbttaglist.appendTag(nbttagcompound1);
				}
			}
			
			nbt.setTag("Items", nbttaglist);
		
		}
		return nbt;
	}
	
	public ItemStack update(EntityPlayer player) {
		//Да - каждый тик будет сохраняться. Но при этом, практически не наблюдался дюп или тупой работы инвентаря.
		return save(player.getCurrentEquippedItem());
	}
}
