package ComponentHandlers;

import javax.swing.*;
import java.awt.*;

/**
 * Handles the initialization of frames, so I don't have to
 * Helps reduce code redundancy
 */
public class FrameHandler {

    /**
     * Initializes the frame. Does basically everything except make it visible.
     * @param frame Frame to initialize
     * @param size Size of the frame
     * @param title Title of the frame
     * @param onCloseOperation What to perform after closing the frame
     */
    public static void handle(JFrame frame, Dimension size, String title, int onCloseOperation){

        frame.setTitle(title);

        frame.setSize(size);

        frame.setDefaultCloseOperation(onCloseOperation);

        frame.setResizable(false);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);  // This will make the frame appear in the center of the screen

    }
}
