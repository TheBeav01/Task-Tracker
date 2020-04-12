package com.kazara.tasks.Recipes;

import com.google.gson.JsonObject;
import com.kazara.tasks.Main.TasksModInstance;
import com.kazara.tasks.Registry.Registries;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collection;
import java.util.List;

public class TasksRecipeList {

   public static void get() {
       System.out.println("AAAAAAAAAAAAa");
    }
//    public static void getRecipeFromResult(String domain) {
//        obj = new JsonObject();
//        System.out.println("Hi.");
//        RecipeManager rm;
//        rm = TasksModInstance.minecraft.world.getRecipeManager();
//    }
    public static void setupRecipeList() {
       World mcWorld = TasksModInstance.minecraft.world;
       if(mcWorld != null) {
           RecipeManager rm = mcWorld.getRecipeManager();
       }

    }
}
