package Windows;

import ComponentHandlers.*;
import Constants.Constants;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
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

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        JPanel upper = new JPanel();
        //upper.setPreferredSize(new Dimension(0, 50));
        upper.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 3));

        JLabel genericLabel = new JLabel("Rodové jméno:");
        genericLabel.setFont(Constants.DEFAULT_FONT);
        upper.add(genericLabel);

        JTextField genericInput = new JTextField();
        genericInput.setPreferredSize(new Dimension(150, 25));
        upper.add(genericInput);

        JLabel speciesLabel = new JLabel("Druhové jméno:");
        speciesLabel.setFont(Constants.DEFAULT_FONT);
        upper.add(speciesLabel);

        JTextField speciesInput = new JTextField();
        speciesInput.setPreferredSize(new Dimension(150, 25));
        upper.add(speciesInput);

        JButton search = new JButton("HLEDAT");
        search.setFont(Constants.DEFAULT_FONT_BOLD);
        upper.add(search);

        upper.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.black), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        this.getContentPane().add(upper, gbc);

        gbc.gridx = 0;
        gbc.gridwidth = 5;
        gbc.gridy = 1;

        JPanel main= new JPanel();
        main.setPreferredSize(new Dimension(880,520));

       this.getContentPane().add(main, gbc);

        /* Making the frame visible */
        this.pack();
        this.setVisible(true);
    }

    /* Used only to crate the window */
    public static void CreateWindow(){
        if(instance != null) return;

        instance = new Search();
    }
}
