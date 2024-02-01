
package com.keletu.lmy_mod.proxy;


import com.keletu.lmy_mod.LMYMod;
import com.keletu.lmy_mod.item.ItemIngotAThaumium;
import com.keletu.lmy_mod.item.ItemSpecialSword;
import com.keletu.lmy_mod.item.ItemSuperium;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CommonProxy {
    public static ItemSpecialSword SwordOfImmolation = new ItemSpecialSword("sword_of_immolation", 40);
    public static Item CreeperHeart = new Item().setRegistryName(LMYMod.MOD_ID, "creeper_heart").setTranslationKey("creeper_heart");
    public static Item EnderHeart = new Item().setRegistryName(LMYMod.MOD_ID, "ender_heart").setTranslationKey("ender_heart");
    public static Item EnergeticEnderEye = new Item().setRegistryName(LMYMod.MOD_ID, "energetic_ender_eye").setTranslationKey("energetic_ender_eye");
    public static Item DarkSlimeball = new Item().setRegistryName(LMYMod.MOD_ID, "dark_slimeball").setTranslationKey("dark_slimeball");
    public static Item superItem = new ItemSuperium().setRegistryName(LMYMod.MOD_ID, "ingot_rainbow_pro").setTranslationKey("ingot_rainbow_pro");
    public static Item extremeItem = new ItemSuperium().setRegistryName(LMYMod.MOD_ID, "ingot_rainbow_pro_max").setTranslationKey("ingot_rainbow_pro_max");
    public static Item ingotAllTheThaumium = new ItemIngotAThaumium();

    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }


    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(SwordOfImmolation);
        event.getRegistry().register(CreeperHeart);
        event.getRegistry().register(EnderHeart);
        event.getRegistry().register(EnergeticEnderEye);
        event.getRegistry().register(DarkSlimeball);
        event.getRegistry().register(superItem);
        event.getRegistry().register(extremeItem);
        event.getRegistry().register(ingotAllTheThaumium);
    }

    @SideOnly(Side.CLIENT)
    public void modelRegistryEvent(ModelRegistryEvent event) {

    }
}
