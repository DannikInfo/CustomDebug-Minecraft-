package ru.dannik.powercraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.dannik.powercraft.blocks.BlockList;

public class ItemList {
	
	//create variable for item
	
	public static Item ActivationCrystal;
	public static Item CraftingTool;
	//public static Item OreSniffer;
	//public static Item RadioRemote;
	//public static Item LaserCompositionBlue;
	//public static Item LaserCompositionRed;
	//public static Item LaserCompositionGreen;
	public static Item Compressor;
	public static Item EnderCompressor;
	public static Item HighStackCompressor;
	public static Item BigCompressor;
	public static Item Transistor;
	public static Item Silicon;
	public static Item PowerDust;
	public static Item SlimeBoots;
	public static Item HoloLens;
	public static Item CorePortal;
	
	public static void Items(){
		
		//set name if not localization
		
		ActivationCrystal = new ActivationCrystal().setUnlocalizedName("Activation crystal");
		CraftingTool = new CraftingTool().setUnlocalizedName("Crafting tool");
		//OreSniffer = new OreSniffer().setUnlocalizedName("Ore sniffer");
		//RadioRemote = new RadioRemote().setUnlocalizedName("Radio remote");
		//LaserCompositionBlue = new LaserCompositionBlue().setUnlocalizedName("Laser composition blue");
		//LaserCompositionRed = new LaserCompositionRed().setUnlocalizedName("Laser composition red");
		//LaserCompositionGreen = new LaserCompositionGreen().setUnlocalizedName("Laser composition green");
		Compressor = new Compressor().setUnlocalizedName("Compressor");
		EnderCompressor = new EnderCompressor().setUnlocalizedName("Ender compressor");
		HighStackCompressor = new HighStackCompressor().setUnlocalizedName("High stack compressor");
		BigCompressor = new BigCompressor().setUnlocalizedName("BigCompressor");
		Transistor = new Transistor().setUnlocalizedName("Transistor");
		Silicon = new Silicon().setUnlocalizedName("silicon");
		PowerDust = new PowerDust().setUnlocalizedName("Power dust");
		SlimeBoots = new SlimeBoots(0, 3).setUnlocalizedName("Slime Boots").setTextureName("powercraftreloaded:SlimeBoots");
		HoloLens = new HoloLens(0, 0).setUnlocalizedName("NightVision glasses").setTextureName("powercraftreloaded:HoloLens");
		CorePortal = new CorePortal().setUnlocalizedName("Core portal");
		
		//register items in game
		
		GameRegistry.registerItem(ActivationCrystal, "activationcrystal");
		GameRegistry.registerItem(CraftingTool, "craftingtool");
		//GameRegistry.registerItem(OreSniffer, "oresniffer");
		//GameRegistry.registerItem(RadioRemote, "radioremote");
		//GameRegistry.registerItem(LaserCompositionBlue, "lasercompositionblue");
		//GameRegistry.registerItem(LaserCompositionRed, "lasercompositionred");
		//GameRegistry.registerItem(LaserCompositionGreen, "lasercompositiongreen");
		GameRegistry.registerItem(Compressor, "compressor");
		GameRegistry.registerItem(EnderCompressor, "endercompressor");
		GameRegistry.registerItem(HighStackCompressor, "highstackcompressor");
		GameRegistry.registerItem(BigCompressor, "bigcompressor");
		GameRegistry.registerItem(Transistor, "transistor");
		GameRegistry.registerItem(Silicon, "silicon");
		GameRegistry.registerItem(PowerDust, "powerdust");
		GameRegistry.registerItem(SlimeBoots, "slimeboots");
		GameRegistry.registerItem(HoloLens, "hololens");
		GameRegistry.registerItem(CorePortal, "coreportal");

		//add recipe in game
		
		//===recipe ActivationCrystal
		
		GameRegistry.addRecipe(new ItemStack(ActivationCrystal, 1), new Object[]{ "#X#", "RYR", " # ", 'X', BlockList.crystal, '#', Items.iron_ingot, 'Y', Items.diamond, 'R', Items.redstone});
     
		//===other item recipe
        
        GameRegistry.addRecipe(new ItemStack(CraftingTool, 1), new Object[]{ "#R#", "RXR", "#R#", 'X', Blocks.iron_block, '#', Blocks.crafting_table, 'R', Items.redstone});
        GameRegistry.addRecipe(new ItemStack(Compressor, 1), new Object[]{ "#R#", "ARA", "#R#", 'A', Blocks.piston, '#', Blocks.lever, 'R', Blocks.chest});
        GameRegistry.addRecipe(new ItemStack(EnderCompressor, 1), new Object[]{ "#R#", "ADA", "#R#", 'A', Blocks.piston, 'D', Items.diamond, '#', Blocks.lever, 'R', Blocks.ender_chest});
        GameRegistry.addRecipe(new ItemStack(BigCompressor, 1), new Object[]{ "#R#", "ADA", "#R#", 'A', Blocks.piston, 'D', Items.diamond, '#', Blocks.lever, 'R', Blocks.chest});
        GameRegistry.addRecipe(new ItemStack(HighStackCompressor, 1), new Object[]{ "ARA", "ADA", "ARA", 'A', Blocks.piston, 'D', Items.diamond, 'R', Blocks.ender_chest});
        GameRegistry.addShapelessRecipe(new ItemStack(SlimeBoots, 1), new Object[] {Items.iron_boots, Items.slime_ball, Items.slime_ball, Items.slime_ball});
        GameRegistry.addRecipe(new ItemStack(HoloLens, 1), new Object[]{ "III", "GBG", "I I", 'I', Items.iron_ingot, 'G', Blocks.glass, 'B', Items.golden_apple});
        GameRegistry.addRecipe(new ItemStack(CorePortal, 1), new Object[]{ "ORO", "RDR", "ORO", 'O', Blocks.obsidian, 'R', Items.redstone, 'D', Items.diamond});
        
        //===power dust recipe
        
       GameRegistry.addShapelessRecipe(new ItemStack(PowerDust, 4), new Object[] {BlockList.crystal});
        

		//localization in game
		
		LanguageRegistry.addName(ActivationCrystal, "Activation crystal");
		LanguageRegistry.addName(CraftingTool, "Crafting tool");
		//LanguageRegistry.addName(OreSniffer, "Ore sniffer");
		//LanguageRegistry.addName(RadioRemote, "Radio remote");
		//LanguageRegistry.addName(LaserCompositionBlue, "Laser composition blue");
		//LanguageRegistry.addName(LaserCompositionRed, "Laser composition red");
		//LanguageRegistry.addName(LaserCompositionGreen, "Laser composition green");
		LanguageRegistry.addName(Compressor, "Compressor");
		LanguageRegistry.addName(EnderCompressor, "Ender compressor");
		LanguageRegistry.addName(HighStackCompressor, "High stack compressor");
		LanguageRegistry.addName(BigCompressor, "Big compressor");
		LanguageRegistry.addName(Transistor, "Transistor");
		LanguageRegistry.addName(Silicon, "silicon");
		LanguageRegistry.addName(PowerDust, "Power dust");
		LanguageRegistry.addName(SlimeBoots, "Slime boots");
		LanguageRegistry.addName(HoloLens, "Night Vision Glasses");
		LanguageRegistry.addName(CorePortal, "Portal core");
	}

}