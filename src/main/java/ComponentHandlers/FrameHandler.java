package ComponentHandlers;

import Utils.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
     * @param onCloseOperation General operation to perform after closing the frame (e.g. EXIT_ON_CLOSE)
     * @param onCloseAction Special action to perform after closing the frame
     */
    public static void handle(JFrame frame, Dimension size, String title, int onCloseOperation, Function onCloseAction){

        frame.setTitle(title);

        frame.setSize(size);

        frame.setDefaultCloseOperation(onCloseOperation);

        if(onCloseAction != null) frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCloseAction.apply();
            }
        });

        frame.setResizable(false);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);  // This will make the frame appear in the center of the screen

    }
}
