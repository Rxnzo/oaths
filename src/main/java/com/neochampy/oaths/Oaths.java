package com.neochampy.oaths;

import com.mojang.logging.LogUtils;
import com.neochampy.oaths.items.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

@Mod(Oaths.MODID)
public class Oaths {
    public static final String MODID = "oaths";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Oaths() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for intermod communication
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for received intermod communications
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register the items (and other stuff) to the mod event bus
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Pre-initialization code
        LOGGER.info("Setup method registered.");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // Send IMC to other mods
        InterModComms.sendTo("oaths", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world"; });
    }

    private void processIMC(final InterModProcessEvent event) {
        // Receive and process IMC from other mods
        LOGGER.info("Received IMC: {}", event.getIMCStream()
                .map(m -> m.messageSupplier().get())
                .collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("Server is starting!");
    }

    @Mod.EventBusSubscriber(modid = Oaths.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            // Register new blocks here if necessary
            LOGGER.info("Registering blocks");
        }
    }
}