package ru.dannik.powercraft.ItemsL.activationcrystal;

import java.util.Random;

import net.minecraft.block.BlockMobSpawner;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.BlocksL.BlockList;

public class Spawner extends BlockMobSpawner{
	
	public Spawner(){
		setHardness(1.0F);
		setCreativeTab(Main.tabPowerCraft);
		this.setBlockTextureName("powercraftreloaded:spawner");
	}
	
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }
    
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
    	return Item.getItemFromBlock(BlockList.spawner);
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
	    	
	    	//list all minecraft entity
	    	
	    	EntityPig pig = new EntityPig(world);
	    	EntityZombie zombie = new EntityZombie(world);
	    	EntityPigZombie pig_zombie = new EntityPigZombie(world);
	    	EntityCreeper creeper = new EntityCreeper(world);
	    	EntitySpider spider = new EntitySpider(world);
	    	EntitySlime slime = new EntitySlime(world);
	    	EntityCaveSpider cave_spider = new EntityCaveSpider(world);
	    	EntityMagmaCube magma_cube = new EntityMagmaCube(world);
	    	EntityCow cow = new EntityCow(world);
	    	EntitySkeleton skeleton = new EntitySkeleton(world);
	    	EntityGhast ghast = new EntityGhast(world);
	    	EntityEnderman enderman = new EntityEnderman(world);
	    	EntitySilverfish silver_fish = new EntitySilverfish(world);
	    	EntityBlaze blaze = new EntityBlaze(world);
	    	EntityBat bat = new EntityBat(world);
	    	EntityWitch witch = new EntityWitch(world);
	    	EntitySheep sheep = new EntitySheep(world);
	    	EntityChicken chicken = new EntityChicken(world);
	    	EntitySquid squid = new EntitySquid(world);
	    	EntityWolf wolf = new EntityWolf(world);
	    	EntityMooshroom mooshroom = new EntityMooshroom(world);
	    	EntityOcelot ocelot = new EntityOcelot(world);
	    	EntityHorse horse = new EntityHorse(world);
	    	EntityVillager villager = new EntityVillager(world);
	    	EntityIronGolem iron_golem = new EntityIronGolem(world);
	    	EntitySnowman snow_golem = new EntitySnowman(world);
	    	EntityGiantZombie Giant = new EntityGiantZombie(world);
	    	
	    	TileEntity spawner = world.getTileEntity(x, y, z);
	    	
	    	if (spawner instanceof TileEntityMobSpawner){
	    		MobSpawnerBaseLogic logic = ((TileEntityMobSpawner)spawner).func_145881_a();
	    		String entity = logic.getEntityNameToSpawn();
	    		if(entity == "Pig"){  		
		    		logic.setEntityName("VillagerGolem");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		iron_golem.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
		    	}
	    		if(entity == "VillagerGolem"){	    		
	    			world.setBlock(x, y, z, Blocks.air);
		    		world.setBlock(x, y, z, BlockList.spawner);    	
	    		}
	    		
	    		/*if(entity_id == 2){
	    			logic.setEntityName("Creeper");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	
	    		}
		    		//Minecraft.getMinecraft().thePlayer.sendChatMessage("моб в спавнере:"+ entity);
		    		//Minecraft.getMinecraft().thePlayer.sendChatMessage("в спавнере стоит крипер!");;
		    		}//else if(entity == "Creeper"){	    		
		    		//logic.setEntityName("Slime");
		    		//NBTTagCompound compound = new NBTTagCompound();
		    	//	slime.writeEntityToNBT(compound);
		    		//NBTTagCompound compound2 = new NBTTagCompound();
		    		//logic.writeToNBT(compound);
		    		//compound2.setTag("SpawnData", compound);
	
		    		//logic.readFromNBT(compound2);
		    		//Minecraft.getMinecraft().thePlayer.sendChatMessage("моб в спавнере:"+ entity);
		    		//Minecraft.getMinecraft().thePlayer.sendChatMessage("в спавнере стоит слайм!");
	       		else if(entity == "Creeper"){	    		
		    		logic.setEntityName("Pig");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		pig.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
		    		
	
		    		logic.readFromNBT(compound2);
		    		Minecraft.getMinecraft().thePlayer.sendChatMessage("моб в спавнере:"+ entity);
		    		Minecraft.getMinecraft().thePlayer.sendChatMessage("в спавнере теперь стоит CaveSpider!");
		    		
	       		}else if(entity == "CaveSpider"){	    		
		    		logic.setEntityName("MagmaCube");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		magma_cube.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "MagmaCube"){	    		
		    		logic.setEntityName("Cow");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Cow"){	    		
		    		logic.setEntityName("Skeleton");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Skeleton"){	    		
		    		logic.setEntityName("Ghast");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Ghast"){	    		
		    		logic.setEntityName("Enderman");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Enderman"){	    		
		    		logic.setEntityName("Silverfish");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Silverfish"){	    		
		    		logic.setEntityName("Blaze");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Blaze"){	    		
		    		logic.setEntityName("Bat");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Bat"){	    		
		    		logic.setEntityName("Witch");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Witch"){	    		
		    		logic.setEntityName("Sheep");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Sheep"){	    		
		    		logic.setEntityName("Chicken");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Chicken"){	    		
		    		logic.setEntityName("Squid");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Squid"){	    		
		    		logic.setEntityName("Wolf");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Wolf"){	    		
		    		logic.setEntityName("Mooshroom");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Mooshroom"){	    		
		    		logic.setEntityName("Ocelot");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Ocelot"){	    		
		    		logic.setEntityName("Horse");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Horse"){	    		
		    		logic.setEntityName("Villager");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Villager"){	    		
		    		logic.setEntityName("IronGolem");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "IronGolem"){	    		
		    		logic.setEntityName("Snowman");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "Snowman"){	    		
		    		logic.setEntityName("GiantZombie");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}
	       		if(entity == "GiantZombie"){	    		
		    		logic.setEntityName("Pig");
		    		NBTTagCompound compound = new NBTTagCompound();
		    		creeper.writeEntityToNBT(compound);
		    		NBTTagCompound compound2 = new NBTTagCompound();
		    		logic.writeToNBT(compound2);
		    		compound2.setTag("SpawnData", compound);
	
		    		logic.readFromNBT(compound2);
	    		}*/
	    	}
		return true;
   }
}
