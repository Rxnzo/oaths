package com.neochampy.oaths;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import com.neochampy.oaths.items.ModItems;

public class ModCreativeTab extends CreativeModeTab {

    public static final CreativeModeTab OATHS_TAB = new ModCreativeTab(CreativeModeTab.TABS.length, "oathstab");

    public ModCreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        // Set the icon for the tab here
        return new ItemStack(ModItems.FLAMEHEART.get());
    }
}