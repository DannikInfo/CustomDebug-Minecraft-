package ru.dannik.powercraft.blocks.deco.chimeny;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;

public class RendererChimeny extends TileEntitySpecialRenderer {

	public static final ChimenyModel model = new ChimenyModel();
	public static final ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/blocks/deco/Cobblestone_Chimeny.png");
	public static final ResourceLocation texture1 = new ResourceLocation(Main.MODID, "textures/blocks/deco/MossyCobblestone_Chimeny.png");
	public static final ResourceLocation texture2 = new ResourceLocation(Main.MODID, "textures/blocks/deco/Brick_Chimeny.png");
	public static final ResourceLocation texture3 = new ResourceLocation(Main.MODID, "textures/blocks/deco/StoneBrick_Chimeny.png");
	public static final ResourceLocation texture4 = new ResourceLocation(Main.MODID, "textures/blocks/deco/SandStone_Chimeny.png");
	public static final ResourceLocation texture5 = new ResourceLocation(Main.MODID, "textures/blocks/deco/Iron_Chimeny.png");
	public static final ResourceLocation texture6 = new ResourceLocation(Main.MODID, "textures/blocks/deco/NetherBrick_Chimeny.png");
	public static final ResourceLocation texture7 = new ResourceLocation(Main.MODID, "textures/blocks/deco/NetherQartz_Chimeny.png");
	public static final ResourceLocation texture8 = new ResourceLocation(Main.MODID, "textures/blocks/deco/Clay_Chimeny.png");
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntityChimeny)tile, x, y, z, f);
	}

	public void render(TileEntityChimeny tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
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
	            case 8:{bindTexture(texture8);break;}
            }
        } 
		model.render();
		GL11.glPopMatrix();
	}

}
