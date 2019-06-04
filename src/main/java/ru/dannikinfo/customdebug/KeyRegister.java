package ru.dannikinfo.customdebug;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyRegister {

	private static final String catergory = "Custom debug";
    public static final KeyBinding
            REDRAW = new KeyBinding("key.redraw", Keyboard.KEY_R, catergory),
            SETTINGS = new KeyBinding("key.settings", Keyboard.KEY_P, catergory);

    public static void register(){
        setRegister(REDRAW);
        setRegister(SETTINGS);
    }

    private static void setRegister(KeyBinding binding){
        ClientRegistry.registerKeyBinding(binding);
    }
	
}
