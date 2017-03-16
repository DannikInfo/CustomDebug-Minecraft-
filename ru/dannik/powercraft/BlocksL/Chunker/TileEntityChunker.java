package ru.dannik.powercraft.BlocksL.Chunker;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ModContainer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import net.minecraftforge.common.ForgeChunkManager.Type;
import ru.dannik.powercraft.Main;

public class TileEntityChunker extends TileEntity{
	
	private Ticket chunkTicket;
	public World world;
	
	public void loadChunks()
	{
				while(chunkTicket == null){
					chunkTicket = ForgeChunkManager.requestTicket(Main.getMod(), world, Type.NORMAL);
				}
				 //System.out.println("FuckingHell");
			 
				chunkTicket.getModData().setInteger("type", ChunkerCallback.ChunkLoaderBlockID);
				chunkTicket.getModData().setInteger("blockX", xCoord);
				chunkTicket.getModData().setInteger("blockY", yCoord);
				chunkTicket.getModData().setInteger("blockZ", zCoord);
				
				ForgeChunkManager.forceChunk(chunkTicket, new ChunkCoordIntPair(xCoord>>4, zCoord >>4));
	}
	
	 
	 public void unloadChunks()
	 {
		 ForgeChunkManager.unforceChunk(chunkTicket, new ChunkCoordIntPair(xCoord>>4, zCoord >>4));
	 }
	 
	 public void loadTicket(Ticket ticket)
	 {
		 if (chunkTicket == null)
		 {
				chunkTicket = ticket;
		 }
		 ChunkCoordIntPair loadChunk = new ChunkCoordIntPair(xCoord >> 4, zCoord >> 4);
		 ForgeChunkManager.forceChunk(ticket, loadChunk);
	 }
}