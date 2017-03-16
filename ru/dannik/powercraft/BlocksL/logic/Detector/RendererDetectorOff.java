package ru.dannik.powercraft.BlocksL.logic.Detector;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;

public class RendererDetectorOff extends TileEntitySpecialRenderer {

	public static final DetectorModel model = new DetectorModel();
	public static final ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/blocks/logic/DetectorPlayer_off.png");
	public static final ResourceLocation texture1 = new ResourceLocation(Main.MODID, "textures/blocks/logic/DetectorEntity_off.png");
	public static final ResourceLocation texture2 = new ResourceLocation(Main.MODID, "textures/blocks/logic/DetectorItem_off.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityDetectorOff)tile, x, y, z, f);
	}

	private void render(TileEntityDetectorOff tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        if (tile != null) {
            switch(tile.getBlockMetadata()) {
	            case 0:{bindTexture(texture);break;}
	            case 1:{bindTexture(texture1);break;}
	            case 2:{bindTexture(texture2);break;}
            }
        } 
		model.render();
		GL11.glPopMatrix();
	}

}
