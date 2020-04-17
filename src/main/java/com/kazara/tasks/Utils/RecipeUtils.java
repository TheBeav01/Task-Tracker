//TODO: Test stuff.
package com.kazara.tasks.Utils;

import com.kazara.tasks.Main.TasksModInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import java.util.*;
import java.util.stream.Collectors;

public class RecipeUtils {
    private static Collection<IRecipe<?>> recipeList;
    public static void setupRecipeList() {
        recipeList = TasksModInstance.recipeManager.getRecipes();
        TasksLogger.log("Built recipe set");
    }


    /**
     * Filters the recipe list, outputting a list of matching items
     * @param fromWhatItem The item's registry name to soft match
     * @return A collection of matching items
     */
    public static List<IRecipe<?>> getRecipesFromItemName(String fromWhatItem) {
        return recipeList.parallelStream().filter(recipe -> recipe.getId()
                .getPath().contains(fromWhatItem)).collect(Collectors.toList());
    }

    public static List<IRecipe<?>> getRecipesFromExactItemName(String fromWhatItem) {
        return recipeList.parallelStream().filter(recipe -> recipe.getId()
                .getPath().matches(fromWhatItem)).collect(Collectors.toList());
    }

}
