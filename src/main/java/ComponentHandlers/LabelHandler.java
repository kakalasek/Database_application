package ComponentHandlers;

import javax.swing.*;
import java.awt.*;

import static utils.TextUtils.getTextHeight;
import static utils.TextUtils.getTextWidth;

/**
 * Handles label creation, label centering etc.
 * Used mainly for cleaner code and to minimise redundancy
 * Does some stuff for me, so I don't have to every time
 */
public class LabelHandler {

    /**
     * Creates text label. Note that it will set the width and height of it according to the given text.
     * @param x Horizontal position
     * @param y Vertical position
     * @param text Text of the label
     * @param font Font to be applied to the text
     * @return The initialized text label
     */
    public static JLabel createText(int x, int y, String text, Font font){

        JLabel label = new JLabel();

        label.setText(text);

        label.setFont(font);

        label.setBounds(x, y, getTextWidth(label), getTextHeight(label));

        return label;
    }

    /**
     * Creates image label. Note that it will set the width and height according to the given image.
     * @param x Horizontal position
     * @param y Vertical position
     * @param image URL of the image
     * @return The initialized image label
     */
    public static JLabel createImage(int x, int y, String image){

        JLabel label = new JLabel();

        ImageIcon icon = new ImageIcon(image);

        label.setIcon(icon);

        label.setBounds(x - icon.getIconWidth(), y, icon.getIconWidth(), icon.getIconHeight());

        return label;
    }

    /**
     * Centers a label within a frame.
     * @param label Label to center
     * @param frame Frame in which you want to center the button
     */
    public static void centerInFrame(JLabel label, JFrame frame){
        label.setLocation((frame.getWidth()/2) - (getTextWidth(label)/2), label.getY());
    }
}
