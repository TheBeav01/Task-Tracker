package com.kazara.tasks.Main;

import com.kazara.tasks.Event.EventHandlers;
import com.kazara.tasks.Event.KeypressHandler;
import com.kazara.tasks.Registry.Keybinds;
import net.minecraftforge.common.MinecraftForge;

public class TasksModInstance {
    public TasksModInstance() {

    }
    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new EventHandlers());
        MinecraftForge.EVENT_BUS.register(new KeypressHandler());
    }
    public void registerKeys() {
        Keybinds.registerKeybinds();
    }
}
