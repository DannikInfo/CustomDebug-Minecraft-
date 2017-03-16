package ru.dannik.powercraft.blocks.crystal;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import ru.dannik.powercraft.blocks.BlockList;

public class ItemBlockCrystal extends ItemMultiTexture {

    public ItemBlockCrystal(Block block) {
		super(block, block, Crystal.metadata);
	}

}
