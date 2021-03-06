package com.kazara.tasks.Event;

import com.kazara.tasks.Main.Tasks;
import com.kazara.tasks.Main.TasksModInstance;
import com.kazara.tasks.Recipes.TasksRecipeList;
import com.kazara.tasks.Utils.RecipeUtils;
import com.kazara.tasks.Utils.TasksLogger;
import javafx.concurrent.Task;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandlers {
    @SubscribeEvent
    public void onWorldJoin(PlayerEvent.PlayerLoggedInEvent event) {
        TasksLogger.log(event.getPlayer().getGameProfile().getName() + " logged in.");
        TasksModInstance.addRecipeManager(event.getPlayer().world.getRecipeManager());
        RecipeUtils.setupRecipeList();
        TasksModInstance inst = Tasks.getInstance();
        if(Tasks.getInstance() != null) {
            inst.buildTree();
        }
        //TODO: Load tasks
    }

    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event) {
        //TODO: Check for item
        TasksLogger.log("Item picked up.");
        System.out.println("Hi.");
    }

}
