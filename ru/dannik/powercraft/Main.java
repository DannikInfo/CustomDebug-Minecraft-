package ru.dannik.powercraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.ForgeChunkManager;
import ru.dannik.powercraft.BlocksL.BlockList;
import ru.dannik.powercraft.BlocksL.Chunker.ChunkerCallback;
import ru.dannik.powercraft.ItemsL.ItemList;
import ru.dannik.powercraft.gui.GuiHandler;
import ru.dannik.powercraft.network.PacketDispatcher;

@Mod (modid = "powercraftreloaded", name = "PowerCraft Reloaded", version = "1.0")	//basic info mod

public class Main {
	@SidedProxy(clientSide = "ru.dannik.powercraft.ClientProxy", serverSide = "ru.dannik.powercraft.CommonProxy") 	//proxy registering
	public static CommonProxy proxy;	//initialization proxy variable
	@Instance("powercraftreloaded")		//instance initialization
	public static Main instance;		//or here initialization instance :)
	
	public static CreativeTabs tabPowerCraft = new TabPowerCraft(CreativeTabs.getNextID(),"Power craft");	//initialization 1 creative tab
	public static CreativeTabs tabPowerCraftDeco = new TabPowerCraftDeco(CreativeTabs.getNextID(),"Power craft decoration"); 	//initialization 2 creative tab
	public static final String MODID = "powercraftreloaded";	//initialization mod id
	public static final Logger logger = LogManager.getLogger(MODID);	//initialization logger 
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		BlockList.Blocks(); //adding block list
		Recipe.recipe(); 	//adding inverse vanilla recipe
		ItemList.Items(); 	//adding item list
		proxy.preInit(); 	//get preInit method of proxy
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler()); //register Gui Handler
		WorldModGenerator generator = new WorldModGenerator();	//initialization variable generator
		GameRegistry.registerWorldGenerator(generator, 0); 		//register generator
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		PacketDispatcher.registerPackets(); //adding register list packets
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(); 	//get init method of proxy
	}
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	ForgeChunkManager.setForcedChunkLoadingCallback(instance, new ChunkerCallback()); //oh no this not WORKED TODO: fixing and adding ChunkLoader
    }
	
	public static Main getMod(){
		return instance; 	//return mod container
	}
	
}
