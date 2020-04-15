//TODO: Test stuff.
package com.kazara.tasks.Utils;

import com.kazara.tasks.Main.TasksModInstance;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class RecipeUtils {
    private static Collection<IRecipe<?>> recipeList;
    private static final Logger LOGGER = LogManager.getLogger();
    private static List<NonNullList> ig;
    private static List<IRecipe<?>> filteredList;
    private static Map<IRecipe<?>,List<Ingredient>> ingList;
    public static void setupRecipeList() {
        recipeList = TasksModInstance.recipeManager.getRecipes();
        TasksLogger.log("Built recipe set");
//        getIngredientsFromItemName("terracotta");
    }

//    public static List<Ingredient> getIngredientsFromItemName(String fromWhatItem) {
//        ig = NonNullList.create();
//        ingList = new HashMap<>();
//        //recipeOutput.item.registryName.path
//        filteredList = getRecipesFromItemName(fromWhatItem);
//        for(IRecipe rec : filteredList) {
//            ig.add(rec.getIngredients());
//        }
//
////        filteredList.forEach(recipe -> LOGGER.debug(recipe.getId().getPath() + " " + recipe.getRecipeOutput().getItem().getRegistryName()));
//        LOGGER.debug("Done?");
//        return null;
//    }

    /**
     * Filters the recipe list, outputting a list of matching items
     * @param fromWhatItem The item's registry name to soft match
     * @return A collection of matching items
     */
    public static List<IRecipe<?>> getRecipesFromItemName(String fromWhatItem) {

        ingList = new HashMap<>();
        List<IRecipe<?>> ret = recipeList.stream().filter(recipe -> recipe.getId()
                .getPath().contains(fromWhatItem)).collect(Collectors.toList());
        for (IRecipe<?> iRecipe : ret) {
            ingList.put(iRecipe,iRecipe.getIngredients());
        }
//        List<IRecipe<?>> test = recipeList.stream().filter(recipe -> Objects.requireNonNull(recipe.getRecipeOutput().getItem().
//                getRegistryName()).getPath().contains(fromWhatItem)).collect(Collectors.toList());
        System.out.println("Uh hi.");
        return ret;
    }
}
