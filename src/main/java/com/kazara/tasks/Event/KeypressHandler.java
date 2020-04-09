package com.kazara.tasks.Event;

import com.google.common.eventbus.Subscribe;
import com.kazara.tasks.Client.gui.NewTaskScreen;
import com.kazara.tasks.Registry.Keybinds;
import com.kazara.tasks.Utils.TasksLogger;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeypressHandler {
    @SubscribeEvent
    public void onKeypress(InputEvent.KeyInputEvent event) {
        //TODO: Check the keybind it's assigned to?
        if(Minecraft.getInstance().world != null) {
            if(Keybinds.newTask.isPressed()) {
                Minecraft.getInstance().displayGuiScreen(new NewTaskScreen());
            }
        }
    }
}
