package ru.dannik.powercraft.gui.Gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.gui.container.ContainerTeleporter;

public class GuiTeleporterSettings extends GuiContainer{

    final private ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/gui/Teleporter.png");//Ваши modid и путь к текстуре gu

    public GuiTeleporterSettings(EntityPlayer player, String udid){
        super(new ContainerTeleporter());//Теперь понятно, зачем такие же параметры?
        xSize = 180;//Тут размеры, сколько на сколько собстно, кликабельная картинка вашего gui(ведь файл текстуры должен быть 256 на 256!)
        ySize = 200;// и до скольки мы обрежем при рендере, чтобы понятно было.
    }
    
    public void initGui(){
    	
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mX, int mY) {
        int zX = (width - ySize) / 2; //Находим "координаты верхней левой точки прямоугольника с размерами нашей текстуры, который находится в центре экрана"
        int zY = (height - ySize) / 2;// как я это называю
        mc.getTextureManager().bindTexture(texture);//Ну это понятно
        drawTexturedModalRect(zX, zY, 0, 0, xSize, ySize);//Отрисовываем на "тех самых координатах" картинку, начиная с 0, 0 координаты тестуры(u, v) и размерами, которые мы указали
    }
}