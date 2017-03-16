package ru.dannik.powercraft.blocks.deco.ironframe;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;

public class RendererIronFrame extends TileEntitySpecialRenderer {

	public static final FrameModel model = new FrameModel();
	public static final ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/blocks/deco/IronFrame.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityIronFrame)tile, x, y, z, f);
	}

	private void render(TileEntityIronFrame tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		bindTexture(texture);
		model.render();
		GL11.glPopMatrix();
	}

}
