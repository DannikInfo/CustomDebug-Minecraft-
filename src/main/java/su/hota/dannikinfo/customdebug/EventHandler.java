package su.hota.dannikinfo.customdebug;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class EventHandler{
	
   final Minecraft mc = Minecraft.getMinecraft();

   @SubscribeEvent(priority = EventPriority.HIGH)
   public void onDrawOverlay(final RenderGameOverlayEvent e)
   {
	    if (e instanceof RenderGameOverlayEvent.Pre) {
	        switch (e.type) {
	            case DEBUG: {drawDebug(e);break;}
	            default: {return;}
	        }
	        e.setCanceled(true);
	    }
	    
   }
   
   public void drawDebug(RenderGameOverlayEvent e){
	   
	   FontRenderer fontrenderer = this.mc.fontRenderer;
	   ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
	   
	   int k = scaledresolution.getScaledWidth();
       int l = scaledresolution.getScaledHeight();
       int j3 = MathHelper.floor_double(this.mc.thePlayer.posX);
       int k3 = MathHelper.floor_double(this.mc.thePlayer.posY);
       int l3 = MathHelper.floor_double(this.mc.thePlayer.posZ);
       
	   Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(j3, l3);
       
       long i5 = Runtime.getRuntime().maxMemory();
       long j5 = Runtime.getRuntime().totalMemory();
       long k5 = Runtime.getRuntime().freeMemory();
       long l5 = j5 - k5;
       
       String usemem = StatCollector.translateToLocal("customdebug.usemem") + ": " + l5 * 100L / i5 + "% - " + l5 / 1024L / 1024L + "MB / " + i5 / 1024L / 1024L + "MB";
       String alocmem = StatCollector.translateToLocal("customdebug.allocmem") + ": " + j5 * 100L / i5 + "% - " + j5 / 1024L / 1024L + "MB / " + i5 / 1024L / 1024L + "MB";
       
       GL11.glPushMatrix();
       fontrenderer.drawStringWithShadow("Minecraft 1.7.10 " + mc.debug, 2, 2, 16777215);
       fontrenderer.drawStringWithShadow("x: " + (int) this.mc.thePlayer.posX , 2, 12, 16777215);
       fontrenderer.drawStringWithShadow("y: " + (int) this.mc.thePlayer.posY , 2, 22, 16777215);
       fontrenderer.drawStringWithShadow("z: " + (int) this.mc.thePlayer.posZ , 2, 32, 16777215);
       fontrenderer.drawStringWithShadow(StatCollector.translateToLocal("customdebug.biome") + ": " + chunk.getBiomeGenForWorldCoords(j3 & 15, l3 & 15, this.mc.theWorld.getWorldChunkManager()).biomeName, 2, 42, 16777215);
       fontrenderer.drawStringWithShadow(StatCollector.translateToLocal("customdebug.light") + ": " + chunk.getSavedLightValue(EnumSkyBlock.Block, j3 & 15, k3, l3 & 15), 2, 52, 16777215);
       fontrenderer.drawStringWithShadow(usemem, k - fontrenderer.getStringWidth(usemem), 2, 16777215);
       fontrenderer.drawStringWithShadow(alocmem, k - fontrenderer.getStringWidth(alocmem), 12, 16777215);
       GL11.glPopMatrix();

   }
}
