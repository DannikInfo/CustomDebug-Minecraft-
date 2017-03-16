package ru.dannik.powercraft.BlocksL.Teleporter;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TeleporterModel extends ModelBase{

	 
	 //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
  
  public TeleporterModel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 20);
      Shape1.addBox(-6F, 0F, -6F, 12, 2, 12);
      Shape1.setRotationPoint(0F, 22F, 0F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 48, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 2, 4);
      Shape2.setRotationPoint(-7F, 22F, -2F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 16);
      Shape3.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape3.setRotationPoint(-1F, 20F, -1F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 8, 8, 8);
      Shape4.setRotationPoint(-4F, 12F, -4F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 34);
      Shape5.addBox(0F, 0F, 0F, 10, 10, 10);
      Shape5.setRotationPoint(-5F, 11F, -5F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  public void render() 
	{
	  Shape1.render(0.0625F);
	  //Shape2.render(0.0625F);
	  Shape3.render(0.0625F);
	  Shape4.render(0.0625F);
	  GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
	  Shape5.render(0.0625F);
	}
}