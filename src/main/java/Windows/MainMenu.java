package Windows;

/* IMPORTS */
import ComponentHandlers.ButtonHandler;
import ComponentHandlers.FrameHandler;
import ComponentHandlers.LabelHandler;
import Constants.Constants;
import Objects.Plant.PlantDaoImpl;
import Windows.Templates.AddDeleteUpdate;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the main menu of this application
 */
public class MainMenu extends JFrame {

    /* Constructor: Handles most of the code in this class */
    public MainMenu(){

        /* Initializes the frame, sets the default values etc. */
        FrameHandler.handle(this, new Dimension(980, 620), "Hlavní menu", WindowConstants.EXIT_ON_CLOSE, null);

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
        JLabel title = LabelHandler.createText(0,10, "JEDOVATÉ ROSTLINY", Constants.BIG_FONT);
        LabelHandler.centerInFrame(title, this);
        this.add(title);

        /* Icon */
        JLabel icon = LabelHandler.createImage(this.getWidth(), 0, "src/main/resources/images/poisonous_plant.png");
        this.add(icon);

        /* All the items (buttons) */
        JButton search = ButtonHandler.create(new Rectangle(0, FIRST_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "PROHLÍŽET", Constants.DEFAULT_FONT_BOLD, Search::CreateWindow);
        ButtonHandler.centerInFrame(search, this);
        this.add(search);

        JButton add = ButtonHandler.create(new Rectangle(0, SECOND_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "PŘIDAT", Constants.DEFAULT_FONT_BOLD, () -> AddDeleteUpdate.createWindow("Přidat", "Zadejte rodové a druhové jméno rostliny, kterou chcete přidat. Zbytek údajů můžete přidat v záložce 'Upravit'.", "PŘIDAT", null));
        ButtonHandler.centerInFrame(add, this);
        this.add(add);

        JButton update = ButtonHandler.create(new Rectangle(0, THIRD_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "UPRAVIT", Constants.DEFAULT_FONT_BOLD, () -> AddDeleteUpdate.createWindow("Upravit","Zadejte rodové a druhové jméno rostliny, kterou chcete upravit.", "UPRAVIT",null ));
        ButtonHandler.centerInFrame(update, this);
        this.add(update);

        JButton remove = ButtonHandler.create(new Rectangle(0, FOURTH_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "SMAZAT", Constants.DEFAULT_FONT_BOLD,() -> AddDeleteUpdate.createWindow("Smazat", "Zadejte rodové a druhové jméno rostliny, kterou chcete odstranit.", "SMAZAT", null));
        ButtonHandler.centerInFrame(remove, this);
        this.add(remove);

        JButton quit = ButtonHandler.create(new Rectangle(0, FIFTH_ITEM, ITEM_WIDTH, Constants.BUTTON_DEFAULT_HEIGHT), "ODEJÍT", Constants.DEFAULT_FONT_BOLD, () -> System.exit(0));
        ButtonHandler.centerInFrame(quit, this);
        this.add(quit);

        /* Setting the frame to be visible */
        this.setVisible(true);
    }
}
