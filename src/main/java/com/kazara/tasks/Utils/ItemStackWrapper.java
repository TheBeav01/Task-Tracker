package com.kazara.tasks.Utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemStackWrapper {
    private ItemStack item;
    private boolean hasDictionary;
    public ItemStackWrapper(ItemStack item) {
        this.item = item;
        this.hasDictionary = false;
    }

    public void setDict() {
        this.hasDictionary = true;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ItemStackWrapper) {
            String thisName = this.getName();
            String thatName = ((ItemStackWrapper) obj).getName();
            return thisName.matches(thatName);
        }
        return false;
    }

    public int getCount() {
        return item.getCount();
    }

    public void setCount(int i) {
        item.setCount(i);
    }

    public ItemStack getItem() {
        return item;
    }

    public String getName() {
        return item.getDisplayName().getString();
    }

    public String getRegistryName() {
        ResourceLocation rl = item.getItem().getRegistryName();
        if(rl != null) {
            return item.getItem().getRegistryName().getPath();
        }
        TasksLogger.log("This isn't great, mate");
        return "";
    }
}
