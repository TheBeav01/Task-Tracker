package com.kazara.tasks.Client.gui;

import com.kazara.tasks.Utils.TasksLogger;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.OptionsRowList;
import net.minecraft.util.text.StringTextComponent;

import static net.minecrell.terminalconsole.TerminalConsoleAppender.close;

//TODO: Actually render things
//TODO: Dim the background
public class NewTaskScreen extends Screen {
    private TaskButton toggleModes;
    private OptionsRowList list;
    private TextFieldWidget textFieldWidget;
    private String modeText;
    public NewTaskScreen() {
        super(new StringTextComponent("AAA"));
        modeText = "M";

    }

    @Override
    protected void init() {
        toggleModes = new TaskButton(50,50,20,20,modeText,buttons -> {
            //TODO: Refactor into dedicated function and set appropriate flags usable elsewhere
            switch(modeText) {
                case "M":
                    modeText = "G";
                    System.out.println("M -> G");
                    this.toggleModes.setMessage(modeText); //Thanks, Vanilla :3

                    break;
                case "G":
                    modeText = "K";
                    System.out.println("G -> K");
                    this.toggleModes.setMessage(modeText);

                    break;
                case "K":
                    modeText = "M";
                    System.out.println("K -> M");
                    this.toggleModes.setMessage(modeText);

                    break;

            }
        });
        //TODO: Create text entry and text field.
        super.init();
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        renderText();
        renderButtons();
        renderBackground();
        super.render(p_render_1_, p_render_2_, p_render_3_);
    }
    private void renderText() {
    }
    private void renderButtons() {
        /*TODO: Create two buttons, two text fields, and one dropdown. One button cancels the gui.
        One button creates a new task. The dropdown selects the type. The text field denotes task name. A second button toggles
        kill -> gather -> make, setting the appropriate flags
        */
        addButton(new TaskButton(width/2-160,height/2,80,20,"Create",buttons -> test()));
        addButton(new TaskButton(width/2 + 80, height/2,80,20,"Close",buttons -> close()));
        addButton(toggleModes);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    private void test() {
        TasksLogger.log("Selected button");
        GUIUtils.getItemStack("Dirt");
    }
    private void close() {
        Minecraft.getInstance().displayGuiScreen(null);
    }
}
