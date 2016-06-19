package ru.dannik.powercraft.BlocksL.Crystal.DarkBlue;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;

public class RendererDarkBlueCrystal extends TileEntitySpecialRenderer {

	public static final DarkBlueCrystalModel model = new DarkBlueCrystalModel();
	public static final ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/blocks/DarkBlueCrystal.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityDarkBlueCrystal)tile, x, y, z, f);
	}

	private void render(TileEntityDarkBlueCrystal tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		bindTexture(texture);
		model.render();
		GL11.glPopMatrix();
	}

}
