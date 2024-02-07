package ComponentHandlers;

import javax.swing.*;
import java.awt.*;

/**
 * Handles panel creation, panel centering etc.
 * Used mainly for cleaner code and to minimise redundancy
 * Does some stuff for me, so I don't have to every time
 */
public class PanelHandler {

    /**
     * Creates a panel.
     * @param bounds x and y coordinates, width and height of the panel (in this exact order)
     * @return The initialized panel
     */
    public static JPanel create(Rectangle bounds){

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.setBounds(bounds);

        return panel;

    }
}
