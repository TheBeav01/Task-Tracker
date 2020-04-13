package com.kazara.tasks.Main;

import com.kazara.tasks.Client.gui.ModState;
import com.kazara.tasks.Event.EventHandlers;
import com.kazara.tasks.Event.KeypressHandler;
import com.kazara.tasks.Recipes.TasksRecipeList;
import com.kazara.tasks.Registry.Keybinds;
import com.kazara.tasks.Registry.Registries;
import com.kazara.tasks.Utils.SearchTree.SearchTree;
import com.kazara.tasks.Utils.TasksLogger;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraftforge.common.MinecraftForge;

public class TasksModInstance {
    public static Minecraft minecraft;
    public static SearchTree currentTree;
    public static RecipeManager recipeManager;
    public TasksRecipeList recipeList;
    public TasksModInstance() {
        minecraft = Minecraft.getInstance();
        currentTree = new SearchTree();
    }

    public static void addRecipeManager(RecipeManager rm) {
        if(rm == null) {
            System.out.println("Uhhhhhhhhhh the manager is null.");
        }
        if(recipeManager == null) {
            recipeManager = rm;
        }
    }

    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new EventHandlers());
        MinecraftForge.EVENT_BUS.register(new KeypressHandler());
    }
    public void registerKeys() {
        Keybinds.registerKeybinds();
    }

    public void buildTree() {
        TasksLogger.log("Building tree");
        long start = System.currentTimeMillis();
        currentTree.buildTree(Registries.blocks, Registries.items);
        long time = System.currentTimeMillis() - start;
        TasksLogger.log("Finished building tree. It took " + time  +"ms to build with " + currentTree.getNumEntries() +
                " entries");
        TasksLogger.log("Performing test lookup");
        start = System.currentTimeMillis();
        currentTree.printKeyset("stripped");
        time = System.currentTimeMillis() - start;
        TasksLogger.log("Lookup took " + time + "ms ");
    }
}
