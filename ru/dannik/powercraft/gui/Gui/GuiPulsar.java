package ru.dannik.powercraft.gui.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.gui.container.ContainerPulsar;

public class GuiPulsar extends GuiContainer{
	
    final private ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/gui/Pulsar.png");//Ваши modid и путь к текстуре gu
    
    private GuiTextField text;
    
    public GuiPulsar(){
        super(new ContainerPulsar());//Теперь понятно, зачем такие же параметры?
        xSize = 150;//Тут размеры, сколько на сколько собстно, кликабельная картинка вашего gui(ведь файл текстуры должен быть 256 на 256!)
        ySize = 126;// и до скольки мы обрежем при рендере, чтобы понятно было.
    }
    
    public void initGui(){
    	this.text = new GuiTextField(this.fontRendererObj, this.width / 2 - 90, this.height/2 - 82, 160, 20);
        text.setMaxStringLength(32);
        this.text.setFocused(true);
        buttonList.clear();
        buttonList.add(new GuiButton(1, (this.width - ySize) / 2 + 20, this.height / 2 - 52, 60, 20, "Cancel"));
        buttonList.add(new GuiButton(2, (this.width - ySize) / 2 + 100, this.height / 2 - 52, 60, 20 , "OK"));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mX, int mY) {
        int zX = (width - ySize) / 2; //Находим "координаты верхней левой точки прямоугольника с размерами нашей текстуры, который находится в центре экрана"
        int zY = (height - ySize) / 2;// как я это называю
        mc.getTextureManager().bindTexture(texture);//Ну это понятно
        drawTexturedModalRect(zX, zY, 0, 0, xSize, ySize);//Отрисовываем на "тех самых координатах" картинку, начиная с 0, 0 координаты тестуры(u, v) и размерами, которые мы указали
    }

}
