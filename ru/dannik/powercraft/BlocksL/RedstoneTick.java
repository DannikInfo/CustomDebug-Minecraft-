package ru.dannik.powercraft.BlocksL;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;

public class RedstoneTick extends Block{

	protected RedstoneTick() {
		super(Material.redstoneLight);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(1F);
		setStepSound(soundTypeStone);
		setBlockTextureName("powercraftreloaded:redstone_tick");
	}
	
	public boolean canProvidePower(){
	    return true;
	}
	
	int tick = 0;
	
	public void updateTick(World world, int x, int y, int z, Random rand){
		if(tick <= 20){
			tick++;
		}
		else{
			tick = 0;
		}
		//world.scheduleBlockUpdate(x, y, z, BlockList.redstone_tick, 1); 
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		Minecraft.getMinecraft().thePlayer.sendChatMessage("тиков сейчас:" + tick);
		return true;
	}
	
    public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_)
    {
    	if(tick == 20){
            int i1 = p_149709_1_.getBlockMetadata(p_149709_2_, p_149709_3_, p_149709_4_);
            return i1 == 5 && p_149709_5_ == 1 ? 0 : (i1 == 3 && p_149709_5_ == 3 ? 0 : (i1 == 4 && p_149709_5_ == 2 ? 0 : (i1 == 1 && p_149709_5_ == 5 ? 0 : (i1 == 2 && p_149709_5_ == 4 ? 0 : 15))));
    	}else{
    		return 0;
    	}
    }
	

}
