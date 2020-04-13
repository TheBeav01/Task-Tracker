package com.kazara.tasks.Recipes;

import com.kazara.tasks.Main.TasksModInstance;
import com.kazara.tasks.Utils.TasksLogger;
import net.minecraft.item.crafting.*;
import net.minecraft.util.NonNullList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TasksRecipeList {
    private static Collection<IRecipe<?>> recipeList;
    private static final Logger LOGGER = LogManager.getLogger();
    private static List<NonNullList> ig;
    private static List<IRecipe<?>> filteredList;
    public static void setupRecipeList() {
        recipeList = TasksModInstance.recipeManager.getRecipes();
        ig = NonNullList.create();
        TasksLogger.log("Built recipe set");
//        getIngredientsFromItemName("terracotta");
    }

    public static List<Ingredient> getIngredientsFromItemName(String fromWhatItem) {
        //recipeOutput.item.registryName.path
        filteredList = getRecipeFromItemName(fromWhatItem);
        for(IRecipe rec : filteredList) {
            ig.add(rec.getIngredients());
        }

//        filteredList.forEach(recipe -> LOGGER.debug(recipe.getId().getPath() + " " + recipe.getRecipeOutput().getItem().getRegistryName()));
        LOGGER.debug("Done?");
        return null;
    }

    /**
     * Filters the recipe list, outputting a list of matching items
     * @param fromWhatItem The item's registry name to soft match
     * @return A collection of matching items
     */
    private static List<IRecipe<?>> getRecipeFromItemName(String fromWhatItem) {
        List<IRecipe<?>> ret = recipeList.stream().filter(recipe -> recipe.getId()
        .getPath().contains(fromWhatItem)).collect(Collectors.toList());
        return ret;
    }
}
