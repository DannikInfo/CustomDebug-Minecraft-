package ru.dannik.powercraft.blocks.deco.chimeny;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import ru.dannik.powercraft.blocks.BlockList;

public class ItemBlockChimeny extends ItemMultiTexture {

    public ItemBlockChimeny(Block block) {
		super(block, block, Chimeny.metadata);
	}

}
