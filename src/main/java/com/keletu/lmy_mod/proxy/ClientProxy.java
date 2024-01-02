package com.keletu.lmy_mod.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public void modelRegistryEvent(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(SwordOfImmolation, 0, new ModelResourceLocation(SwordOfImmolation.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(CreeperHeart, 0, new ModelResourceLocation(CreeperHeart.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(EnergeticEnderEye, 0, new ModelResourceLocation(EnergeticEnderEye.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(EnderHeart, 0, new ModelResourceLocation(EnderHeart.getRegistryName(), "inventory"));
    }
}
