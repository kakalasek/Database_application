package utils;

import javax.swing.*;
import java.awt.*;

public class TextUtils {

    public static final Font DEFAULT_FONT = new Font("Serif", Font.PLAIN, 14);
    public static final Font BIG_FONT = new Font("Serif", Font.PLAIN, 24);
    public static final Font DEFAULT_FONT_BOLD = new Font("Serif", Font.BOLD, 14);
    public static final Font BIG_FONT_BOLD = new Font("Serif", Font.BOLD, 24);

    public static int getTextHeight(JLabel label){
        return label.getFontMetrics(label.getFont()).getHeight();
    }

    public static int getTextWidth(JLabel label){
        return label.getFontMetrics(label.getFont()).stringWidth(label.getText());
    }
}
