package ru.dannik.powercraft.BlocksL.logic.Detector;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import ru.dannik.powercraft.BlocksL.BlockList;

public class ItemBlockDetector extends ItemMultiTexture {

    public ItemBlockDetector(Block block) {
		super(block, block, Detector.metadata);
	}

}

