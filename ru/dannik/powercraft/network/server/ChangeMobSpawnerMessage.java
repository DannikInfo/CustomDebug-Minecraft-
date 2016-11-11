package ru.dannik.powercraft.network.server;

import java.io.IOException;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import ru.dannik.powercraft.BlocksL.Spawner;
import ru.dannik.powercraft.network.AbstractMessage.AbstractServerMessage;

public class ChangeMobSpawnerMessage extends AbstractServerMessage<ChangeMobSpawnerMessage>{
	private int xS,yS,zS,id;
	private String ent;

	public ChangeMobSpawnerMessage() {}
	Spawner sp = new Spawner();

	public ChangeMobSpawnerMessage(int x, int y, int z, String ent, int id) {
		this.xS = x;
		this.yS = y;
		this.zS = z;
		this.id = id;
		this.ent = ent;
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException{
		xS = buffer.readInt();
		yS = buffer.readInt();
		zS = buffer.readInt();
		id = buffer.readInt();
		ent = ByteBufUtils.readUTF8String(buffer);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(xS);
		buffer.writeInt(yS);
		buffer.writeInt(zS);
		buffer.writeInt(id);
		ByteBufUtils.writeUTF8String(buffer, ent);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		sp.changeMob(player.worldObj, this.xS, this.yS, this.zS, this.ent, id);
	}
}
