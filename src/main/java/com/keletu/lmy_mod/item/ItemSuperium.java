package com.keletu.lmy_mod.item;

import morph.avaritia.api.IHaloRenderItem;
import morph.avaritia.init.AvaritiaTextures;
import morph.avaritia.util.TextUtils;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ItemSuperium extends Item implements IHaloRenderItem{

    @Override
    @SideOnly (Side.CLIENT)
    public boolean shouldDrawHalo(ItemStack stack) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {  //oooo a getter with a side effect
        return TextUtils.makeFabulous(I18n.format(stack.getTranslationKey() + ".name"));
    }

    @Override
    @SideOnly (Side.CLIENT)
    public TextureAtlasSprite getHaloTexture(ItemStack stack) {
        return AvaritiaTextures.HALO;
    }

    @Override
    public int getHaloColour(ItemStack itemStack) {
        return 0x33FFFFFF;
    }

    @Override
    @SideOnly (Side.CLIENT)
    public int getHaloSize(ItemStack stack) {
        return 4;
    }

    @Override
    @SideOnly (Side.CLIENT)
    public boolean shouldDrawPulse(ItemStack stack) {
        return true;
    }
}
