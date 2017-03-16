package ru.dannik.powercraft.BlocksL.logic.Detector;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import ru.dannik.powercraft.BlocksL.BlockList;

public class TileEntityDetector extends TileEntity {
	
	NBTTagCompound nbt;
	int type;
	boolean active = false;
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
	   nbt = tag.getCompoundTag("Detect");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
	   tag.setTag("Detect", tag);
	}
	
	public TileEntityDetector() {

	}
	
	public int getGroup(){
		type = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		return type;
	}
	
	public int getRange(){
		int range = 3;
		return range;
	}
	
	public boolean isActive() {
		return active;
	}
	
	@Override
	public void updateEntity() {
		if(worldObj.isRemote)
			return;
		int count = 0;
		AxisAlignedBB bb=AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1).expand(getRange(), getRange(), getRange());
		if (getGroup() == 2) {
			count += worldObj.getEntitiesWithinAABB(EntityItem.class, bb).size();
			count += worldObj.getEntitiesWithinAABB(EntityXPOrb.class, bb).size();
			count += worldObj.getEntitiesWithinAABB(EntityArrow.class, bb).size();
		}
		if (getGroup() == 1) {
			count += worldObj.getEntitiesWithinAABB(EntityAnimal.class, bb).size();
			count += worldObj.getEntitiesWithinAABB(EntityCreature.class, bb).size();
			count += worldObj.getEntitiesWithinAABB(EntitySlime.class, bb).size();
		}
		if (getGroup() == 0) {
			count += worldObj.getEntitiesWithinAABB(EntityPlayer.class, bb).size();
		}
		if (count > 0) {
			if (!isActive()) {
				active = true;
				int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
				worldObj.setBlock(xCoord, yCoord, zCoord, BlockList.detector, meta, 1);
				if(getBlockType()!=null){
					worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, getBlockType());
					worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord - 1, zCoord, getBlockType());
					worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				}
			}
		} else {
			if (isActive()) {
				active = false;
				int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
				worldObj.setBlock(xCoord, yCoord, zCoord, BlockList.detectoroff, meta, 1);
				if(getBlockType()!=null){
					worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, getBlockType());
					worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord - 1, zCoord, getBlockType());
					worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				}
			}
		}
	}	
}
