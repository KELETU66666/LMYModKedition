package com.keletu.lmy_mod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.ItemTCEssentiaContainer;

import java.util.Random;

public class ItemIngotAThaumium extends ItemTCEssentiaContainer {
    Random rand;

    public ItemIngotAThaumium() {
        super("ingot_aspectful_thaumium", 10);
        this.rand = new Random();
        setMaxStackSize(64);
        setHasSubtypes(true);
        setMaxDamage(0);
        setCreativeTab(ConfigItems.TABTC);
    }

    public String getItemStackDisplayName(ItemStack stack) {
        return (getAspects(stack) != null && !getAspects(stack).aspects.isEmpty()) ? String.format(super.getItemStackDisplayName(stack), getAspects(stack).getAspects()[0].getName()) : super.getItemStackDisplayName(stack);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab == ConfigItems.TABTC || tab == CreativeTabs.SEARCH) {
            for (Aspect tag : Aspect.aspects.values()) {
                ItemStack i = new ItemStack(this);
                setAspects(i, new AspectList().add(tag, base));
                items.add(i);
            }
        }
    }

    static Aspect[] displayAspects = (Aspect[])Aspect.aspects.values().toArray((Object[])new Aspect[0]);

    //public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    //  AspectList aspects = getAspects(stack);
    //  if (aspects != null && aspects.size() > 0)
    //    for (Aspect tag : aspects.getAspects()) {
    //      tooltip.add(tag.getName() + " x" + aspects.getAmount(tag));
    //    }
    //  super.addInformation(stack, worldIn, tooltip, flagIn);
    //}

    @SideOnly(Side.CLIENT)
    public int getColor(ItemStack stack, int par2) {
        if (getAspects(stack) != null)
            return getAspects(stack).getAspects()[0].getColor();
        int idx = (int)(System.currentTimeMillis() / 500L % displayAspects.length);
        return displayAspects[idx].getColor();
    }
}
