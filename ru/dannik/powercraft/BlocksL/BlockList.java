package ru.dannik.powercraft.BlocksL;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ru.dannik.powercraft.BlocksL.Crystal.Cyan.CyanCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Cyan.TileEntityCyanCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.DarkBlue.DarkBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.DarkBlue.TileEntityDarkBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Green.GreenCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Green.TileEntityGreenCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.LightBlue.LightBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.LightBlue.TileEntityLightBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Orange.OrangeCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Orange.TileEntityOrangeCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Purple.PurpleCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Purple.TileEntityPurpleCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Red.RedCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Red.TileEntityRedCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Yellow.TileEntityYellowCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Yellow.YellowCrystal;
import ru.dannik.powercraft.BlocksL.Harvester.Harvester;
import ru.dannik.powercraft.BlocksL.IronFrame.IronFrame;
import ru.dannik.powercraft.BlocksL.IronFrame.TileEntityIronFrame;
import ru.dannik.powercraft.BlocksL.Teleporter.PowerPortal;
import ru.dannik.powercraft.BlocksL.Teleporter.TileEntityPowerPortal;
import ru.dannik.powercraft.BlocksL.logic.SpecialController;
import ru.dannik.powercraft.ItemsL.activationcrystal.Spawner;

public class BlockList {
	//Create variable for block
	
	public static Block powerportal;
	public static Block ironframe;
	public static Block lightbluecrystal;
	public static Block redcrystal;
	public static Block greencrystal;
	public static Block darkbluecrystal;
	public static Block purplecrystal;
	public static Block orangecrystal;
	public static Block cyancrystal;
	public static Block yellowcrystal;
	public static Block harvester;
	public static Block spawner;
	public static Block special_controller;
	//public static Block redstone_tick;
	
	public static void Blocks(){
		
		//Присвоение переменных 
		
		powerportal = new PowerPortal();
		ironframe = new IronFrame();
		lightbluecrystal = new LightBlueCrystal();
		redcrystal = new RedCrystal();
		greencrystal = new GreenCrystal();
		darkbluecrystal = new DarkBlueCrystal();
		purplecrystal = new PurpleCrystal();
		orangecrystal = new OrangeCrystal();
		cyancrystal = new CyanCrystal();
		yellowcrystal = new YellowCrystal();
		harvester = new Harvester();
		spawner = new Spawner();
		special_controller = new SpecialController();
		//redstone_tick = new RedstoneTick();
		
		//Регистрация блоков в игре
		
		GameRegistry.registerBlock(powerportal, "powerportal");
		GameRegistry.registerBlock(ironframe, "ironframe");
		GameRegistry.registerBlock(lightbluecrystal, "lightbluecrystal");
		GameRegistry.registerBlock(redcrystal, "redcrystal");
		GameRegistry.registerBlock(greencrystal, "greencrystal");
		GameRegistry.registerBlock(darkbluecrystal, "darkbluecrystal");
		GameRegistry.registerBlock(purplecrystal, "purplecrystal");
		GameRegistry.registerBlock(orangecrystal, "orangecrystal");
		GameRegistry.registerBlock(cyancrystal, "cyancrystal");
		GameRegistry.registerBlock(yellowcrystal, "yellowcrystal");
		GameRegistry.registerBlock(harvester, "harvester");
		GameRegistry.registerBlock(spawner, "spawner");
		GameRegistry.registerBlock(special_controller, "specialcontroller");
		//GameRegistry.registerBlock(redstone_tick, "redstonetick");
		
		//Регистрация TileEntity
		
		GameRegistry.registerTileEntity(TileEntityPowerPortal.class, "TileEntityPowerPortal");
		GameRegistry.registerTileEntity(TileEntityIronFrame.class, "TileEntityIronFrame");
		GameRegistry.registerTileEntity(TileEntityLightBlueCrystal.class, "TileEntityLightBlueCrystal");
		GameRegistry.registerTileEntity(TileEntityRedCrystal.class, "TileEntityRedCrystal");
		GameRegistry.registerTileEntity(TileEntityGreenCrystal.class, "TileEntityGreenCrystal");
		GameRegistry.registerTileEntity(TileEntityDarkBlueCrystal.class, "TileEntityDarkBlueCrystal");
		GameRegistry.registerTileEntity(TileEntityPurpleCrystal.class, "TileEntityPurpleCrystal");
		GameRegistry.registerTileEntity(TileEntityOrangeCrystal.class, "TileEntityOrangeCrystal");
		GameRegistry.registerTileEntity(TileEntityCyanCrystal.class, "TileEntityCyanCrystal");
		GameRegistry.registerTileEntity(TileEntityYellowCrystal.class, "TileEntityYellowCrystal");
		
		//Рецепты крафта
		
		GameRegistry.addRecipe(new ItemStack(powerportal, 1), new Object[]{ " E ", "ECE", "###", '#', Items.iron_ingot, 'E', Items.ender_pearl, 'C', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(ironframe, 4), new Object[]{ "###", "# #", "###", '#', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(spawner, 1), new Object[]{ "#B#", "BDB", "#B#", '#', Blocks.iron_bars, 'B', Blocks.cobblestone_wall, 'D', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(special_controller, 1), new Object[]{ "RRR", "SRS", "###", '#', Items.iron_ingot, 'R', Items.redstone, 'S', Blocks.stone});
		//GameRegistry.addRecipe(new ItemStack(redstone_tick, 1), new Object[]{ "#R#", "ROR", "#R#", '#', Items.iron_ingot, 'R', Items.redstone, 'O', Blocks.obsidian});
		//Локализация в игре
		
		LanguageRegistry.addName(powerportal, "Teleporter");
		LanguageRegistry.addName(ironframe, "Iron frame");
		LanguageRegistry.addName(lightbluecrystal, "Lightblue crystal");
		LanguageRegistry.addName(redcrystal, "Red crystal");
		LanguageRegistry.addName(greencrystal, "Green crystal");
		LanguageRegistry.addName(darkbluecrystal, "Darkblue crystal");
		LanguageRegistry.addName(purplecrystal, "Purple crystal");
		LanguageRegistry.addName(orangecrystal, "Orange crystal");
		LanguageRegistry.addName(cyancrystal, "Cyan crystal");
		LanguageRegistry.addName(yellowcrystal, "Yellow crystal");
		LanguageRegistry.addName(harvester, "Harvester");
		LanguageRegistry.addName(spawner, "Spawner");
		LanguageRegistry.addName(special_controller, "Special controller");
		//LanguageRegistry.addName(redstone_tick, "Redstone tick");
	}
}
