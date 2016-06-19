package ru.dannik.powercraft.BlocksL.Crystal.LightBlue;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class LightBlueCrystalModel extends ModelBase{

	 
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
  
  public LightBlueCrystalModel()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 2, 8, 2);
      Shape1.setRotationPoint(3F, 17F, 5F);
      Shape1.setTextureSize(32, 32);
      Shape1.mirror = true;
      setRotation(Shape1, -0.5524122F, 0.1919862F, 0.2837967F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 2, 6, 2);
      Shape2.setRotationPoint(-4.466667F, 20F, 2F);
      Shape2.setTextureSize(32, 32);
      Shape2.mirror = true;
      setRotation(Shape2, -0.2602503F, 0F, -0.5205006F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 2, 12, 2);
      Shape3.setRotationPoint(0F, 11F, 0F);
      Shape3.setTextureSize(32, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 2, 14, 2);
      Shape4.setRotationPoint(2F, 13F, -4F);
      Shape4.setTextureSize(32, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0.3595998F, 0.1919862F, 0.2837967F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 2, 10, 2);
      Shape5.setRotationPoint(-3F, 15F, -3F);
      Shape5.setTextureSize(32, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0.3595998F, 0.9727371F, 0.1525356F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 2, 13, 2);
      Shape5.setRotationPoint(6F, 13F, 3F);
      Shape5.setTextureSize(32, 32);
      Shape5.mirror = true;
      setRotation(Shape5, -0.6442227F, 0.9727371F, 0.1525356F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
	  Shape2.render(0.0625F);
	  Shape3.render(0.0625F);
	  Shape4.render(0.0625F);
	  Shape5.render(0.0625F);  
	}
}