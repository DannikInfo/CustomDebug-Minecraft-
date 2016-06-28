package ru.dannik.powercraft.ItemsL;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.gui.ContainerCraftingTool;

public class EnderCompressor extends Item{

	protected EnderCompressor(){
		this.setCreativeTab(Main.tabPowerCraft);
		this.setTextureName("powercraftreloaded:EnderCompressor");
		maxStackSize = 1;
	}
	
	public boolean onRightItemClick(ItemStack is, EntityPlayer player, World world, int x, int y, int z){
        InventoryEnderChest inventoryenderchest = player.getInventoryEnderChest();
        TileEntityEnderChest tileentityenderchest = (TileEntityEnderChest)world.getTileEntity(x, y, z);

        if (inventoryenderchest != null && tileentityenderchest != null)
        {
            if (world.getBlock(x, y + 1, z).isNormalCube())
            {
                return true;
            }
            else if (world.isRemote)
            {
                return true;
            }
            else
            {
                inventoryenderchest.func_146031_a(tileentityenderchest);
                player.displayGUIChest(inventoryenderchest);
                return true;
            }
        }
        else
        {
            return true;
        }
	}
}
