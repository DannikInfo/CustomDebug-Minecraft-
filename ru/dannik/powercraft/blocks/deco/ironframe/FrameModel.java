package ru.dannik.powercraft.blocks.deco.ironframe;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FrameModel extends ModelBase{

	 
//fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
  
  public FrameModel()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Shape1 = new ModelRenderer(this, 62, 6);
      Shape1.addBox(0F, 0F, 0F, 10, 3, 3);
      Shape1.setRotationPoint(-5F, 8F, 5F);
      Shape1.setTextureSize(128, 128);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 57);
      Shape2.addBox(0F, 0F, 0F, 3, 3, 16);
      Shape2.setRotationPoint(5F, 21F, -8F);
      Shape2.setTextureSize(128, 128);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 62, 18);
      Shape3.addBox(0F, 0F, 0F, 10, 3, 3);
      Shape3.setRotationPoint(-5F, 21F, 5F);
      Shape3.setTextureSize(128, 128);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 62, 12);
      Shape4.addBox(0F, 0F, 0F, 10, 3, 3);
      Shape4.setRotationPoint(-5F, 21F, -8F);
      Shape4.setTextureSize(128, 128);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 50, 0);
      Shape5.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape5.setRotationPoint(-8F, 11F, 5F);
      Shape5.setTextureSize(128, 128);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 38, 0);
      Shape6.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape6.setRotationPoint(5F, 11F, 5F);
      Shape6.setTextureSize(128, 128);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 50, 13);
      Shape7.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape7.setRotationPoint(5F, 11F, -8F);
      Shape7.setTextureSize(128, 128);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 38, 13);
      Shape8.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape8.setRotationPoint(-8F, 11F, -8F);
      Shape8.setTextureSize(128, 128);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 19);
      Shape9.addBox(0F, 0F, 0F, 3, 3, 16);
      Shape9.setRotationPoint(5F, 8F, -8F);
      Shape9.setTextureSize(128, 128);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 38);
      Shape10.addBox(0F, 0F, 0F, 3, 3, 16);
      Shape10.setRotationPoint(-8F, 8F, -8F);
      Shape10.setTextureSize(128, 128);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 62, 0);
      Shape11.addBox(0F, 0F, 0F, 10, 3, 3);
      Shape11.setRotationPoint(-5F, 8F, -8F);
      Shape11.setTextureSize(128, 128);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 0);
      Shape12.addBox(0F, 0F, 0F, 3, 3, 16);
      Shape12.setRotationPoint(-8F, 21F, -8F);
      Shape12.setTextureSize(128, 128);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    setRotationAngles(f, f1, f2, f3, f4, f5);
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
	  Shape6.render(0.0625F);
	  Shape7.render(0.0625F);
	  Shape8.render(0.0625F);
	  Shape9.render(0.0625F);
	  Shape10.render(0.0625F);
	  Shape11.render(0.0625F);
	  Shape12.render(0.0625F);	  
	}
}