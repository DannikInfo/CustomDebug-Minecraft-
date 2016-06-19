package ru.dannik.powercraft.ItemsL.activationcrystal;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Plasm extends EntityThrowable
{

    public Plasm(World world) 
    {
        super(world);
    }

    public Plasm(World world, double x, double y, double z) 
    {
        super(world, x, y, z);
    }

    public Plasm(World world, EntityLivingBase entity) 
    {
        super(world, entity);
    }
    
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        this.motionX *= (double)this.getVelocity();
        this.motionY *= (double)this.getVelocity();
        this.motionZ *= (double)this.getVelocity();
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    protected float getVelocity()
    {
        return 2.0F; // Скорость пули (с какой скоростью будет лететь пуля)
    }
    
    protected float getGravityVelocity()
    {
        return 0.01F; // Гравитация пули (с какой скоростью будет снижаться пуля)
    }

    @Override
    protected void onImpact(MovingObjectPosition mop) 
    {

    	if(!this.worldObj.isRemote)
        {
    		float explosionForce = 3.0F; // Сила взрыва
            boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
            this.worldObj.newExplosion(this, mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord, explosionForce, false, flag);
            this.setDead();
        }
     }
 }