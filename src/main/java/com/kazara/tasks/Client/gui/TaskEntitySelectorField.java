package com.kazara.tasks.Client.gui;

import com.kazara.tasks.Client.gui.Dropdown.DropdownItem;
import com.kazara.tasks.Recipes.TasksRecipeList;
import javafx.scene.input.KeyCode;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;

public class TaskEntitySelectorField extends TextFieldWidget {
    private String text;
    private NewTaskScreen attachTo;
    boolean onceOnly = true;
    public TaskEntitySelectorField(NewTaskScreen attachTo, FontRenderer fontIn, int xIn, int yIn, int widthIn, int heightIn, String msg) {
        super(fontIn, xIn, yIn, widthIn, heightIn, msg);
        this.text = msg;
        this.attachTo = attachTo;
    }

    @Override
    public boolean keyPressed(int p_223281_1_, int p_223281_2_, int p_223281_3_) {
        DropdownItem i;
        boolean isSuccesful = super.keyPressed(p_223281_1_, p_223281_2_, p_223281_3_);
        System.out.println("T: " + p_223281_1_ + " " + isSuccesful + " Text: " + getText());
        if(p_223281_1_ == 259 && isSuccesful) {
            //Update search
            i = new DropdownItem().build(this.getText(),true);
            System.out.println("A");

        }
//
//        if(onceOnly) {
//            onceOnly = false;
//            DropdownItem i = new DropdownItem().build(this.getText().toLowerCase(),true);
//            System.out.println("uwu");
//        }
        return isSuccesful;
    }

    @Override
    public void tick() {
        super.tick();
        this.text = getText();
    }

    @Override
    public boolean charTyped(char p_charTyped_1_, int p_charTyped_2_) {
        DropdownItem i;
        boolean successful = super.charTyped(p_charTyped_1_,p_charTyped_2_);
        if(successful) {
            i = new DropdownItem().build(this.getText(),true);
            //Update search
            System.out.println("A");
        }
        return successful;
    }
//    private void passToMultiplier() {
//        this.setFocused2(false);
//        attachTo.focusMultiplier();
//    }
}
