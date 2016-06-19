package ru.dannik.powercraft.BlocksL.Harvester;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RendererRayHarvester extends TileEntitySpecialRenderer{
	
	 private static final ResourceLocation texture = new ResourceLocation("textures/entity/lead_knot.png");
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f){
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glTranslatef((float)x, (float)y, (float)z);
        float f2 = 0.0625F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        this.bindTexture(texture);
        //this.leashKnotModel.render(p_76986_1_, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f2);
        GL11.glPopMatrix();
        
		
	}

}
