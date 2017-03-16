package ru.dannik.powercraft.blocks.deco.chimeny;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RendererItemChimeny implements IItemRenderer {

	public TileEntityChimeny tile;
	
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
	    	case 0:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererChimeny.texture);break;}
	        case 1:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererChimeny.texture1);break;}
	        case 2:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererChimeny.texture2);break;}
	        case 3:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererChimeny.texture3);break;}
	        case 4:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererChimeny.texture4);break;}
	        case 5:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererChimeny.texture5);break;}
	        case 6:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererChimeny.texture6);break;}
	        case 7:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererChimeny.texture7);break;}
	        case 8:{Minecraft.getMinecraft().renderEngine.bindTexture(RendererChimeny.texture8);break;}
        }
		RendererChimeny.model.render();
		GL11.glPopMatrix();
	}

}
