package com.kazara.tasks.Client.gui;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class GUIUtils {
    public static void getItemStack(String blockName) {
        if(ForgeRegistries.ITEMS.containsKey(new ResourceLocation(blockName.toLowerCase()))) {
            System.out.println("Hi.");
        }
        else {
            System.out.println("Bad");
        }

    }
}
