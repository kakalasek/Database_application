package Windows.Templates;

import ComponentHandlers.*;
import Constants.Constants;
import utils.Function;

import javax.swing.*;
import java.awt.*;

/**
 * A template class. Few windows look exactly the same, only with some text changed and different button actions.
 * Note that this class is a singleton, so only one window derived from this class can exist at a time
 */
public class AddDeleteUpdate extends JFrame {
    private static AddDeleteUpdate instance = null;


    /* Constructor: Handles most of the code in this class.
                    The description of the attributes can be found in the comment of the method to create a window of this class
    */
    private AddDeleteUpdate(String title, String description, String buttonText, Function onSubmit){

        FrameHandler.handle(this, new Dimension(540, 360),title, WindowConstants.DISPOSE_ON_CLOSE, () -> instance = null);

        JLabel genericLabel = LabelHandler.createText(10, 10, "Rodové jméno:", Constants.DEFAULT_FONT);
        this.add(genericLabel);

        JTextField genericInput = InputHandler.create(new Rectangle(10, 35, 200, 25));
        this.add(genericInput);

        JLabel speciesLabel = LabelHandler.createText(10, 100, "Druhové jméno:", Constants.DEFAULT_FONT);
        this.add(speciesLabel);

        JTextField speciesInput = InputHandler.create(new Rectangle(10, 125, 200, 25));
        this.add(speciesInput);

        JTextArea text = TextHandler.create(new Rectangle(this.getWidth() - 30, 10,200, 300), description, Constants.DEFAULT_FONT);
        this.add(text);

        JButton submit = ButtonHandler.create(new Rectangle(25, 210, 150, Constants.BUTTON_DEFAULT_HEIGHT), buttonText, Constants.DEFAULT_FONT, onSubmit);
        this.add(submit);

        this.setVisible(true);
    }

    /**
     * Creates a window of this template.
     * Just a few values need to be set within.
     * I will not comment the constructor, because it is essentially the same.
     * @param title Title of the window
     * @param description Description in the window.
     * @param buttonText Text displayed on the submit button
     * @param onSubmit Action to perform after clicking the submit button
     */
    public static void createWindow(String title, String description, String buttonText, Function onSubmit){
        if(instance != null) return;

        instance = new AddDeleteUpdate(title, description, buttonText, onSubmit);
    }
}
