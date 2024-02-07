package Windows;

import ComponentHandlers.FrameHandler;
import ComponentHandlers.LabelHandler;
import ComponentHandlers.PanelHandler;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    JPanel mainPanel;

    public MainMenu(){
        FrameHandler.handle(this, new Dimension(1080, 720), "MAIN MENU", WindowConstants.EXIT_ON_CLOSE);

        mainPanel = PanelHandler.create(new Rectangle(0, 0, this.getWidth(), this.getHeight()));

        this.add(mainPanel);
    }
}
