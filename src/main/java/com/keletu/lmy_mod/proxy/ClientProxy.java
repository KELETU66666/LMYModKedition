package com.keletu.lmy_mod.proxy;

import codechicken.lib.texture.TextureUtils;
import com.keletu.lmy_mod.item.ItemIngotAThaumium;
import com.keletu.lmy_mod.lmyTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        TextureUtils.addIconRegister(new lmyTextures());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        registerItemColourHandlers();
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
        ModelLoader.setCustomModelResourceLocation(DarkSlimeball, 0, new ModelResourceLocation(DarkSlimeball.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(superItem, 0, new ModelResourceLocation(superItem.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ingotAllTheThaumium, 0, new ModelResourceLocation(ingotAllTheThaumium.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(extremeItem, 0, new ModelResourceLocation(extremeItem.getRegistryName(), "inventory"));
    }

    private static void registerItemColourHandlers() {
        IItemColor itemCrystalPlanterColourHandler = (stack, tintIndex) -> {
            Item item = stack.getItem();
            if (item == CommonProxy.ingotAllTheThaumium) {
                return ((ItemIngotAThaumium) item).getColor(stack, tintIndex);
            }
            return 16777215;
        };

        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(itemCrystalPlanterColourHandler, CommonProxy.ingotAllTheThaumium);

    }
}
