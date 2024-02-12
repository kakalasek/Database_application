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
     * @param layout The layout for the panel
     * @return The initialized panel
     */
    public static JPanel create(LayoutManager layout){

        JPanel panel = new JPanel();

        panel.setLayout(layout);

        panel.setOpaque(true);

        return panel;

    }
}
