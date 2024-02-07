package Windows;

import ComponentHandlers.ButtonHandler;
import ComponentHandlers.FrameHandler;
import ComponentHandlers.LabelHandler;
import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {



    public MainMenu(){

        FrameHandler.handle(this, new Dimension(1080, 720), "MAIN MENU", WindowConstants.EXIT_ON_CLOSE);

        final int BOTTOM_PADDING = 100;
        final int ITEM_GAP = 25;
        final int ITEM_WIDTH = 300;

        final int FIFTH_ITEM    = this.getHeight()  - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP + BOTTOM_PADDING);
        final int FOURTH_ITEM   = FIFTH_ITEM        - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP);
        final int THIRD_ITEM    = FOURTH_ITEM       - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP);
        final int SECOND_ITEM   = THIRD_ITEM        - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP);
        final int FIRST_ITEM    = SECOND_ITEM       - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP);

        JLabel title = LabelHandler.createText(0,10, "Poisonous Plants", Constants.BIG_FONT_BOLD);
        LabelHandler.centerInFrame(title, this);
        this.add(title);

        JLabel icon = LabelHandler.createImage(this.getWidth(), 0, "src/main/resources/images/poisonous_plant.png");
        this.add(icon);

        JButton search = ButtonHandler.create(new Rectangle(0, FIRST_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "SEARCH", Constants.DEFAULT_FONT_BOLD);
        ButtonHandler.centerInFrame(search, this);
        this.add(search);

        JButton add = ButtonHandler.create(new Rectangle(0, SECOND_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "ADD", Constants.DEFAULT_FONT_BOLD);
        ButtonHandler.centerInFrame(add, this);
        this.add(add);

        JButton update = ButtonHandler.create(new Rectangle(0, THIRD_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "UPDATE", Constants.DEFAULT_FONT_BOLD);
        ButtonHandler.centerInFrame(update, this);
        this.add(update);

        JButton remove = ButtonHandler.create(new Rectangle(0, FOURTH_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "REMOVE", Constants.DEFAULT_FONT_BOLD);
        ButtonHandler.centerInFrame(remove, this);
        this.add(remove);

        JButton quit = ButtonHandler.create(new Rectangle(0, FIFTH_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "QUIT", Constants.DEFAULT_FONT_BOLD);
        ButtonHandler.centerInFrame(quit, this);
        this.add(quit);

        this.setVisible(true);
    }
}
