package ru.dannik.powercraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipe {
	
	public static void recipe(){
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 2), new Object[]{  "##", "##", '#', Items.stick});
	}
	
}
