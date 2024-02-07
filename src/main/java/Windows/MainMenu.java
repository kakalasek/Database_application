package Windows;

import ComponentHandlers.FrameHandler;
import ComponentHandlers.LabelHandler;
import ComponentHandlers.PanelHandler;
import utils.TextUtils;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu(){
        FrameHandler.handle(this, new Dimension(1080, 720), "MAIN MENU", WindowConstants.EXIT_ON_CLOSE);

        JLabel title = LabelHandler.createText(0,10, "Poisonous Plants", TextUtils.BIG_FONT_BOLD);
        LabelHandler.centerInFrame(title, this);
        this.add(title);

        JLabel icon = LabelHandler.createImage(this.getWidth(), 0, "src/main/resources/images/poisonous_plant.png");
        this.add(icon);

        this.setVisible(true);
    }
}
