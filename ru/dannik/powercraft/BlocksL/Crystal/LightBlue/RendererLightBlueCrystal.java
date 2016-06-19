package ru.dannik.powercraft.BlocksL.Crystal.LightBlue;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;

public class RendererLightBlueCrystal extends TileEntitySpecialRenderer {

	public static final LightBlueCrystalModel model = new LightBlueCrystalModel();
	public static final ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/blocks/LightBlueCrystal.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityLightBlueCrystal)tile, x, y, z, f);
	}

	private void render(TileEntityLightBlueCrystal tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		bindTexture(texture);
		model.render();
		GL11.glPopMatrix();
	}

}
