package ru.dannikinfo.customdebug;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.UnmodifiableIterator;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandler{
	
   final Minecraft mc = Minecraft.getMinecraft();

   @SubscribeEvent
   public void onConfigChangedEvent(OnConfigChangedEvent event){
       if (event.getModID().equals(Main.MODID)){
           ConfigManager.sync(Main.MODID, Type.INSTANCE);
       }
   }
   
   @SubscribeEvent(priority = EventPriority.HIGH)
   public void onDrawOverlay(final RenderGameOverlayEvent e) {
	    if (e instanceof RenderGameOverlayEvent.Pre) {
	        switch (e.getType()) {
	            case DEBUG: {drawDebug();break;}
	            default: {return;}
	        }
	        e.setCanceled(true);
	    }
	    
   }
   
   public void drawDebug(){
	   
	   FontRenderer fontrenderer = this.mc.fontRenderer;
	   ScaledResolution scaledresolution = new ScaledResolution(this.mc);
	   EntityPlayerSP player = mc.player;
	   
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
       long h = 12;
              
       String usemem = I18n.format("customdebug.usemem") + ": " + l5 * 100L / i5 + "% - " + l5 / 1024L / 1024L + "MB / " + i5 / 1024L / 1024L + "MB";
       String alocmem = I18n.format("customdebug.allocmem") + ": " + j5 * 100L / i5 + "% - " + j5 / 1024L / 1024L + "MB / " + i5 / 1024L / 1024L + "MB";
       
       GL11.glPushMatrix();
       fontrenderer.drawStringWithShadow("Minecraft FPS: " + mc.getDebugFPS(), 2, 2, 16777215);
       if(Main.CONFIG_TYPES.coords) {
	       fontrenderer.drawStringWithShadow("x: " + (int) this.mc.player.posX , 2, 12, 16777215);
	       fontrenderer.drawStringWithShadow("y: " + (int) this.mc.player.posY , 2, 22, 16777215);
	       fontrenderer.drawStringWithShadow("z: " + (int) this.mc.player.posZ , 2, 32, 16777215);
	       h = 42;
       }
       fontrenderer.drawStringWithShadow(I18n.format("customdebug.biome") + ": " + chunk.getBiome(blockpos, this.mc.world.getBiomeProvider()).getBiomeName(), 2, h, 16777215);
       if(Main.CONFIG_TYPES.light) {
    	   h +=10;
    	   fontrenderer.drawStringWithShadow(I18n.format("customdebug.light") + ": " + chunk.getLightFor(EnumSkyBlock.BLOCK, blockpos), 2, h, 16777215);
       }   
       if(Main.CONFIG_TYPES.memory) {
	       fontrenderer.drawStringWithShadow(usemem, k - fontrenderer.getStringWidth(usemem), 2, 16777215);
	       fontrenderer.drawStringWithShadow(alocmem, k - fontrenderer.getStringWidth(alocmem), 12, 16777215);
       }
       //Расширенная информация (Code by Крокодил)
       //Температура
       if(Main.CONFIG_TYPES.temp) {
    	   h +=10;
    	   fontrenderer.drawStringWithShadow(I18n.format("customdebug.temperature") + ": " + BigDecimal.valueOf(chunk.getBiome(blockpos, this.mc.world.getBiomeProvider()).getTemperature(blockpos)).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue(), 2, h, 16777215);
       }
       //Сторона света
       if(Main.CONFIG_TYPES.rayTrace) {
    	   h +=10;
    	   fontrenderer.drawStringWithShadow(I18n.format("customdebug.rayTrace") + ": " + player.getHorizontalFacing().getHorizontalIndex() + " (" + I18n.format("customdebug." + player.getHorizontalFacing().toString()) + ")", 2, h, 16777215);
       }
       //Куда направлен взгляд
       if(Main.CONFIG_TYPES.dev) {
	       if (mc.objectMouseOver != null) {
	           //Если смотришь на блок
	           if (mc.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK && mc.objectMouseOver.getBlockPos() != null) {
	               BlockPos blockpos2 = this.mc.objectMouseOver.getBlockPos();
	               IBlockState iblockstate = this.mc.world.getBlockState(blockpos2);
	
	               if (this.mc.world.getWorldType() != WorldType.DEBUG_ALL_BLOCK_STATES) iblockstate = iblockstate.getActualState(mc.world, blockpos2);
	
	               String name = String.valueOf(Block.REGISTRY.getNameForObject(iblockstate.getBlock()));
	
	               int size = calcHeight(l, iblockstate.getProperties().size());
	
	               fontrenderer.drawStringWithShadow(name + " (" +iblockstate.getBlock().getLocalizedName() + ")", k / 2 + 22, size, 16777215);
	               fontrenderer.drawStringWithShadow(I18n.format("customdebug.pos") + " (xyz)" + ": " + blockpos2.getX() + ", " + blockpos2.getY() + ", " + blockpos2.getZ(), k / 2 + 22, size + 10, 16777215);
	
	               int f = 20;
	               UnmodifiableIterator iterator = iblockstate.getProperties().entrySet().iterator();
	
	               //Список проперти из блокСтэйт
	               while (iterator.hasNext()) {
	                   Entry<IProperty<?>, Comparable<?>> entry = (Entry) iterator.next();
	                   IProperty iproperty = entry.getKey();
	                   Comparable propertyValue = entry.getValue();
	                   String s = iproperty.getName();
	                   String propertyName = s + ": ";
	
	                   int color = Boolean.TRUE.equals(propertyValue) ? 1632045 : Boolean.FALSE.equals(propertyValue) ? 16722973 : 16777215;
	
	                   fontrenderer.drawStringWithShadow(propertyName, k / 2 + 22,size + f, 16777215);
	                   fontrenderer.drawStringWithShadow(String.valueOf(propertyValue), k / 2 + 22 + fontrenderer.getStringWidth(propertyName), size + f, color);
	
	
	                   f += 10;
	               }
	           }
	           //Если смотришь на сущность
	           else if(mc.objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY){
	               Entity entity = mc.objectMouseOver.entityHit;
	               BlockPos pos = entity.getPosition();
	
	               int size = calcHeight(l, 6);
	               fontrenderer.drawStringWithShadow(entity.getName(), k / 2 + 22, size, 16777215);
	               fontrenderer.drawStringWithShadow(I18n.format("customdebug.pos") + " (xyz)" + ": " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ(), k / 2 + 22, size + 10, 16777215);
	
	               if(entity instanceof EntityLivingBase) {
	                   EntityLivingBase entity2 = (EntityLivingBase) entity;
	                   fontrenderer.drawStringWithShadow(I18n.format("customdebug.health") + ": " + entity2.getHealth() + "/" + entity2.getMaxHealth(), k / 2 + 22, size + 20, 16777215);
	                   DecimalFormat df = new DecimalFormat("#.##");
	                   fontrenderer.drawStringWithShadow(I18n.format("customdebug.movementSpeed") + ": " + df.format(entity2.getAttributeMap().getAttributeInstanceByName("generic.movementSpeed").getAttributeValue()), k / 2 + 22, size + 30, 16777215);
	                   if(entity instanceof EntityMob) {
	                       fontrenderer.drawStringWithShadow(I18n.format("customdebug.attackDamage") + ": " + entity2.getAttributeMap().getAttributeInstanceByName("generic.attackDamage").getAttributeValue(), k / 2 + 22, size + 40, 16777215);
	                       size += 40;
	                   }
	                   else size += 30;
	               }
	
	
	               fontrenderer.drawStringWithShadow(I18n.format("customdebug.distance") + ": " + BigDecimal.valueOf(entity.getDistance(player)).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue(), k / 2 + 22, size + 10, 16777215);
	           }
	       }
       }
       //END
       GL11.glPopMatrix();
   }

   private int calcHeight(int h, int size) { //code by Крокодил
       int res = h / 2 - 5 * size;
       return res <=  h / 6 ? res : h / 6;
   }
   
   @SideOnly(Side.CLIENT)
   @SubscribeEvent
   public void KeyHandle(KeyInputEvent event) {
	   if(KeyRegister.SETTINGS.isPressed()) {
		   mc.player.openGui(Main.instance, 1, mc.player.world, 0, 0, 0);
	   }
	   if(KeyRegister.REDRAW.isPressed()) {
		   this.mc.refreshResources();
	   }
   }
   
   /* saved because it will be removed
    * 
    * public void refreshResources()
    {
        List<IResourcePack> list = Lists.newArrayList(this.defaultResourcePacks);

        if (this.integratedServer != null)
        {
            this.integratedServer.reload();
        }

        for (ResourcePackRepository.Entry resourcepackrepository$entry : this.mcResourcePackRepository.getRepositoryEntries())
        {
            list.add(resourcepackrepository$entry.getResourcePack());
        }

        if (this.mcResourcePackRepository.getServerResourcePack() != null)
        {
            list.add(this.mcResourcePackRepository.getServerResourcePack());
        }

        try
        {
            this.mcResourceManager.reloadResources(list);
        }
        catch (RuntimeException runtimeexception)
        {
            LOGGER.info("Caught error stitching, removing all assigned resourcepacks", (Throwable)runtimeexception);
            list.clear();
            list.addAll(this.defaultResourcePacks);
            this.mcResourcePackRepository.setRepositories(Collections.emptyList());
            this.mcResourceManager.reloadResources(list);
            this.gameSettings.resourcePacks.clear();
            this.gameSettings.incompatibleResourcePacks.clear();
            this.gameSettings.saveOptions();
        }

        this.mcLanguageManager.parseLanguageMetadata(list);

        if (this.renderGlobal != null)
        {
            this.renderGlobal.loadRenderers();//redraw screen
        }
    }*/
}