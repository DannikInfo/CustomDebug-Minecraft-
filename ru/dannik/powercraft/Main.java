package ru.dannik.powercraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import ru.dannik.powercraft.BlocksL.BlockList;
import ru.dannik.powercraft.ItemsL.ItemList;
import ru.dannik.powercraft.ItemsL.activationcrystal.Plasm;
import ru.dannik.powercraft.gui.GuiHandler;

@Mod (modid = "powercraftreloaded", name = "PowerCraft Reloaded", version = "1.0")

public class Main {
	@SidedProxy(clientSide = "ru.dannik.powercraft.ClientProxy", serverSide = "ru.dannik.powercraft.CommonProxy")
	public static CommonProxy proxy;
	@Instance("powercraftreloaded")
	public static Main instance;
	
	public static CreativeTabs tabPowerCraft = new TabPowerCraft(CreativeTabs.getNextID(),"Power craft");
	public static final String MODID = "powercraftreloaded";
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		BlockList.Blocks();		  
		ItemList.Items();
		proxy.preInit();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		WorldModGenerator generator = new WorldModGenerator();
		GameRegistry.registerWorldGenerator(generator, 0);
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		
		//Entity
		EntityRegistry.registerModEntity(Plasm.class, "plasm", 0, this, 40, 100, true);
	}	
}
