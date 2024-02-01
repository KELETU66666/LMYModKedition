package com.keletu.lmy_mod;

import codechicken.lib.texture.TextureUtils.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

/**
 * Created by covers1624 on 17/04/2017.
 */
public class lmyTextures implements IIconRegister {

    @Override
    public void registerIcons(TextureMap textureMap) {
        map = textureMap;

        //@formatter:off
        HALO = register("lmy_mod:items/infinity16");

    }

    // Bouncer to make the class readable.
    private static TextureAtlasSprite register(String sprite) {

        return map.registerSprite(new ResourceLocation(sprite));
    }

    //Assign the TextureMap to a file to make things even more readable!.
    private static TextureMap map;

    public static TextureAtlasSprite HALO;

}
