package ru.dannik.powercraft.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;

public class GuiPowerPortal extends GuiContainer{
	
	    final private ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/gui/guispawner.png");//Ваши modid и путь к текстуре gui
		private GuiTextField text;
	
	    public GuiPowerPortal(EntityPlayer player){
	        super(new ContainerPowerPortal());//Теперь понятно, зачем такие же параметры?
	        xSize = 200;//Тут размеры, сколько на сколько собстно, кликабельная картинка вашего gui(ведь файл текстуры должен быть 256 на 256!)
	        ySize = 100;// и до скольки мы обрежем при рендере, чтобы понятно было.
	    }
	    
	    public void initGui()
	    {
	        this.text = new GuiTextField(this.fontRendererObj, this.width / 2 - 68, this.height/2-46, 137, 20);
	        text.setMaxStringLength(23);
	        text.setText("sample text");
	        this.text.setFocused(true);
	        buttonList.clear();
	        buttonList.add(new GuiButton(0, 50, 100, 60, 60, "ОК"));
	    }
	    
	    public void updateScreen()
	    {
	        super.updateScreen();
	        this.text.updateCursorCounter();
	    }
	    
	    protected void keyTyped(char par1, int par2)
	    {
	        super.keyTyped(par1, par2);
	        this.text.textboxKeyTyped(par1, par2);
	    }
	
	    @Override
	    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mX, int mY) {
	        int zX = (width - ySize) / 2; //Находим "координаты верхней левой точки прямоугольника с размерами нашей текстуры, который находится в центре экрана"
	        int zY = (height - ySize) / 2;// как я это называю
	        mc.getTextureManager().bindTexture(texture);//Ну это понятно
	        drawTexturedModalRect(zX, zY, 0, 0, xSize, ySize);//Отрисовываем на "тех самых координатах" картинку, начиная с 0, 0 координаты тестуры(u, v) и размерами, которые мы указали
	        this.text.drawTextBox();
	        
	    }
	    
	    protected void mouseClicked(int x, int y, int btn) {
	        super.mouseClicked(x, y, btn);
	        this.text.mouseClicked(x, y, btn);
	    }

}
