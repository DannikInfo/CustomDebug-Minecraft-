package ru.dannik.powercraft.blocks.logic.detector;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import ru.dannik.powercraft.blocks.BlockList;

public class ItemBlockDetector extends ItemMultiTexture {

    public ItemBlockDetector(Block block) {
		super(block, block, Detector.metadata);
	}

}

