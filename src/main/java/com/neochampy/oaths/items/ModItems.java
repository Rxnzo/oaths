package com.neochampy.oaths.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.neochampy.oaths.Oaths;
import com.neochampy.oaths.ModCreativeTab;

public class ModItems {

    // Registering a DeferredRegister for Items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Oaths.MODID);

    // Registering the Flameheart Capsule Item
    public static final RegistryObject<Item> FLAMEHEART_CAPSULE = ITEMS.register("flameheart_capsule",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));

    // Registering the Flameheart Item
    public static final RegistryObject<Item> FLAMEHEART = ITEMS.register("flameheart",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));
}