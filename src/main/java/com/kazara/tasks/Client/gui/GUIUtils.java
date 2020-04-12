package com.kazara.tasks.Client.gui;

import com.kazara.tasks.Main.Tasks;
import com.kazara.tasks.Main.TasksModInstance;
import com.kazara.tasks.Utils.TasksLogger;
import javafx.concurrent.Task;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Map;

public class GUIUtils {
    public static void getRecipe(String blockName) {
        RecipeManager rm = TasksModInstance.recipeManager;
        System.out.println("Okay now what");
//        IForgeRegistry<Item> registry = ForgeRegistries.ITEMS;
//        if(ForgeRegistries.ITEMS.containsKey(new ResourceLocation(blockName.toLowerCase()))) {
//            System.out.println("Hi.");
//        }
//        else {
//            System.out.println("Bad");
//        }

    }
}
