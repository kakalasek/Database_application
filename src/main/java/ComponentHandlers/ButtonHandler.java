package ComponentHandlers;

import utils.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles button creation, button centering etc.
 * Used mainly for cleaner code and to minimise redundancy
 * Does some stuff for me, so I don't have to every time
 */
public class ButtonHandler {

    /**
     * Creates a button.
     * Note that this method does not take into account the font size of the button,
     * so there is no guarantee that all the text will fit.
     * Also note that this method sets the y-coordinate
     * exactly to the top left corner, because it counts with the button height.
     * @param bounds x and y coordinates, width and height of the button (in this exact order)
     * @param text Text which will be displayed on the button
     * @param font Font to be applied to the button text
     * @param func Function to be executed when the button is pressed
     * @return The initialized button
     */
    public static JButton create(Rectangle bounds, String text, Font font, Function func){

        JButton button = new JButton();

        button.setText(text);

        button.setFont(font);

        button.setSize(bounds.width, bounds.height);

        button.setLocation(bounds.x, bounds.y - button.getHeight());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                func.apply();
            }
        });

        return button;
    }

    /**
     * Centers a button within a frame.
     * @param button Button to center
     * @param frame Frame in which you want to center the button
     */
    public static void centerInFrame(JButton button, JFrame frame){
        button.setLocation((frame.getWidth()/2) - (button.getWidth()/2), button.getY());
    }
}
