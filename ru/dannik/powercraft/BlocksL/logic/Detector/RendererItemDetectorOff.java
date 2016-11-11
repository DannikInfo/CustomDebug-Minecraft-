package ru.dannik.powercraft.BlocksL.logic.Detector;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import ru.dannik.powercraft.BlocksL.Crystal.RendererCrystal;

import org.lwjgl.opengl.GL11;

public class RendererItemDetectorOff implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack is, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		int meta = is.getItemDamage();
		switch(meta) {
	    	case 0:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererDetector.texture);break;}
	        case 1:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererDetector.texture1);break;}
	        case 2:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererDetector.texture2);break;}
        }
		RendererDetector.model.render();
		GL11.glPopMatrix();
	}

}
