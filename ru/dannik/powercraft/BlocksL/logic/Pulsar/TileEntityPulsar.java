package ru.dannik.powercraft.BlocksL.logic.Pulsar;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import ru.dannik.powercraft.BlocksL.BlockList;

public class TileEntityPulsar extends TileEntity{
	
	private int delayTimer = 0;
    private int delay = 10;
    private int holdtime = 4;
    private boolean paused = false;
    private boolean silent = false;
    private boolean should = true;
	
    public void setTimes(int delay, int holdTime){
        if (delay < 2){
        	delay = 2;
        }

        this.delay = delay;

        if (holdTime >= delay)
        {
        	holdTime = delay - 1;
        }
        
        holdtime = holdTime;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setInteger("delayTimer", delayTimer);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        delayTimer = nbttagcompound.getInteger("delayTimer");
    }

    public boolean isActive()
    {
    	if(worldObj.getBlock(xCoord, yCoord, zCoord) == BlockList.pulsar){
    		paused = false;
    	}else{
    		if(worldObj.getBlock(xCoord, yCoord, zCoord) == BlockList.pulsaroff){
    			paused = true;
    		}
    	}
        return paused;
    }
    
	public void updateEntity(){
        if (isPaused() || worldObj.isRemote)
        {
            return;
        }
        
        if (delayTimer < 0 && !isActive())
        {
        	worldObj.setBlock(xCoord, yCoord, zCoord, BlockList.pulsar);
        }

        delayTimer++;

        if (delayTimer >= getHold() && isActive())
        {
        	worldObj.setBlock(xCoord, yCoord, zCoord, BlockList.pulsaroff);
        }

        if (delayTimer >= getDelay())
        {
            delayTimer = -1;
        }
	}
    @Override
    public boolean canUpdate()
    {
        return true;
    }

    public boolean isSilent()
    {
        return silent;
    }

    public int getDelay()
    {
        return delay;
    }

    public int getHold()
    {
        return holdtime;
    }

    public boolean isPaused()
    {
        return paused;
    }

}
