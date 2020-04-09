package com.kazara.tasks.Client.gui;

import net.minecraft.client.gui.widget.button.Button;

public class TaskButton extends Button {

    public TaskButton(int x_pos, int y_pos, int width, int height, String text, IPressable onPress) {
        super(x_pos, y_pos, width, height, text, onPress);
    }
}
