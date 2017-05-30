package su.hota.dannikinfo.customdebug;

import net.minecraftforge.common.MinecraftForge;

public class ClientProxy{

	public void preInit() {
		
	}

	public void init() {
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

}

