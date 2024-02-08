package ComponentHandlers;

import javax.swing.*;
import java.awt.*;

/**
 * Handles input creation, input centering etc.
 * Used mainly for cleaner code and to minimise redundancy
 * Does some stuff for me, so I don't have to every time
 */
public class InputHandler {

    /**
     * Creates and initializes a text input field
     * @param bounds x and y position, width and height of the input (in this exact order)
     * @return The initialized field
     */
    public static JTextField create(Rectangle bounds){

        JTextField textField = new JTextField();

        textField.setBounds(bounds);

        return textField;
    }
}
