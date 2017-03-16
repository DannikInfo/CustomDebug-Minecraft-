package ru.dannik.powercraft.gui.Gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import ru.dannik.powercraft.Main;
import ru.dannik.powercraft.gui.container.ContainerTeleporter;

public class GuiTeleporter extends GuiContainer{
	
	    final private ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/gui/Teleporter.png");//Ваши modid и путь к текстуре gui
		private GuiTextField text;
		NBTTagCompound nbt = new NBTTagCompound();
		String udid;
	
	    public GuiTeleporter(EntityPlayer player, String udidB){
	        super(new ContainerTeleporter());//Теперь понятно, зачем такие же параметры?
	        udid = udidB;
	        xSize = 180;//Тут размеры, сколько на сколько собстно, кликабельная картинка вашего gui(ведь файл текстуры должен быть 256 на 256!)
	        ySize = 200;// и до скольки мы обрежем при рендере, чтобы понятно было.
	    }
	    
	    public void initGui()
	    {
	        this.text = new GuiTextField(this.fontRendererObj, this.width / 2 - 90, this.height/2 - 82, 160, 20);
	        text.setMaxStringLength(32);
	        this.text.setFocused(true);
	        buttonList.clear();
	        buttonList.add(new GuiButton(1, (this.width - ySize) / 2 + 20, this.height / 2 - 52, 60, 20, "ОK"));
	        buttonList.add(new GuiButton(2, (this.width - ySize) / 2 + 100, this.height / 2 - 52, 60, 20 , "Settings"));
	    }
	    
	    public void updateScreen()
	    {
	        super.updateScreen();
	        this.text.updateCursorCounter();
	    }
	    
	    protected void actionPerformed(GuiButton button){
	    	 switch (button.id){
	    	 	case 1:{
	    		 	this.mc.displayGuiScreen((GuiScreen)null);
	    		 	this.mc.setIngameFocus();
	    		 	break;
	    	 	}
	    	 	default:{
	    		 	break;
	    	 	}
	    	 }
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
