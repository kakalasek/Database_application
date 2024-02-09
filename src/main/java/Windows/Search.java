package Windows;

import ComponentHandlers.ButtonHandler;
import ComponentHandlers.FrameHandler;
import ComponentHandlers.InputHandler;
import ComponentHandlers.LabelHandler;
import Constants.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Class which represents the search window. It is a singleton.
 */
public class Search extends JFrame {

    private static Search instance = null;

    /* Constructor: Handles most of the code in this class */
    private Search(){
        /* Initializing the frame */
        FrameHandler.handle(this, new Dimension(980, 620), "Prohlížet", WindowConstants.DISPOSE_ON_CLOSE, () -> instance = null);

        /* ADJUSTABLE LOCAL CONSTANTS */
        final int PADDING_LEFT = 10;
        final int PADDING_UP_TEXT = 10;
        final int PADDING_UP_INPUT = 12;
        final int PADDING_UP_BUTTON = 40; // Needs to be a bit more, because the method which creates buttons is subtracting the width of the button from its y-coordinate
        final int SMALLER_GAP = 10;
        final int BIGGER_GAP = 30;
        final int BUTTON_GAP = 70;

        /* INITIALING COMPONENTS AND SOME MORE LOCAL CONSTANTS */
        JLabel genericLabel = LabelHandler.createText(PADDING_LEFT, PADDING_UP_TEXT, "Rodové jméno:", Constants.DEFAULT_FONT);
        this.add(genericLabel);

        final int SECOND_FROM_LEFT = PADDING_LEFT + genericLabel.getWidth() + SMALLER_GAP;

        JTextField genericInput = InputHandler.create(new Rectangle(SECOND_FROM_LEFT, PADDING_UP_INPUT,200,25));
        this.add(genericInput);

        final int THIRD_FROM_LEFT = PADDING_LEFT + genericLabel.getWidth() + SMALLER_GAP + genericInput.getWidth() + BIGGER_GAP;

        JLabel speciesLabel = LabelHandler.createText(THIRD_FROM_LEFT, PADDING_UP_TEXT, "Druhové jméno:", Constants.DEFAULT_FONT);
        this.add(speciesLabel);

        final int FOURTH_FROM_LEFT = PADDING_LEFT + genericLabel.getWidth() + SMALLER_GAP + genericInput.getWidth() + BIGGER_GAP + speciesLabel.getWidth() + SMALLER_GAP;

        JTextField speciesInput = InputHandler.create(new Rectangle(FOURTH_FROM_LEFT, PADDING_UP_INPUT,200,25));
        this.add(speciesInput);

        final int FIFTH_FROM_LEFT = PADDING_LEFT + genericLabel.getWidth() + SMALLER_GAP + genericInput.getWidth() + BIGGER_GAP + speciesLabel.getWidth() + SMALLER_GAP + speciesInput.getWidth() + BUTTON_GAP;

        JButton search = ButtonHandler.create(new Rectangle(FIFTH_FROM_LEFT, PADDING_UP_BUTTON, 150, Constants.BUTTON_DEFAULT_HEIGHT), "Najít", Constants.DEFAULT_FONT, null);
        this.add(search);

        /* Making the frame visible */
        this.setVisible(true);
    }

    /* Used only to crate the window */
    public static void CreateWindow(){
        if(instance != null) return;

        instance = new Search();
    }
}
