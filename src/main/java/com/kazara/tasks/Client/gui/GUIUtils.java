package com.kazara.tasks.Client.gui;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Map;

public class GUIUtils {
    public static void getItemStack(String blockName) {
        IForgeRegistry<Item> registry = ForgeRegistries.ITEMS;
        if(ForgeRegistries.ITEMS.containsKey(new ResourceLocation(blockName.toLowerCase()))) {
            System.out.println("Hi.");
        }
        else {
            System.out.println("Bad");
        }

    }
}
