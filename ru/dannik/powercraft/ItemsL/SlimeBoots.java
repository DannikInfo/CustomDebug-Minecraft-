package ru.dannik.powercraft.ItemsL;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.dannik.powercraft.Main;

public class SlimeBoots extends ItemArmor{

	 private String texturePath = "powercraftreloaded:textures/armor/";
     
     public SlimeBoots(int id, int armorType) {
             super(ArmorMaterial.IRON, id, armorType);
             this.setCreativeTab(Main.tabPowerCraft);
             this.setMaxStackSize(1);
             this.setTextureName();
     }

     public void setTextureName ()
     {
            this.texturePath += "SlimeBoots.png";
     }
     
     @Override
     public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type){
             return this.texturePath;
     }
     public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
         if(stack.getItem() == ItemList.SlimeBoots){
                 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 50, 1));
         }
     }
}
