package ComponentHandlers;

import javax.swing.*;
import java.awt.*;

public class FrameHandler {

    public static void handle(JFrame frame, Dimension size, String title, int onCloseOperation){

        frame.setTitle(title);

        frame.setSize(size);

        frame.setDefaultCloseOperation(onCloseOperation);

        frame.setResizable(false);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

    }
}
