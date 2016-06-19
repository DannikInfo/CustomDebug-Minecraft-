package ru.dannik.powercraft.BlocksL.Harvester;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ru.dannik.powercraft.Main;

public class Harvester extends Block{
	
	public Object blockIcon_back;
	public Object blockIcon_front;
	public Object blockIcon_top;
	public Object blockIcon_bottom;
	public Object blockIcon_side;
	
	public Harvester() {
		super(Material.circuits);
		setCreativeTab(Main.tabPowerCraft);
		setHardness(0.25F);
		setBlockTextureName("Coblestone");
		setBlockName(Main.MODID + ".Harvester");
	}
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		blockIcon_front = reg.registerIcon("powercraftreloaded:Harvester" + "_" + 4);
		blockIcon_back = reg.registerIcon("powercraftreloaded:Harvester" + "_" + 5);
		blockIcon_top = reg.registerIcon("powercraftreloaded:Harvester" + "_" + 0);
		blockIcon_bottom = reg.registerIcon("powercraftreloaded:Harvester" + "_" + 0);
		blockIcon_side = reg.registerIcon("powercraftreloaded:Harvester" + "_" + 0);
	}
	
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityRay();
	}
	
    public IIcon getIcon(int side, int meta) {
        ForgeDirection dir = ForgeDirection.getOrientation(side);
        ForgeDirection block_dir;
        if (meta != 0)
            block_dir = ForgeDirection.getOrientation(meta);
        else
            block_dir = ForgeDirection.WEST; // Блок в инвентаре.
        if (block_dir == dir) return (IIcon) blockIcon_front;
        if (block_dir.getOpposite() == dir) return (IIcon) blockIcon_back;
        if (dir == ForgeDirection.UP) return (IIcon) blockIcon_top;
        if (dir == ForgeDirection.DOWN) return (IIcon) blockIcon_bottom;
        return (IIcon) blockIcon_side;
    }
	
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z,
            EntityLivingBase entity, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entity, itemStack);
        int dir = (MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
        int[] r = {2, 5, 3, 4};
        world.setBlockMetadataWithNotify(x, y, z, r[dir], 3);
    }
	
    public void onNeighborBlockChange(World world, int x, int y, int z, Block b) {
    	if(world.isBlockIndirectlyGettingPowered(x, y, z)) {
			Minecraft.getMinecraft().thePlayer.sendChatMessage("[DEV]:Возникла проблема с  его реализацией - отодвинул немного на 2 план :)");
		}
	}
	
		
}
