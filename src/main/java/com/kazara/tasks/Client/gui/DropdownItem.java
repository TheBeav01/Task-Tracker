package com.kazara.tasks.Client.gui;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//Contains a rendered block image + its name
public class DropdownItem {
    ItemRenderer renderer;
    ItemStack itemStack;

    DropdownItem(ItemStack stack) {
        renderer = Minecraft.getInstance().getItemRenderer();
        renderer.renderItemIntoGUI(stack,10,10);

    }
}
