package Windows;

import ComponentHandlers.*;

import javax.swing.*;
import java.awt.*;

/**
 * Class which represents the search window. It is a singleton.
 */
public class Search extends JFrame {

    private static Search instance = null;

    /* Constructor: Handles most of the code in this class */
    private Search(){
        /* Initializing the frame */
        FrameHandler.handle(this, new Dimension(980, 620), "Prohlížet", WindowConstants.DISPOSE_ON_CLOSE, () -> instance = null);

        this.setContentPane(PanelHandler.create(new GridBagLayout()));

        /* Making the frame visible */
        this.setVisible(true);
    }

    /* Used only to crate the window */
    public static void CreateWindow(){
        if(instance != null) return;

        instance = new Search();
    }
}
