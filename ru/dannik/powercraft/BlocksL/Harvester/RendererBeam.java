package ru.dannik.powercraft.BlocksL.Harvester;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glVertex2f;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RendererBeam extends TileEntitySpecialRenderer{
	
	 private static final ResourceLocation texture = new ResourceLocation("textures/entity/lead_knot.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityBeam)tile, x, y, z, f);
	}
	
	private void render(TileEntityBeam tile, double x, double y, double z, float f) {
		glPushMatrix();
		glBegin(GL_LINES);
		glVertex2f(10, 10);
		glVertex2f(150, 150);
		glEnd();
	}

}
