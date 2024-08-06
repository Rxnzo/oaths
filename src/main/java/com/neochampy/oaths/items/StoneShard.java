package com.neochampy.oaths.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "oaths")
public class StoneShard extends Item {

    public StoneShard(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        Player player = event.player;
        Level world = player.level;
        ItemStack heldItem = player.getMainHandItem();

        if (heldItem.getItem() == ModItems.STONE_SHARD.get()) {
            // Check if the player is at high elevation during sunrise
            if (player.getY() > 200 && world.getDayTime() % 24000L > 23000L && world.getDayTime() % 24000L < 24000L) {
                heldItem.shrink(1); // Remove one Stoneshard
                player.addItem(new ItemStack(ModItems.LIGHTSTONE.get())); // Add Lightstone
            }
        }
    }
}
