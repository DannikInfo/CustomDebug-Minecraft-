package ru.dannik.powercraft;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import ru.dannik.powercraft.BlocksL.BlockList;
import ru.dannik.powercraft.BlocksL.Crystal.RendererCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.RendererItemCrystal;
import ru.dannik.powercraft.BlocksL.Crystal.TileEntityCrystal;
import ru.dannik.powercraft.BlocksL.Laser.RendererItemLaser;
import ru.dannik.powercraft.BlocksL.Laser.RendererLaser;
import ru.dannik.powercraft.BlocksL.Laser.TileEntityLaser;
import ru.dannik.powercraft.BlocksL.Teleporter.RendererItemTeleporter;
import ru.dannik.powercraft.BlocksL.Teleporter.RendererTeleporter;
import ru.dannik.powercraft.BlocksL.Teleporter.TileEntityTeleporter;
import ru.dannik.powercraft.BlocksL.deco.Chimeny.RendererChimeny;
import ru.dannik.powercraft.BlocksL.deco.Chimeny.RendererItemChimeny;
import ru.dannik.powercraft.BlocksL.deco.Chimeny.TileEntityChimeny;
import ru.dannik.powercraft.BlocksL.deco.IronFrame.RendererIronFrame;
import ru.dannik.powercraft.BlocksL.deco.IronFrame.RendererItemIronFrame;
import ru.dannik.powercraft.BlocksL.deco.IronFrame.TileEntityIronFrame;
import ru.dannik.powercraft.BlocksL.logic.Detector.RendererDetector;
import ru.dannik.powercraft.BlocksL.logic.Detector.RendererDetectorOff;
import ru.dannik.powercraft.BlocksL.logic.Detector.RendererItemDetector;
import ru.dannik.powercraft.BlocksL.logic.Detector.TileEntityDetector;
import ru.dannik.powercraft.BlocksL.logic.Detector.TileEntityDetectorOff;

public class ClientProxy extends CommonProxy {

	public void preInit() {
		super.preInit();
	}

	public void init() {
		super.init();
		//Blocks
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeleporter.class, new RendererTeleporter());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronFrame.class, new RendererIronFrame());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystal.class, new RendererCrystal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLaser.class, new RendererLaser());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChimeny.class, new RendererChimeny());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDetector.class, new RendererDetector());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDetectorOff.class, new RendererDetectorOff());
		
		//items
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.teleporter), (IItemRenderer) new RendererItemTeleporter());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.ironframe), (IItemRenderer) new RendererItemIronFrame());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.crystal), (IItemRenderer) new RendererItemCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.laser), (IItemRenderer) new RendererItemLaser());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.chimeny), (IItemRenderer) new RendererItemChimeny());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.detector), (IItemRenderer) new RendererItemDetector());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockList.detectoroff), (IItemRenderer) new RendererItemDetector());
	}
	

	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		// Note that if you simply return 'Minecraft.getMinecraft().thePlayer',
		// your packets will not work as expected because you will be getting a
		// client player even when you are on the server!
		// Sounds absurd, but it's true.

		// Solution is to double-check side before returning the player:
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}



}
