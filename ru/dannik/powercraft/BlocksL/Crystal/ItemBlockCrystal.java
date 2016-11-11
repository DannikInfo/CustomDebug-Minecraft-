package ru.dannik.powercraft.BlocksL.Crystal;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import ru.dannik.powercraft.BlocksL.BlockList;

public class ItemBlockCrystal extends ItemMultiTexture {

    public ItemBlockCrystal(Block block) {
		super(block, block, Crystal.metadata);
	}

}
