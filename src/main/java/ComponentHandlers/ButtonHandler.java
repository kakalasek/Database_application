package ComponentHandlers;

import javax.swing.*;
import java.awt.*;

public class ButtonHandler {

    public static JButton create(Rectangle bounds, String text, Font font){

        JButton button = new JButton();

        button.setText(text);

        button.setFont(font);

        button.setSize(bounds.width, bounds.height);

        button.setLocation(bounds.x, bounds.y - button.getHeight());

        return button;
    }

    public static void centerInFrame(JButton button, JFrame frame){
        button.setLocation((frame.getWidth()/2) - (button.getWidth()/2), button.getY());
    }
}
