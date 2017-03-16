package ru.dannik.powercraft.items;



import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.gui.container.ContainerBigCompressor;

public class BigCompressor extends Item{
	
	protected BigCompressor(){
		this.setCreativeTab(Main.tabPowerCraft);
		this.setTextureName("powercraftreloaded:BigCompressor");
		maxStackSize = 1;
	}

		public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
			if (player.isSneaking()) {

			} else {
				player.openGui(Main.instance, 2, world, (int)player.posX, (int)player.posY, (int)player.posZ);
				//Где "id" - это ид вашего окна.
			}
			return super.onItemRightClick(is, world, player);
		}

		@SideOnly(Side.CLIENT)
		public void getSubItems(Item id, CreativeTabs table, List list) {
			//list.add(new ItemStack(id, 1, 0));
			list.add(addNBT(id, size_storage.SIZE6));
		}
		
		public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
			NBTTagCompound nbt = is.getTagCompound();
			if (nbt != null && nbt.hasKey("CustomSize")) list.add("Slots: " + (int)(nbt.getByte("CustomSize") & 255) + ".");
		}

		public static ItemStack addNBT(Item item, size_storage size) {
			return addNBT(new ItemStack(item, 1, 0), size);
		}

		public static ItemStack addNBT(ItemStack is, size_storage size) {
			return addNBT(is, size.getSize());
		}

		public static ItemStack addNBT(ItemStack is, int size) {
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setByte("CustomSize", (byte)size);
			is.setTagCompound(nbt);
			return is;
		}

		public static enum size_storage {

			SIZE6(54);//(9 * 6)//размеры как у двойного сундука

			private int size;

			size_storage(int size) {
				this.size = size;
			}

			public int getSize() {
				return size;
			}

		}
		@Override
		public void onUpdate(ItemStack is, World world, Entity entity, int tick, boolean flag) {
			if (!world.isRemote && entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entity;
				ItemStack current = player.getCurrentEquippedItem();
				Container con = player.openContainer;
				if (con != null) {
			//-----------------------------------------------------------------------------------
					if (con instanceof ContainerBigCompressor) {
						ContainerBigCompressor bc = (ContainerBigCompressor)con;
						ItemStack new_is = bc.update(player);
						if (new_is != null) current = new_is;
						//Закрытия окна, в случаи если предмета нет нужного нам предмета.
						if (new_is == null || !(new_is != null))
							player.closeScreen();
					}
			//------------------------------------------------------------------------------------
				}
			}
		}

}
