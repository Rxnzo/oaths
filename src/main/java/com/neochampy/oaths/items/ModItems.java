package com.neochampy.oaths.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.neochampy.oaths.Oaths;
import com.neochampy.oaths.ModCreativeTab;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Oaths.MODID);

    // Existing items
    public static final RegistryObject<Item> FLAMEHEART_CAPSULE = ITEMS.register("flameheart_capsule",
            () -> new FlameheartCapsule(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));
    public static final RegistryObject<Item> FLAMEHEART = ITEMS.register("flameheart",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));

    // New items
    public static final RegistryObject<Item> CONTAINER = ITEMS.register("container",
            () -> new Container(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));
    public static final RegistryObject<Item> STORMCORE = ITEMS.register("stormcore",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));
    public static final RegistryObject<Item> FROSTGEM_FRAGMENT = ITEMS.register("frostgem_fragment",
            () -> new FrostgemFragment(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));
    public static final RegistryObject<Item> FROSTGEM = ITEMS.register("frostgem",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));
    public static final RegistryObject<Item> STONE_SHARD = ITEMS.register("stone_shard",
            () -> new StoneShard(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));
    public static final RegistryObject<Item> LIGHTSTONE = ITEMS.register("lightstone",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.OATHS_TAB)));
}