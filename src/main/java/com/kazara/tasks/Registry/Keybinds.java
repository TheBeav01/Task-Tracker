package com.kazara.tasks.Registry;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
    public static KeyBinding newTask;
    public static void registerKeybinds() {
        newTask = new KeyBinding("Create a new note",78,"Tasks.keybinds");
        ClientRegistry.registerKeyBinding(newTask);
    }
}
