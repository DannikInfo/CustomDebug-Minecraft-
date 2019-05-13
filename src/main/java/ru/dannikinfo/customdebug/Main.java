package ru.dannikinfo.customdebug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = "customdebug", name = "Custom debug", version = "1.2")

public class Main {

	@SidedProxy(clientSide = "ru.dannikinfo.customdebug.ClientProxy") 	//proxy registering
	public static ClientProxy proxy;	//initialization proxy variable
	@Instance("customdebug")		//instance initialization
	public static Main instance;		//or here initialization instance :)
	public static final String MODID = "customdebug";	//initialization mod id
	public static final Logger logger = LogManager.getLogger(MODID);	//initialization logger 
	
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		proxy.preInit(); 	//get preInit method of proxy
	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(); 	//get init method of proxy
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
	
	public static Main getMod(){
		return instance; 	//return mod container
	}
	
}

