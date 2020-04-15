package com.kazara.tasks.Client.gui.Dropdown;

import com.kazara.tasks.Main.TasksModInstance;
import com.kazara.tasks.Utils.RecipeUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

//Contains a rendered block image + its name
public class DropdownItem {
    private ItemRenderer renderer;
    private ItemStack itemStack;
    private List<IRecipe<?>> attachedRecipe;
    private String displayName;
    public DropdownItem build(String recipeTitle, boolean isRecipe) {
        renderer = Minecraft.getInstance().getItemRenderer();
        this.displayName = recipeTitle;
        if(isRecipe) {
            return buildRecipe();
        }
        return this;
    }

    private DropdownItem buildRecipe() {
        this.attachedRecipe = RecipeUtils.getRecipesFromItemName(displayName);
        if(!attachedRecipe.isEmpty()) {
            //TODO: Change this
            this.itemStack = attachedRecipe.get(0).getRecipeOutput();
        }
        return this;
    }

//    private DropdownItem buildItem() {
//        this.itemStack = TasksModInstance.currentTree.searchTreeForNode(displayName);
//    }
    public void render() {
        renderer.renderItemIntoGUI(itemStack,20,20);
    }

}
