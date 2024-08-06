package com.neochampy.oaths.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "oaths")
public class Container extends Item {

    public Container(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            DamageSource damageSource = player.getLastDamageSource();
            if (damageSource != null && damageSource == DamageSource.LIGHTNING_BOLT) {
                for (ItemStack itemStack : player.getInventory().items) {
                    if (itemStack.getItem() == ModItems.CONTAINER.get()) {
                        itemStack.shrink(1); // Remove one container
                        player.addItem(new ItemStack(ModItems.STORMCORE.get())); // Add Stormcore
                        break;
                    }
                }
            }
        }
    }
}
