package com.kazara.tasks.Registry;
import com.kazara.tasks.Utils.TasksLogger;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

public class Registries {
    public static Set<ResourceLocation> blocks;
    public static Set<ResourceLocation> items;
    public static void setRegistries() {
        long start = System.currentTimeMillis();
        blocks = ForgeRegistries.BLOCKS.getKeys();
        items =  ForgeRegistries.ITEMS.getKeys();
        long time = System.currentTimeMillis()-start;
        TasksLogger.log("Registries took " + time  + "ms to load");

    }
}
