package com.neochampy.oaths;

import com.mojang.logging.LogUtils;
import com.neochampy.oaths.items.ModItems;
import com.neochampy.oaths.items.FlameheartCapsule;
import com.neochampy.oaths.items.Container;
import com.neochampy.oaths.items.FrostgemFragment;
import com.neochampy.oaths.items.StoneShard;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register the items to the mod event bus
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register event handlers for item transformations
        MinecraftForge.EVENT_BUS.register(FlameheartCapsule.class);
        MinecraftForge.EVENT_BUS.register(Container.class);
        MinecraftForge.EVENT_BUS.register(FrostgemFragment.class);
        MinecraftForge.EVENT_BUS.register(StoneShard.class);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Pre-initialization code
        LOGGER.info("Setup method registered.");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // Client-side setup code
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // Send IMC to other mods
        InterModComms.sendTo("oaths", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
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
}