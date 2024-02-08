package Windows.Templates;

import ComponentHandlers.FrameHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;

public class AddDeleteUpdate extends JFrame {
    private static AddDeleteUpdate instance = null;

    private AddDeleteUpdate(){

        FrameHandler.handle(this, new Dimension(540, 360), "ADD", WindowConstants.DISPOSE_ON_CLOSE, () -> instance = null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               instance = null;
            }
        });

        this.setVisible(true);
    }

    public static AddDeleteUpdate createWindow(){
        if(instance != null) return instance;

        instance = new AddDeleteUpdate();
        return instance;
    }
}
