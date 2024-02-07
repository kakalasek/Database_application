package ComponentHandlers;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class LabelHandler {

    public static JLabel create(Rectangle bounds, String text){

        JLabel label = new JLabel();

        label.setText(text);

        label.setBounds(bounds);

        return label;
    }
}
