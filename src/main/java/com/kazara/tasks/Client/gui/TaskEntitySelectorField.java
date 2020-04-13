package com.kazara.tasks.Client.gui;

import javafx.scene.input.KeyCode;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;

public class TaskEntitySelectorField extends TextFieldWidget {
    private String text;
    private NewTaskScreen attachTo;
    public TaskEntitySelectorField(NewTaskScreen attachTo, FontRenderer fontIn, int xIn, int yIn, int widthIn, int heightIn, String msg) {
        super(fontIn, xIn, yIn, widthIn, heightIn, msg);
        this.text = msg;
        this.attachTo = attachTo;
    }

    @Override
    public boolean keyPressed(int p_223281_1_, int p_223281_2_, int p_223281_3_) {

        return super.keyPressed(p_223281_1_, p_223281_2_, p_223281_3_);
    }

    @Override
    public void tick() {
        super.tick();
        this.text = getText();
    }

    @Override
    public boolean charTyped(char p_charTyped_1_, int p_charTyped_2_) {
        return super.charTyped(p_charTyped_1_,p_charTyped_2_);
    }
//    private void passToMultiplier() {
//        this.setFocused2(false);
//        attachTo.focusMultiplier();
//    }
}
