package ComponentHandlers;

import javax.swing.*;
import java.awt.*;

/**
 * Handles text creation, text centering etc.
 * Used mainly for cleaner code and to minimise redundancy
 * Does some stuff for me, so I don't have to every time
 */
public class TextHandler {


    /**
     * Creates and initializes a text area.
     * Note that this method subtracts the width of the area from the x coordinate. It just does it, deal with it.
     * Also note that this method does not guarantee the whole text will fit into the text area
     * @param bounds x and y position, width and height of the area (in this exact order)
     * @param text Text of the area
     * @param font Font of the text
     * @return The initialized text area
     */
    public static JTextArea create(Rectangle bounds, String text, Font font){
        JTextArea textArea = new JTextArea();

        textArea.setText(text);

        textArea.setSize(bounds.width, bounds.height);

        textArea.setLocation(bounds.x - textArea.getWidth(), bounds.y);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.setFont(font);

        textArea.setEditable(false);

        return textArea;
    }
}
