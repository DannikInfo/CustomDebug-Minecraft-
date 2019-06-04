package ru.dannikinfo.customdebug;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod (modid = "customdebug", name = "Custom debug", version = "1.3")

public class Main {

	@SidedProxy(clientSide = "ru.dannikinfo.customdebug.ClientProxy") 	//proxy registering
	public static ClientProxy proxy;	//initialization proxy variable
	@Instance("customdebug")		//instance initialization
	public static Main instance;		//or here initialization instance :)
	public static final String MODID = "customdebug";	//initialization mod id
	
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		proxy.preInit(); 	//get preInit method of proxy
	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		KeyRegister.register();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ConfigManager.sync(MODID, Type.INSTANCE);
		proxy.init(); 	//get init method of proxy
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
	
	public static Main getMod(){
		return instance; 	//return mod container
	}

    @Config(modid = MODID)
    public static class CONFIG_TYPES{
        public static boolean coords=true;
        public static boolean temp=true;
        public static boolean light=true;
        public static boolean rayTrace=true;
        public static boolean memory=true;
        public static boolean dev=false;
    }
	
}

