package com.keletu.lmy_mod;

import com.keletu.lmy_mod.proxy.CommonProxy;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LMYMod.MOD_ID)
public class Events {

    @SubscribeEvent
    public static void SwordTickEvent(LivingDeathEvent event)
    {
        if(event.getEntity() == null || event.getSource().getTrueSource() == null || !(event.getSource().getTrueSource() instanceof EntityPlayer))
            return;

        EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
        ItemStack stack = player.getHeldItemMainhand();

        if(stack.getItem() != CommonProxy.SwordOfImmolation)
            return;

        player.attackEntityFrom(new ImmolationDamage(), (event.getEntity() instanceof EntityCreeper || event.getEntity() instanceof EntityEnderman) ? 8 : 4);

        if(event.getEntity() instanceof EntityCreeper)
            if(event.getEntity().world.rand.nextInt(10) < 6)
                event.getEntity().dropItem(CommonProxy.CreeperHeart, 1);

        if(event.getEntity() instanceof EntityEnderman){
            if(event.getEntity().world.rand.nextInt(10) < 6)
                event.getEntity().dropItem(CommonProxy.EnderHeart, 1);
            if(event.getEntity().world.rand.nextInt(10) < 4)
                event.getEntity().dropItem(CommonProxy.EnergeticEnderEye, 1);
        }
    }

    public static class ImmolationDamage extends DamageSource
    {

        public ImmolationDamage() {
            super("immolate");
        }

    }
}
