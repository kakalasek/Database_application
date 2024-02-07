package utils;

import javax.swing.*;

/* Contains some useful methods related to text and labels */
public class TextUtils {

    public static int getTextHeight(JLabel label){
        return label.getFontMetrics(label.getFont()).getHeight();
    }

    public static int getTextWidth(JLabel label){
        return label.getFontMetrics(label.getFont()).stringWidth(label.getText());
    }
}
