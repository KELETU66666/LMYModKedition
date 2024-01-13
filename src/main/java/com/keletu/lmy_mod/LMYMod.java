package com.keletu.lmy_mod;

import com.keletu.lmy_mod.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(
        modid = LMYMod.MOD_ID,
        name = LMYMod.MOD_NAME,
        version = LMYMod.VERSION,
        dependencies = "required-after:thaumcraft"
)
public class LMYMod {

    public static final String MOD_ID = "lmy_mod";
    public static final String MOD_NAME = "LMY";
    public static final String VERSION = "0.0.1";

    private static final LMYMod instance = new LMYMod();

    @SidedProxy(clientSide = "com.keletu.lmy_mod.proxy.ClientProxy", serverSide = "com.keletu.lmy_mod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {

        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            proxy.registerItems(event);
        }

        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public static void modelRegistryEvent(ModelRegistryEvent event) {
            proxy.modelRegistryEvent(event);
        }
    }

    public static LMYMod getInstance()
    {
        return instance;
    }
}
