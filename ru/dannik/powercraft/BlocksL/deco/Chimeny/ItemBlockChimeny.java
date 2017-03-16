package ru.dannik.powercraft.BlocksL.deco.Chimeny;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import ru.dannik.powercraft.BlocksL.BlockList;

public class ItemBlockChimeny extends ItemMultiTexture {

    public ItemBlockChimeny(Block block) {
		super(block, block, Chimeny.metadata);
	}

}
