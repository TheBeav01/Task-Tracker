package com.kazara.tasks.Recipes;

import com.google.gson.JsonObject;
import com.kazara.tasks.Main.TasksModInstance;
import com.kazara.tasks.Registry.Registries;
import com.kazara.tasks.Utils.TasksLogger;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TasksRecipeList {
    private static Collection<IRecipe<?>> recipeList;
    private static final Logger LOGGER = LogManager.getLogger();
    private static List<IRecipe<?>> ig;
    public static void setupRecipeList() {
        recipeList = TasksModInstance.recipeManager.getRecipes();
        TasksLogger.log("Built recipe set");
        getIngredientsFromList("terracotta");
    }

    public static List<Ingredient> getIngredientsFromList(String fromWhatItem) {
        //recipeOutput.item.registryName.path
        ig = recipeList.stream().filter(recipe -> recipe.getId().getPath().contains(fromWhatItem)).collect(Collectors.toList());
        recipeList.forEach(recipe -> LOGGER.debug(recipe.getId().getPath() + " " + recipe.getRecipeOutput().getItem().getRegistryName()));
        LOGGER.debug("Done?");
        return null;
    }
}
