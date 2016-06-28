package ru.dannik.powercraft.BlocksL.Crystal.Orange;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;

public class RendererOrangeCrystal extends TileEntitySpecialRenderer {

	public static final OrangeCrystalModel model = new OrangeCrystalModel();
	public static final ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/blocks/OrangeCrystal.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityOrangeCrystal)tile, x, y, z, f);
	}

	private void render(TileEntityOrangeCrystal tile, double x, double y, double z, float f) {
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
		GL11.glEnable(GL11.GL_BLEND); 
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		bindTexture(texture);
		model.render();
		GL11.glPopMatrix();
	}

}
