package ComponentHandlers;

import javax.swing.*;
import java.awt.*;

public class PanelHandler {

    public static JPanel create(Rectangle bounds){

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.setBounds(bounds);

        return panel;

    }
}
