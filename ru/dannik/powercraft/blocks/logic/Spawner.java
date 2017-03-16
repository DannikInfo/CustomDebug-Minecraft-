package ru.dannik.powercraft.blocks.logic;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.blocks.BlockList;
import ru.dannik.powercraft.items.ItemList;

public class Spawner extends BlockMobSpawner{
	
	public Spawner(){
		setHardness(1.0F);
		setCreativeTab(Main.tabPowerCraft);
		this.setBlockTextureName("powercraftreloaded:spawner");
		setBlockName(Main.MODID + ".Spawner");
	}
	
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }
    
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
    	return Item.getItemFromBlock(BlockList.spawner);
    }
    
    public void clearSpawner(World world, int x, int y, int z){	    		
    	world.setBlock(x, y, z, Blocks.air);
	    world.setBlock(x, y, z, BlockList.spawner);  
    }
    
    public void changeMob(World world, int x, int y, int z, String entitys, int id){	
	    	EntityPig Pig = new EntityPig(world);
	    	EntityZombie Zombie = new EntityZombie(world);
	    	EntityPigZombie PigZombie = new EntityPigZombie(world);
	    	EntityCreeper Creeper = new EntityCreeper(world);
	    	EntitySpider Spider = new EntitySpider(world);
	    	EntitySlime Slime = new EntitySlime(world);
	    	EntityCaveSpider CaveSpider = new EntityCaveSpider(world);
	    	EntityMagmaCube MagmaCube = new EntityMagmaCube(world);
	    	EntityCow Cow = new EntityCow(world);
	    	EntitySkeleton Skeleton = new EntitySkeleton(world);
	    	EntityGhast Ghast = new EntityGhast(world);
	    	EntityEnderman Enderman = new EntityEnderman(world);
	    	EntitySilverfish Silverfish = new EntitySilverfish(world);
	    	EntityBlaze Blaze = new EntityBlaze(world);
	    	EntityBat Bat = new EntityBat(world);
	    	EntityWitch Witch = new EntityWitch(world);
	    	EntitySheep Sheep = new EntitySheep(world);
	    	EntityChicken Chicken = new EntityChicken(world);
	    	EntitySquid Squid = new EntitySquid(world);
	    	EntityWolf Wolf = new EntityWolf(world);
	    	EntityMooshroom MooshroomCow = new EntityMooshroom(world);
	    	EntityOcelot Ocelot = new EntityOcelot(world);
	    	EntityVillager Villager = new EntityVillager(world);
	    	EntityIronGolem VillagerGolem = new EntityIronGolem(world);
	    	EntitySnowman SnowMan = new EntitySnowman(world);
	    	EntityGiantZombie Giant = new EntityGiantZombie(world);
	    	
	    	TileEntity spawner = world.getTileEntity(x, y, z);
	    	if (spawner instanceof TileEntityMobSpawner){
	    		MobSpawnerBaseLogic logic = ((TileEntityMobSpawner)spawner).func_145881_a();
	    		String entity = logic.getEntityNameToSpawn();	    		  	 		
		    		logic.setEntityName(entitys);
		    		NBTTagCompound compound = new NBTTagCompound();
		    		if(id == 0){Pig.writeEntityToNBT(compound);}
		    		if(id == 1){Zombie.writeEntityToNBT(compound);}
		    		if(id == 2){PigZombie.writeEntityToNBT(compound);}
		    		if(id == 3){Creeper.writeEntityToNBT(compound);}
		    		if(id == 4){Spider.writeEntityToNBT(compound);}
		    		if(id == 5){Slime.writeEntityToNBT(compound);}
		    		if(id == 6){CaveSpider.writeEntityToNBT(compound);}
		    		if(id == 7){MagmaCube.writeEntityToNBT(compound);}
		    		if(id == 8){Cow.writeEntityToNBT(compound);}
		    		if(id == 9){Skeleton.writeEntityToNBT(compound);}
		    		if(id == 10){Ghast.writeEntityToNBT(compound);}
		    		if(id == 11){Enderman.writeEntityToNBT(compound);}
		    		if(id == 12){Silverfish.writeEntityToNBT(compound);}
		    		if(id == 13){Blaze.writeEntityToNBT(compound);}
		    		if(id == 14){Bat.writeEntityToNBT(compound);}
		    		if(id == 15){Witch.writeEntityToNBT(compound);}
		    		if(id == 16){Sheep.writeEntityToNBT(compound);}
		    		if(id == 17){Chicken.writeEntityToNBT(compound);}
		    		if(id == 18){Squid.writeEntityToNBT(compound);}
		    		if(id == 19){Wolf.writeEntityToNBT(compound);}
		    		if(id == 20){MooshroomCow.writeEntityToNBT(compound);}
		    		if(id == 21){Ocelot.writeEntityToNBT(compound);}
		    		if(id == 22){Villager.writeEntityToNBT(compound);}
		    		if(id == 23){VillagerGolem.writeEntityToNBT(compound);}
		    		if(id == 24){SnowMan.writeEntityToNBT(compound);}
		    		if(id == 25){Giant.writeEntityToNBT(compound);}
	
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		compound2.setTag("SpawnData", compound);
		    		logic.writeToNBT(compound2);
		    		
		    		logic.readFromNBT(compound2);
    	}
    }
    
    public static String getMob(World world, int x, int y, int z){
       	TileEntity spawner = world.getTileEntity(x, y, z);
    	MobSpawnerBaseLogic logic = ((TileEntityMobSpawner)spawner).func_145881_a();
    	String entity = logic.getEntityNameToSpawn();
    	return entity;
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
	    if(!world.isRemote){
	    	 ItemStack currentItem = player.getCurrentEquippedItem();    	
	    	 if(currentItem != null && currentItem.getItem() == ItemList.ActivationCrystal){
	    		 player.openGui(Main.instance, 5, world, x, y, z);
	    	 }
	    }
		return true;
   }
}
