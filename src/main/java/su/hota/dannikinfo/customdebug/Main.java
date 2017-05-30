package su.hota.dannikinfo.customdebug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = "customdebug", name = "Custom debug", version = "1.0")

public class Main {

	@SidedProxy(clientSide = "su.hota.dannikinfo.customdebug.ClientProxy") 	//proxy registering
	public static ClientProxy proxy;	//initialization proxy variable
	@Instance("customdebug")		//instance initialization
	public static Main instance;		//or here initialization instance :)
	public static final String MODID = "customdebug";	//initialization mod id
	public static final Logger logger = LogManager.getLogger(MODID);	//initialization logger 
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		proxy.preInit(); 	//get preInit method of proxy
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(); 	//get init method of proxy
	}
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
	
	public static Main getMod(){
		return instance; 	//return mod container
	}
	
}

