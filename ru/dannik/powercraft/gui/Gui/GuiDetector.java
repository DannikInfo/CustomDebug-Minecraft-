package ru.dannik.powercraft.gui.Gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.BlocksL.logic.Detector.Detector;
import ru.dannik.powercraft.gui.container.ContainerDetector;

public class GuiDetector extends GuiContainer{

	 final private ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/gui/Teleporter.png");//Ваши modid и путь к текстуре gu
		public String[] ent = new String[]{"Pig","Zombie","PigZombie","Creeper","Spider","Slime","CaveSpider","LavaSlime","Cow","Skeleton","Ghast","Enderman","Silverfish","Blaze","Bat","Witch","Sheep","Chicken","Squid","Wolf","MushroomCow","Ozelot","Villager","VillagerGolem","SnowMan","Giant",};
	    public int xS,yS,zS,page;
	    World worldA;
		
	    public GuiDetector(EntityPlayer player, World world, int x, int y, int z){
	        super(new ContainerDetector());
	        worldA = world;
	        xS = x;
	        yS = y;
	        zS = z;
	        xSize = 179;//Тут размеры, сколько на сколько собстно, кликабельная картинка вашего gui(ведь файл текстуры должен быть 256 на 256!)
	        ySize = 200;// и до скольки мы обрежем при рендере, чтобы понятно было.
	    }
	    
	    public void initGui(){
	    	buttonList.clear();
	    	Detector dt = new Detector();
	    	int range = dt.getRange();
	    	buttonList.add(new GuiButton(1000, (this.width - ySize) / 2 + 5, this.height / 2 - 80, 169, 20, StatCollector.translateToLocal("gui.powercraftreloaded.detectorhead.name" + range)));
	    	buttonList.add(new GuiButton(1002, (this.width - ySize) / 2 + 42, (this.height / 2 - 52) + 126, 19, 20, StatCollector.translateToLocal("gui.powercraftreloaded.rangeplus.name")));
	    	buttonList.add(new GuiButton(1003, (this.width - ySize) / 2 + 62, (this.height / 2 - 52) + 126, 19, 20, StatCollector.translateToLocal("gui.powercraftreloaded.rangeminus.name")));
	    }
	    
	    protected void actionPerformed(GuiButton button){
	    		 switch (button.id){
	    		//navigation button
	    	 	case 1002:{page = 0;this.initGui();break;}
	    	 	case 1003:{page = 1;this.initGui();break;}
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
