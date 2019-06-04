package ru.dannikinfo.customdebug;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Config.Type;

public class GuiSettings extends GuiContainer{
		
	    final private ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/gui/Black.png");
	    
	    public GuiSettings(){
	        super(new EmptyContainer());
	        xSize = 180;
	        ySize = 200;
	    }
	    
	    public void initGui(){
	    	buttonList.clear();
	    	buttonList.add(new GuiButton(1, (this.width - xSize) / 2 + 5, this.height / 2 - 80, 170, 20, I18n.format(I18n.format("customdebug.coords") + ": " + on(Main.CONFIG_TYPES.coords))));
	    	buttonList.add(new GuiButton(2, (this.width - xSize) / 2 + 5, this.height / 2 - 80 + 25, 170, 20, I18n.format(I18n.format("customdebug.temperature") + ": " + on(Main.CONFIG_TYPES.temp))));
	    	buttonList.add(new GuiButton(3, (this.width - xSize) / 2 + 5, this.height / 2 - 80 + 50, 170, 20, I18n.format(I18n.format("customdebug.light")+ ": " + on(Main.CONFIG_TYPES.light))));
	    	buttonList.add(new GuiButton(4, (this.width - xSize) / 2 + 5, this.height / 2 - 80 + 75, 170, 20, I18n.format(I18n.format("customdebug.rayTrace") + ": " + on(Main.CONFIG_TYPES.rayTrace))));
	    	buttonList.add(new GuiButton(5, (this.width - xSize) / 2 + 5, this.height / 2 - 80 + 100, 170, 20, I18n.format(I18n.format("customdebug.memory") + ": " + on(Main.CONFIG_TYPES.memory))));
	    	buttonList.add(new GuiButton(6, (this.width - xSize) / 2 + 5, this.height / 2 - 80 + 125, 170, 20, I18n.format(I18n.format("customdebug.dev") + ": " + on(Main.CONFIG_TYPES.dev))));
	    }
	    
	    protected void actionPerformed(GuiButton button){
	    	switch (button.id){
	    		case 1:{
	    			Main.CONFIG_TYPES.coords = swap(Main.CONFIG_TYPES.coords);
	    			this.initGui();
	    			ConfigManager.sync(Main.MODID, Type.INSTANCE);
	    			break;
	    		}
	    		case 2:{
	    			Main.CONFIG_TYPES.temp = swap(Main.CONFIG_TYPES.temp);
	    			this.initGui();
	    			ConfigManager.sync(Main.MODID, Type.INSTANCE);
	    			break;
	    		}
	    		case 3:{
	    			Main.CONFIG_TYPES.light = swap(Main.CONFIG_TYPES.light);
	    			this.initGui();
	    			ConfigManager.sync(Main.MODID, Type.INSTANCE);
	    			break;
	    		}
	    		case 4:{
	    			Main.CONFIG_TYPES.rayTrace = swap(Main.CONFIG_TYPES.rayTrace);
	    			this.initGui();
	    			ConfigManager.sync(Main.MODID, Type.INSTANCE);
	    			break;
	    		}
	    		case 5:{
	    			Main.CONFIG_TYPES.memory = swap(Main.CONFIG_TYPES.memory);
	    			this.initGui();
	    			ConfigManager.sync(Main.MODID, Type.INSTANCE);
	    			break;
	    		}
	    		case 6:{
	    			Main.CONFIG_TYPES.dev = swap(Main.CONFIG_TYPES.dev);
	    			this.initGui();
	    			ConfigManager.sync(Main.MODID, Type.INSTANCE);
	    			break;
	    		}
	    	 	default:{
	    		 	break;
	    	 	}
	    	}
	    }
	    
	    public boolean swap(boolean on) {
	    	if(on)
	    		return false;
	    	else
	    		return true;
	    }

	    public String on(boolean check) {
	    	if(check)
	    		return I18n.format("customdebug.on");
	    	else
	    		return I18n.format("customdebug.off");
	    }
	    
	    @Override
	    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mX, int mY) {
	        int zX = (width - xSize) / 2;
	        int zY = (height - ySize) / 2;
	        mc.getTextureManager().bindTexture(texture);
	        drawTexturedModalRect(zX, 0, 0, 0, xSize, mc.displayHeight);
	    }
}
