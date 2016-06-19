package ru.dannik.powercraft;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import ru.dannik.powercraft.BlocksL.BlockList;
import ru.dannik.powercraft.BlocksL.Crystal.Cyan.RendererCyanCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Cyan.RendererItemCyanCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Cyan.TileEntityCyanCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.DarkBlue.RendererDarkBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.DarkBlue.RendererItemDarkBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.DarkBlue.TileEntityDarkBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Green.RendererGreenCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Green.RendererItemGreenCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Green.TileEntityGreenCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.LightBlue.RendererItemLightBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.LightBlue.RendererLightBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.LightBlue.TileEntityLightBlueCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Orange.RendererItemOrangeCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Orange.RendererOrangeCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Orange.TileEntityOrangeCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Purple.RendererItemPurpleCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Purple.RendererPurpleCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Purple.TileEntityPurpleCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Red.RendererItemRedCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Red.RendererRedCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Red.TileEntityRedCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Yellow.RendererItemYellowCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Yellow.RendererYellowCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.Yellow.TileEntityYellowCrystal;
import ru.dannik.powercraft.BlocksL.IronFrame.RendererIronFrame;
import ru.dannik.powercraft.BlocksL.IronFrame.RendererItemIronFrame;
import ru.dannik.powercraft.BlocksL.IronFrame.TileEntityIronFrame;
import ru.dannik.powercraft.BlocksL.Teleporter.RendererItemPowerPortal;
import ru.dannik.powercraft.BlocksL.Teleporter.RendererPowerPortal;
import ru.dannik.powercraft.BlocksL.Teleporter.TileEntityPowerPortal;
import ru.dannik.powercraft.ItemsL.activationcrystal.Plasm;

public class ClientProxy extends CommonProxy {

	public void preInit() {
		super.preInit();
	}

	public void init() {
		super.init();
		//Blocks
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerPortal.class, new RendererPowerPortal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronFrame.class, new RendererIronFrame());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightBlueCrystal.class, new RendererLightBlueCrystal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRedCrystal.class, new RendererRedCrystal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGreenCrystal.class, new RendererGreenCrystal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDarkBlueCrystal.class, new RendererDarkBlueCrystal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPurpleCrystal.class, new RendererPurpleCrystal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOrangeCrystal.class, new RendererOrangeCrystal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCyanCrystal.class, new RendererCyanCrystal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityYellowCrystal.class, new RendererYellowCrystal());
		
		//items
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.powerportal), (IItemRenderer) new RendererItemPowerPortal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.ironframe), (IItemRenderer) new RendererItemIronFrame());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.lightbluecrystal), (IItemRenderer) new RendererItemLightBlueCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.redcrystal), (IItemRenderer) new RendererItemRedCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.greencrystal), (IItemRenderer) new RendererItemGreenCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.darkbluecrystal), (IItemRenderer) new RendererItemDarkBlueCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.purplecrystal), (IItemRenderer) new RendererItemPurpleCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.orangecrystal), (IItemRenderer) new RendererItemOrangeCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.cyancrystal), (IItemRenderer) new RendererItemCyanCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.yellowcrystal), (IItemRenderer) new RendererItemYellowCrystal());
		
	}

}
