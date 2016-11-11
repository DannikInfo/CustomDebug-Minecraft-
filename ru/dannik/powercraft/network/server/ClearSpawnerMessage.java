package ru.dannik.powercraft.network.server;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import ru.dannik.powercraft.BlocksL.Spawner;
import ru.dannik.powercraft.network.AbstractMessage.AbstractServerMessage;

public class ClearSpawnerMessage extends AbstractServerMessage<ClearSpawnerMessage>{
	
	private int xS,yS,zS;

	public ClearSpawnerMessage() {}
	Spawner sp = new Spawner();

	public ClearSpawnerMessage(int x, int y, int z) {
		this.xS = x;
		this.yS = y;
		this.zS = z;
	}
	
	@Override
	protected void read(PacketBuffer buffer){
		xS = buffer.readInt();
		yS = buffer.readInt();
		zS = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) {
		buffer.writeInt(xS);
		buffer.writeInt(yS);
		buffer.writeInt(zS);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		sp.clearSpawner(player.worldObj, this.xS, this.yS, this.zS);
	}

}
