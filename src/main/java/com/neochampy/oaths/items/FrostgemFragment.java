package com.neochampy.oaths.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "oaths")
public class FrostgemFragment extends Item {

    public FrostgemFragment(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (event.getSource() == DamageSource.FREEZE) {
                for (ItemStack itemStack : player.getInventory().items) {
                    if (itemStack.getItem() == ModItems.FROSTGEM_FRAGMENT.get()) {
                        itemStack.shrink(1); // Remove one frostgem fragment
                        player.addItem(new ItemStack(ModItems.FROSTGEM.get())); // Add Frostgem
                        break;
                    }
                }
            }
        }
    }
}