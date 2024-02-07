package Windows;

/* IMPORTS */
import ComponentHandlers.ButtonHandler;
import ComponentHandlers.FrameHandler;
import ComponentHandlers.LabelHandler;
import Constants.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the main menu of this application
 */
public class MainMenu extends JFrame {

    /* Constructor: Handles most of the code in this class */
    public MainMenu(){

        /* Initializes the frame, sets the default values etc. */
        FrameHandler.handle(this, new Dimension(1080, 720), "MAIN MENU", WindowConstants.EXIT_ON_CLOSE);

        /* ADJUSTABLE LOCAL CONSTANTS */
        final int BOTTOM_PADDING = 100;
        final int ITEM_GAP = 25;
        final int ITEM_WIDTH = 300;

        final int FIFTH_ITEM    = this.getHeight()  - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP + BOTTOM_PADDING);
        final int FOURTH_ITEM   = FIFTH_ITEM        - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP);
        final int THIRD_ITEM    = FOURTH_ITEM       - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP);
        final int SECOND_ITEM   = THIRD_ITEM        - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP);
        final int FIRST_ITEM    = SECOND_ITEM       - (Constants.BUTTON_DEFAULT_HEIGHT + ITEM_GAP);

        /* ADDING COMPONENTS */
        /* Title */
        JLabel title = LabelHandler.createText(0,10, "Poisonous Plants", Constants.BIG_FONT_BOLD);
        LabelHandler.centerInFrame(title, this);
        this.add(title);

        /* Icon */
        JLabel icon = LabelHandler.createImage(this.getWidth(), 0, "src/main/resources/images/poisonous_plant.png");
        this.add(icon);

        /* All the items (buttons) */
        JButton search = ButtonHandler.create(new Rectangle(0, FIRST_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "SEARCH", Constants.DEFAULT_FONT_BOLD, this::dispose);
        ButtonHandler.centerInFrame(search, this);
        this.add(search);

        JButton add = ButtonHandler.create(new Rectangle(0, SECOND_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "ADD", Constants.DEFAULT_FONT_BOLD, this::dispose);
        ButtonHandler.centerInFrame(add, this);
        this.add(add);

        JButton update = ButtonHandler.create(new Rectangle(0, THIRD_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "UPDATE", Constants.DEFAULT_FONT_BOLD, this::dispose);
        ButtonHandler.centerInFrame(update, this);
        this.add(update);

        JButton remove = ButtonHandler.create(new Rectangle(0, FOURTH_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "REMOVE", Constants.DEFAULT_FONT_BOLD, this::dispose);
        ButtonHandler.centerInFrame(remove, this);
        this.add(remove);

        JButton quit = ButtonHandler.create(new Rectangle(0, FIFTH_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "QUIT", Constants.DEFAULT_FONT_BOLD, this::dispose);
        ButtonHandler.centerInFrame(quit, this);
        this.add(quit);

        /* Setting the frame to be visible */
        this.setVisible(true);
    }
}
