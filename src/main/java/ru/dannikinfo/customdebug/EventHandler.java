package ru.dannikinfo.customdebug;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler{
	
   final Minecraft mc = Minecraft.getMinecraft();

   @SubscribeEvent(priority = EventPriority.HIGH)
   public void onDrawOverlay(final RenderGameOverlayEvent e)
   {
	    if (e instanceof RenderGameOverlayEvent.Pre) {
	        switch (e.getType()) {
	            case DEBUG: {drawDebug(e);break;}
	            default: {return;}
	        }
	        e.setCanceled(true);
	    }
	    
   }
   
   public void drawDebug(RenderGameOverlayEvent e){
	   
	   FontRenderer fontrenderer = this.mc.fontRenderer;
	   ScaledResolution scaledresolution = new ScaledResolution(this.mc);
	   
	   int k = scaledresolution.getScaledWidth();
       int l = scaledresolution.getScaledHeight();
       int j3 = MathHelper.floor(this.mc.player.posX);
       int k3 = MathHelper.floor(this.mc.player.posY);
       int l3 = MathHelper.floor(this.mc.player.posZ);
       
	   BlockPos blockpos = new BlockPos(j3, k3, l3);
       
	   Chunk chunk = this.mc.world.getChunkFromBlockCoords(blockpos);
       
       long i5 = Runtime.getRuntime().maxMemory();
       long j5 = Runtime.getRuntime().totalMemory();
       long k5 = Runtime.getRuntime().freeMemory();
       long l5 = j5 - k5;
              
       String usemem = I18n.format("customdebug.usemem") + ": " + l5 * 100L / i5 + "% - " + l5 / 1024L / 1024L + "MB / " + i5 / 1024L / 1024L + "MB";
       String alocmem = I18n.format("customdebug.allocmem") + ": " + j5 * 100L / i5 + "% - " + j5 / 1024L / 1024L + "MB / " + i5 / 1024L / 1024L + "MB";
       
       GL11.glPushMatrix();
       fontrenderer.drawStringWithShadow("Minecraft FPS: " + mc.getDebugFPS(), 2, 2, 16777215);
       fontrenderer.drawStringWithShadow("x: " + (int) this.mc.player.posX , 2, 12, 16777215);
       fontrenderer.drawStringWithShadow("y: " + (int) this.mc.player.posY , 2, 22, 16777215);
       fontrenderer.drawStringWithShadow("z: " + (int) this.mc.player.posZ , 2, 32, 16777215);
       fontrenderer.drawStringWithShadow(I18n.format("customdebug.biome") + ": " + chunk.getBiome(blockpos, this.mc.world.getBiomeProvider()).getBiomeName(), 2, 42, 16777215);
       fontrenderer.drawStringWithShadow(I18n.format("customdebug.light") + ": " + chunk.getLightFor(EnumSkyBlock.BLOCK, blockpos), 2, 52, 16777215);
       fontrenderer.drawStringWithShadow(usemem, k - fontrenderer.getStringWidth(usemem), 2, 16777215);
       fontrenderer.drawStringWithShadow(alocmem, k - fontrenderer.getStringWidth(alocmem), 12, 16777215);
       GL11.glPopMatrix();

   }
}
