package ru.dannik.powercraft.gui.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.blocks.logic.Spawner;
import ru.dannik.powercraft.gui.container.ContainerSpawner;
import ru.dannik.powercraft.network.PacketDispatcher;
import ru.dannik.powercraft.network.server.ChangeMobSpawnerMessage;
import ru.dannik.powercraft.network.server.ClearSpawnerMessage;

public class GuiSpawner extends GuiContainer{
		
	    final private ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/gui/Teleporter.png");//Ваши modid и путь к текстуре gu
		public String[] ent = new String[]{"Pig","Zombie","PigZombie","Creeper","Spider","Slime","CaveSpider","LavaSlime","Cow","Skeleton","Ghast","Enderman","Silverfish","Blaze","Bat","Witch","Sheep","Chicken","Squid","Wolf","MushroomCow","Ozelot","Villager","VillagerGolem","SnowMan","Giant",};
	    public int xS,yS,zS,page;
	    World worldA;
		
	    public GuiSpawner(EntityPlayer player, World world, int x, int y, int z){
	        super(new ContainerSpawner());
	        worldA = world;
	        xS = x;
	        yS = y;
	        zS = z;
	        xSize = 179;//Тут размеры, сколько на сколько собстно, кликабельная картинка вашего gui(ведь файл текстуры должен быть 256 на 256!)
	        ySize = 200;// и до скольки мы обрежем при рендере, чтобы понятно было.
	    }
	    
	    public void initGui(){
	    	buttonList.clear();
	    	String mob = Spawner.getMob(worldA, xS, yS, zS);
	    	buttonList.add(new GuiButton(1000, (this.width - ySize) / 2 + 5, this.height / 2 - 80, 169, 20, StatCollector.translateToLocal("entity.powercraftreloaded." + mob + ".name")));
	    	if(page == 0){
	    		for(int i = 0; i < 6; i++){
	        		buttonList.add(new GuiButton(i, (this.width - ySize) / 2 + 5, (this.height / 2 - 52) + (20 * i), 169, 20 , StatCollector.translateToLocal("entity.powercraftreloaded." + ent[i] + ".name")));
	        	}
	    	}
	    	if(page == 1){
	    		for(int i = 6; i < 12; i++){
	        		buttonList.add(new GuiButton(i, (this.width - ySize) / 2 + 5, (this.height / 2 - 52) + (20 * (i - 6)), 169, 20 , StatCollector.translateToLocal("entity.powercraftreloaded." + ent[i] + ".name")));
	        	}
	    	}
	    	if(page == 2){
	    		for(int i = 12; i < 18; i++){
	        		buttonList.add(new GuiButton(i, (this.width - ySize) / 2 + 5, (this.height / 2 - 52) + (20 * (i - 12)), 169, 20 , StatCollector.translateToLocal("entity.powercraftreloaded." + ent[i] + ".name")));
	        	}
	    	}
	    	if(page == 3){
	    		for(int i = 18; i < 24; i++){
	        		buttonList.add(new GuiButton(i, (this.width - ySize) / 2 + 5, (this.height / 2 - 52) + (20 * (i - 18)), 169, 20 , StatCollector.translateToLocal("entity.powercraftreloaded." + ent[i] + ".name")));
	        	}
	    	}
	    	if(page == 4){
	    		for(int i = 24; i < 26; i++){
	        		buttonList.add(new GuiButton(i, (this.width - ySize) / 2 + 5, (this.height / 2 - 52) + (20 * (i - 24)), 169, 20 , StatCollector.translateToLocal("entity.powercraftreloaded." + ent[i] + ".name")));
	        	}
	    	}
	    	buttonList.add(new GuiButton(1002, (this.width - ySize) / 2 + 42, (this.height / 2 - 52) + 126, 19, 20, "1"));
	    	buttonList.add(new GuiButton(1003, (this.width - ySize) / 2 + 62, (this.height / 2 - 52) + 126, 19, 20, "2"));
	    	buttonList.add(new GuiButton(1004, (this.width - ySize) / 2 + 82, (this.height / 2 - 52) + 126, 19, 20, "3"));
	    	buttonList.add(new GuiButton(1005, (this.width - ySize) / 2 + 102, (this.height / 2 - 52) + 126, 19, 20, "4"));
	    	buttonList.add(new GuiButton(1006, (this.width - ySize) / 2 + 122, (this.height / 2 - 52) + 126, 19, 20, "5"));
	    }
	    
	    protected void actionPerformed(GuiButton button){
	    		 switch (button.id){
	    		//navigation button
	    	 	case 1002:{page = 0;this.initGui();break;}
	    	 	case 1003:{page = 1;this.initGui();break;}
	    	 	case 1004:{page = 2;this.initGui();break;}
	    	 	case 1005:{page = 3;this.initGui();break;}
	    	 	case 1006:{page = 4;this.initGui();break;}
	    	 	
	    	 	//entity button
	    	 	case 0:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[0], 0));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 1:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[1], 1));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 2:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[2], 2));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 3:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[3], 3));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 4:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[4], 4));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 5:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[5], 5));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 6:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[6], 6));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 7:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[7], 7));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 8:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[8], 8));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 9:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[9], 9));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 10:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[10], 10));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 11:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[11], 11));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 12:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[12], 12));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 13:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[13], 13));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 14:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[14], 14));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 15:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[15], 15));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 16:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[16], 16));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 17:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[17], 17));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 18:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[18], 18));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 19:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[19], 19));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 20:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[20], 20));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 21:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[21], 21));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 22:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[22], 22));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 23:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[23], 23));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 24:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[24], 24));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}
	    	 	case 25:{PacketDispatcher.sendToServer(new ClearSpawnerMessage(xS, yS, zS));PacketDispatcher.sendToServer(new ChangeMobSpawnerMessage(xS, yS, zS, ent[25], 25));this.mc.displayGuiScreen((GuiScreen)null);this.mc.setIngameFocus();break;}

	    	 	//default
	    	 	default:{
	    		 	break;
	    	 	}
	    	 }
	    }

	    @Override
	    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mX, int mY) {
	        int zX = (width - ySize) / 2; //Находим "координаты верхней левой точки прямоугольника с размерами нашей текстуры, который находится в центре экрана"
	        int zY = (height - ySize) / 2;// как я это называю
	        mc.getTextureManager().bindTexture(texture);//Ну это понятно
	        drawTexturedModalRect(zX, zY, 0, 0, xSize, ySize);//Отрисовываем на "тех самых координатах" картинку, начиная с 0, 0 координаты тестуры(u, v) и размерами, которые мы указали
	    }
}
