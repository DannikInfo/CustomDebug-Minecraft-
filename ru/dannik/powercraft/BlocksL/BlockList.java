package ru.dannik.powercraft.BlocksL;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ru.dannik.powercraft.BlocksL.Crystal.Crystal;
import ru.dannik.powercraft.BlocksL.Crystal.ItemBlockCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.TileEntityCrystal;
import ru.dannik.powercraft.BlocksL.Laser.Laser;
import ru.dannik.powercraft.BlocksL.Laser.TileEntityLaser;
import ru.dannik.powercraft.BlocksL.Teleporter.Teleporter;
import ru.dannik.powercraft.BlocksL.Teleporter.TileEntityTeleporter;
import ru.dannik.powercraft.BlocksL.deco.Chimeny.Chimeny;
import ru.dannik.powercraft.BlocksL.deco.Chimeny.ItemBlockChimeny;
import ru.dannik.powercraft.BlocksL.deco.Chimeny.TileEntityChimeny;
import ru.dannik.powercraft.BlocksL.deco.IronFrame.IronFrame;
import ru.dannik.powercraft.BlocksL.deco.IronFrame.TileEntityIronFrame;
import ru.dannik.powercraft.BlocksL.logic.SettingsBlock;
import ru.dannik.powercraft.BlocksL.logic.Spawner;
import ru.dannik.powercraft.BlocksL.logic.SpecialController;
import ru.dannik.powercraft.BlocksL.logic.Detector.Detector;
import ru.dannik.powercraft.BlocksL.logic.Detector.DetectorOff;
import ru.dannik.powercraft.BlocksL.logic.Detector.ItemBlockDetector;
import ru.dannik.powercraft.BlocksL.logic.Detector.TileEntityDetector;
import ru.dannik.powercraft.BlocksL.logic.Detector.TileEntityDetectorOff;
import ru.dannik.powercraft.BlocksL.logic.Pulsar.Pulsar;
import ru.dannik.powercraft.BlocksL.logic.Pulsar.PulsarOff;
import ru.dannik.powercraft.BlocksL.logic.Pulsar.TileEntityPulsar;
import ru.dannik.powercraft.BlocksL.machine.Harvester;

public class BlockList {
	//Create variable for block
	
	public static Block teleporter;
	public static Block ironframe;
	public static Block crystal;
	public static Block harvester;
	public static Block spawner;
	public static Block special_controller;
	public static Block pulsar;
	public static Block pulsaroff;
	//public static Block chunker; добавлю в будущих обновлениях
	public static Block laser;
	public static Block chimeny;
	public static Block detector;
	public static Block detectoroff;
	public static Block settingsblock;
	
	public static void Blocks(){
		
		//Присвоение переменных 
		
		teleporter = new Teleporter();
		ironframe = new IronFrame();
		crystal = new Crystal();
		harvester = new Harvester();
		spawner = new Spawner();
		special_controller = new SpecialController();
		pulsar = new Pulsar();
		pulsaroff = new PulsarOff();
		//chunker = new Chunker();
		laser = new Laser();
		chimeny = new Chimeny();
		detector = new Detector();
		detectoroff = new DetectorOff();
		settingsblock = new SettingsBlock();
		
		//Регистрация блоков в игре
		
		GameRegistry.registerBlock(teleporter, "teleporter");
		GameRegistry.registerBlock(ironframe, "ironframe");
		GameRegistry.registerBlock(crystal, ItemBlockCrystal.class, "crystal");
		GameRegistry.registerBlock(harvester, "harvester");
		GameRegistry.registerBlock(spawner, "spawner");
		GameRegistry.registerBlock(special_controller, "specialcontroller");
		GameRegistry.registerBlock(pulsar, "redstonepulsar");
		GameRegistry.registerBlock(pulsaroff, "redstonepulsaroff");
		//GameRegistry.registerBlock(chunker, "chunk loader");
		GameRegistry.registerBlock(laser, "laser");
		GameRegistry.registerBlock(chimeny, ItemBlockChimeny.class, "chimeny");
		GameRegistry.registerBlock(detector, ItemBlockDetector.class, "detector");
		GameRegistry.registerBlock(detectoroff, ItemBlockDetector.class, "detectoroff");
		GameRegistry.registerBlock(settingsblock, "SettingsBlock");
		
		//Регистрация TileEntity
		
		GameRegistry.registerTileEntity(TileEntityTeleporter.class, "TileEntityPowerPortal");
		GameRegistry.registerTileEntity(TileEntityIronFrame.class, "TileEntityIronFrame");
		GameRegistry.registerTileEntity(TileEntityCrystal.class, "TileEntityCrystal");
		//GameRegistry.registerTileEntity(TileEntityChunker.class, "TileEntityChunker");
		GameRegistry.registerTileEntity(TileEntityLaser.class, "TileEntityLaser");
		GameRegistry.registerTileEntity(TileEntityChimeny.class, "TileEntityChimeny");
		GameRegistry.registerTileEntity(TileEntityPulsar.class, "TileEntityPulsar");
		GameRegistry.registerTileEntity(TileEntityDetector.class, "TileEntityDetector");
		GameRegistry.registerTileEntity(TileEntityDetectorOff.class, "TileEntityDetectorOff");
		
		//Рецепты крафта
		
		GameRegistry.addRecipe(new ItemStack(teleporter, 1), new Object[]{ " E ", "ECE", "###", '#', Items.iron_ingot, 'E', Items.ender_pearl, 'C', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(ironframe, 4), new Object[]{ "###", "# #", "###", '#', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(spawner, 1), new Object[]{ "#B#", "BDB", "#B#", '#', Blocks.iron_bars, 'B', Blocks.cobblestone_wall, 'D', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(special_controller, 1), new Object[]{ "RRR", "SRS", "###", '#', Items.iron_ingot, 'R', Items.redstone, 'S', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(pulsar, 1), new Object[]{ "#R#", "ROR", "#R#", '#', Items.iron_ingot, 'R', Items.redstone, 'O', Blocks.obsidian});
		
		//Локализация в игре
		
		LanguageRegistry.addName(teleporter, "Teleporter");
		LanguageRegistry.addName(ironframe, "Iron frame");
		LanguageRegistry.addName(harvester, "Harvester");
		LanguageRegistry.addName(spawner, "Spawner");
		LanguageRegistry.addName(special_controller, "Special controller");
		LanguageRegistry.addName(pulsar, "Redstone pulsar");
		//LanguageRegistry.addName(chunker, "Chunk loader");
		LanguageRegistry.addName(laser, "Laser");
		LanguageRegistry.addName(settingsblock, "Settings block");
	}
}
