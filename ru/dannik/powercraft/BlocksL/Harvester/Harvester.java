package ru.dannik.powercraft.BlocksL.Harvester;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.BlocksL.Harvester.RendererBeam;

public class Harvester extends Block{
	
	public Object blockIcon_back;
	public Object blockIcon_front;
	public Object blockIcon_top;
	public Object blockIcon_bottom;
	public Object blockIcon_side;
	NBTTagCompound nbt = new NBTTagCompound();
	int i;
	
	public Harvester() {
		super(Material.rock);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(0.25F);
		setBlockTextureName("Coblestone");
		setBlockName(Main.MODID + ".Harvester");
	}
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		blockIcon_front = reg.registerIcon("powercraftreloaded:Harvester" + "_" + "side");
		blockIcon_back = reg.registerIcon("powercraftreloaded:Harvester" + "_" + "front");
		blockIcon_top = reg.registerIcon("powercraftreloaded:Machines" + "_" + "top");
		blockIcon_bottom = reg.registerIcon("powercraftreloaded:Machines" + "_" + "top");
		blockIcon_side = reg.registerIcon("powercraftreloaded:Machines" + "_" + "top");
	}
	
    public IIcon getIcon(int side, int meta) {
        ForgeDirection dir = ForgeDirection.getOrientation(side);
        ForgeDirection block_dir;
        if (meta != 0)
            block_dir = ForgeDirection.getOrientation(meta);
        else
            block_dir = ForgeDirection.EAST; // Блок в инвентаре.
        if (block_dir == dir) return (IIcon) blockIcon_front;
        if (block_dir.getOpposite() == dir) return (IIcon) blockIcon_back;
        if (dir == ForgeDirection.UP) return (IIcon) blockIcon_top;
        if (dir == ForgeDirection.DOWN) return (IIcon) blockIcon_bottom;
        return (IIcon) blockIcon_side;
    }
	
    public void onBlockPlacedBy(World world, int x, int y, int z,
            EntityLivingBase entity, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entity, itemStack);
        int dir = (MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
        int[] r = {2, 5, 3, 4};
        world.setBlockMetadataWithNotify(x, y, z, r[dir], 3);
        nbt.setInteger("front", dir);
        nbt.setInteger("Block", 1);
    }    
    
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityBeam();
	}
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block b) {
    	if(!world.isRemote){
    		if(world.isBlockIndirectlyGettingPowered(x, y, z)) {
    			int dir;
    			dir = nbt.getInteger("front");
    			i = nbt.getInteger("Block");
    			if(!world.isRemote){
    				if(dir == 0){
    					if(i < 32){
    						if(!world.isRemote){
    							for(int k = 1; k < 32; ++k){
    								if(world.getBlock(x, y, z + k) != Blocks.air){
    									i = k;
    									break;
    								}
    							}
    						}
	    				z = z + i;
		    			if(world.getBlock(x, y, z) != Blocks.air && world.getBlock(x, y, z) != Blocks.obsidian && world.getBlock(x, y, z) != Blocks.stonebrick && world.getBlock(x, y, z) != Blocks.water && world.getBlock(x, y, z) != Blocks.flowing_water && world.getBlock(x, y, z) != Blocks.lava && world.getBlock(x, y, z) != Blocks.flowing_lava){
		    				Block block = world.getBlock(x, y, z);
						    world.setBlock(x, y, z, Blocks.air);
						    i++;
						    world.spawnEntityInWorld(new EntityItem(world, x + 0.5, y, z - i, new ItemStack(block)));
		    			}
	    			}
	    		}
				if(dir == 1){				
				    if(i < 32){
				    	for(int k = 1; k < 32; ++k){
				    		if(world.getBlock(x - k, y, z) != Blocks.air){
				    			i = k;
				    			break;
				    		}
				    	}
	    				x = x - i;
		    			if(world.getBlock(x, y, z) != Blocks.air && world.getBlock(x, y, z) != Blocks.obsidian && world.getBlock(x, y, z) != Blocks.stonebrick && world.getBlock(x, y, z) != Blocks.water && world.getBlock(x, y, z) != Blocks.flowing_water && world.getBlock(x, y, z) != Blocks.lava && world.getBlock(x, y, z) != Blocks.flowing_lava){
		    				Block block = world.getBlock(x, y, z);
						    world.setBlock(x, y, z, Blocks.air);
						    i++;
						    world.spawnEntityInWorld(new EntityItem(world, x + i, y, z, new ItemStack(block)));
		    			}
				   }
				}
				if(dir == 2){			
					if(i < 32){
						for(int k = 1; k < 32; ++k){
							if(world.getBlock(x, y, z - k) != Blocks.air){
								i = k;
								break;
							}
						}
	    				z = z - i;
		    			if(world.getBlock(x, y, z) != Blocks.air && world.getBlock(x, y, z) != Blocks.obsidian && world.getBlock(x, y, z) != Blocks.stonebrick && world.getBlock(x, y, z) != Blocks.water && world.getBlock(x, y, z) != Blocks.flowing_water && world.getBlock(x, y, z) != Blocks.lava && world.getBlock(x, y, z) != Blocks.flowing_lava){
		    				Block block = world.getBlock(x, y, z);
						    world.setBlock(x, y, z, Blocks.air);
						    i++;
						    world.spawnEntityInWorld(new EntityItem(world, x, y, z + i, new ItemStack(block)));
		    			}
					}
				}
				if(dir == 3){		
					if(i < 32){
						for(int k = 1; k < 32; ++k){
							if(world.getBlock(x + k, y, z) != Blocks.air){
								i = k;
								break;
							}
						}
	    				x = x + i;
		    			if(world.getBlock(x, y, z) != Blocks.air && world.getBlock(x, y, z) != Blocks.obsidian && world.getBlock(x, y, z) != Blocks.stonebrick && world.getBlock(x, y, z) != Blocks.water && world.getBlock(x, y, z) != Blocks.flowing_water && world.getBlock(x, y, z) != Blocks.lava && world.getBlock(x, y, z) != Blocks.flowing_lava){
		    				Block block = world.getBlock(x, y, z);
						    world.setBlock(x, y, z, Blocks.air);
						    i++;
						    world.spawnEntityInWorld(new EntityItem(world, x - i, y, z, new ItemStack(block)));
		    			}
					}	
				}
				nbt.setInteger("Block", i);
	    	}
    	}
    }
  }
}