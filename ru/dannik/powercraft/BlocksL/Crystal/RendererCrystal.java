package ru.dannik.powercraft.BlocksL.Crystal;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;

public class RendererCrystal extends TileEntitySpecialRenderer {

	public static final CrystalModel model = new CrystalModel();
	public static final ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/blocks/CyanCrystal.png");
	public static final ResourceLocation texture1 = new ResourceLocation(Main.MODID, "textures/blocks/DarkBlueCrystal.png");
	public static final ResourceLocation texture2 = new ResourceLocation(Main.MODID, "textures/blocks/GreenCrystal.png");
	public static final ResourceLocation texture3 = new ResourceLocation(Main.MODID, "textures/blocks/LightBlueCrystal.png");
	public static final ResourceLocation texture4 = new ResourceLocation(Main.MODID, "textures/blocks/OrangeCrystal.png");
	public static final ResourceLocation texture5 = new ResourceLocation(Main.MODID, "textures/blocks/PurpleCrystal.png");
	public static final ResourceLocation texture6 = new ResourceLocation(Main.MODID, "textures/blocks/RedCrystal.png");
	public static final ResourceLocation texture7 = new ResourceLocation(Main.MODID, "textures/blocks/YellowCrystal.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityCrystal)tile, x, y, z, f);
	}

	public void render(TileEntityCrystal tile, double x, double y, double z, float f) {
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
		GL11.glEnable(GL11.GL_BLEND); 
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        if (tile != null) {
            switch(tile.getBlockMetadata()) {
	            case 0:{bindTexture(texture);break;}
	            case 1:{bindTexture(texture1);break;}
	            case 2:{bindTexture(texture2);break;}
	            case 3:{bindTexture(texture3);break;}
	            case 4:{bindTexture(texture4);break;}
	            case 5:{bindTexture(texture5);break;}
	            case 6:{bindTexture(texture6);break;}
	            case 7:{bindTexture(texture7);break;}
            }
        } 
		model.render();
		GL11.glPopMatrix();
	}

}
