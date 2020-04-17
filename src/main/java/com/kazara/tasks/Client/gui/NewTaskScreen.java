package com.kazara.tasks.Client.gui;

import com.google.common.collect.Lists;
import com.kazara.tasks.Main.Tasks;
import com.kazara.tasks.Main.TasksModInstance;
import com.kazara.tasks.Recipes.TasksRecipeList;
import com.kazara.tasks.Utils.RecipeUtils;
import com.kazara.tasks.Utils.TasksLogger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;

import java.util.List;

//TODO: Actually render things
public class NewTaskScreen extends Screen {
    private TaskButton toggleModes;
    private TaskEntitySelectorField textFieldWidget;
    private TextFieldWidget multSelector;
    private TextComponent title;
    private String modeText;
    private FontRenderer mcFontRenderer;
    int BX, BY, BW, BH;
    float BXf, BYf;
    private ModState GUI_STATE;
    private TasksModInstance instance;
    private final List<IGuiEventListener> children = Lists.newArrayList();
    public NewTaskScreen() {
        super(new StringTextComponent("AAA"));

        modeText = StringConstants.CREATE;
        GUI_STATE = ModState.CRAFT;
        instance = Tasks.getInstance();
    }

    @Override
    protected void init() {
        BX = width/2;
        BY = height/2;
        BXf = BX;
        BYf = BY;
        BW = 80;
        BH = 20;
        mcFontRenderer = TasksModInstance.minecraft.fontRenderer;
        setupText();
        setupButtons();

        //TODO: Create text entry and text field.
        super.init();
    }

    private void setupButtons() {
        toggleModes = new TaskButton(BX-40,BY,BW,BH,modeText,buttons -> {
            //TODO: Refactor into dedicated function and set appropriate flags usable elsewhere
            switch(GUI_STATE) {
                case CRAFT:
                    modeText = StringConstants.GATHER;
                    GUI_STATE = ModState.GATHER;
                    break;
                case GATHER:
                    modeText = StringConstants.TARGET;
                    GUI_STATE = ModState.TARGET;
                    break;
                case TARGET:
                    modeText = StringConstants.CREATE;
                    GUI_STATE = ModState.CRAFT;
                    break;
            }
            this.toggleModes.setMessage(modeText); //Thanks, Vanilla :3
        });
    }

    private void setupText() {
        children.clear();

        textFieldWidget = new TaskEntitySelectorField(this,mcFontRenderer,BX-160,BY-40,BW*2,BH,"");
        multSelector = new TextFieldWidget(mcFontRenderer,BX+20,BY-40,BW/2,BH,"");
        children.add(textFieldWidget);
        children.add(multSelector);

    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        /*TODO: Create two buttons, two text fields, and one dropdown.
        One button cancels the gui [DONE].
        One button creates a new task [DONE]. One button selects the type [DONE].
        One text field handles the multiplier [WIP]
        */

        renderBackground();
        renderText();
        renderButtons();

        textFieldWidget.render(p_render_1_, p_render_2_, p_render_3_);
//        multSelector.render(p_render_1_, p_render_2_, p_render_3_);
        TasksModInstance.minecraft.keyboardListener.enableRepeatEvents(true);

        textFieldWidget.writeText("");
        focusEntry();
        super.render(p_render_1_, p_render_2_, p_render_3_);
    }

    private void focusEntry() {
        textFieldWidget.setFocused2(true);
        setFocused(textFieldWidget);
    }

    private void renderText() {
        if(mcFontRenderer != null) {
            mcFontRenderer.drawStringWithShadow("Create a new task",BXf,BYf/4,0xFFFFFF);
        }

    }
    private void renderButtons() {

        addButton(new TaskButton(BX-160,BY,BW,BH,"Create",buttons -> test()));
        addButton(new TaskButton(BX+80, BY,BW,BH,"Close",buttons -> close()));
        addButton(toggleModes);
    }

    @Override
    public void tick() {
        textFieldWidget.tick();
        multSelector.tick();
    }
    private void test() {
        TasksLogger.log("Selected button");
        instance.getSearchTree().getComponentItemsFromTree("bookshelf");
//        RecipeUtils.getIngredientsFromItemName("planks"); //Stub. Replace with selected item.
    }
    private void close() {
        Minecraft.getInstance().displayGuiScreen(null);
    }

    @Override
    public void onClose() {
        minecraft.keyboardListener.enableRepeatEvents(false);
    }
}
