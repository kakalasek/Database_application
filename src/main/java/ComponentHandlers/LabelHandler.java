package ComponentHandlers;

import javax.swing.*;
import java.awt.*;

import static utils.TextUtils.getTextHeight;
import static utils.TextUtils.getTextWidth;

public class LabelHandler {

    public static JLabel createText(int x, int y, String text, Font font){

        JLabel label = new JLabel();

        label.setText(text);

        label.setFont(font);

        label.setBounds(x, y, getTextWidth(label), getTextHeight(label));

        return label;
    }

    public static JLabel createImage(int x, int y, String image){

        JLabel label = new JLabel();

        ImageIcon icon = new ImageIcon(image);

        label.setIcon(icon);

        label.setBounds(x - icon.getIconWidth(), y, icon.getIconWidth(), icon.getIconHeight());

        return label;
    }

    public static void centerInFrame(JLabel label, JFrame frame){
        label.setLocation((frame.getWidth()/2) - (getTextWidth(label)/2), label.getY());
    }
}
