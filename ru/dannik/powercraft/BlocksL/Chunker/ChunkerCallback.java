package ru.dannik.powercraft.BlocksL.Chunker;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import ru.dannik.powercraft.BlocksL.BlockList;
import net.minecraftforge.common.ForgeChunkManager;

public class ChunkerCallback implements ForgeChunkManager.OrderedLoadingCallback {
	

	public static final int ChunkLoaderBlockID = 0;
	public static final int ChunkLoaderCartID = 1;
	public static final int ChunkLoaderQuarryID = 2;
	public static final int ChunkLoaderQuarryDigID = 3;
	
	@Override
	public void ticketsLoaded(List<Ticket> tickets, World world) 
	{
		

		for(Ticket ticket: tickets)
		{
			int type = ticket.getModData().getInteger("type");
			if(type == ChunkLoaderBlockID)
			{
				int blockX = ticket.getModData().getInteger("blockX");
				int blockY = ticket.getModData().getInteger("blockY");
				int blockZ = ticket.getModData().getInteger("blockZ");
				TileEntityChunker tcl = (TileEntityChunker) world.getTileEntity(blockX, blockY, blockZ);
				tcl.loadTicket(ticket);
			}
		}
		
	}

	@Override
	public List<Ticket> ticketsLoaded(List<Ticket> tickets, World world, int maxTicketCount) 
	{
		List<Ticket> validTickets = Lists.newArrayList();
		for(Ticket ticket: tickets)
		{
			int type = ticket.getModData().getInteger("type");
			if(type == ChunkLoaderBlockID)
			{
				int blockX = ticket.getModData().getInteger("blockX");
				int blockY = ticket.getModData().getInteger("blockY");
				int blockZ = ticket.getModData().getInteger("blockZ");
				Block block = world.getBlock(blockX, blockY, blockZ);
				//if(block == BlockList.chunker)
				//{
				//	validTickets.add(ticket);
				//}
			}
		}
		return validTickets;
	}
}
