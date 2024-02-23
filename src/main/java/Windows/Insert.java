package Windows;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Insert extends JFrame {

    private static Insert instance = null;

    public static Insert createWindow(){
        if (instance == null){
            instance = new Insert();
            return instance;
        }
        return instance;
    }

    private Insert(){
       this.setTitle("Přidat");

       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

       this.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosed(WindowEvent e) {
               instance = null;
           }
       });

       JPanel upperLeft = new JPanel();

       JPanel lowerLeft = new JPanel();

       JPanel lowestLeft = new JPanel();

       JPanel right = new JPanel();

       JPanel mainPanel = new JPanel();

       mainPanel.setLayout(new GridBagLayout());

       mainPanel.setOpaque(true);

       this.setContentPane(mainPanel);

       GridBagConstraints gbc = new GridBagConstraints();

       gbc.gridx = 0;
       gbc.gridy = 0;
       gbc.weightx = 1.0;
       gbc.weighty = 1.0;
       gbc.fill = GridBagConstraints.BOTH;

       upperLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 3));

       JLabel genericLabel = new JLabel("Rodové jméno:");
       genericLabel.setFont(Constants.DEFAULT_FONT);
       upperLeft.add(genericLabel);

       JTextField genericInput = new JTextField();
       genericInput.setPreferredSize(new Dimension(150, 25));
       upperLeft.add(genericInput);

       this.getContentPane().add(upperLeft, gbc);

       gbc.gridy = 1;

       lowerLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 3));

       JLabel speciesLabel = new JLabel("Druhové jméno:");
       speciesLabel.setFont(Constants.DEFAULT_FONT);
       lowerLeft.add(speciesLabel);

       JTextField speciesInput = new JTextField();
       speciesInput.setPreferredSize(new Dimension(150, 25));
       lowerLeft.add(speciesInput);

       this.getContentPane().add(lowerLeft, gbc);

       gbc.gridy = 2;

       lowestLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 3));

       JButton submit = new JButton("Přidat");
       submit.setFont(Constants.DEFAULT_FONT);
       lowestLeft.add(submit);

       this.getContentPane().add(lowestLeft, gbc);

       gbc.gridx = 1;
       gbc.gridy = 0;
       gbc.gridheight = 3;

       JTextArea comment = new JTextArea("Zbytek údajů můžete přidat v sekci 'Upravit'");
       comment.setLineWrap(true);
       comment.setWrapStyleWord(true);
       comment.setFont(Constants.DEFAULT_FONT);
       comment.setEditable(false);
       comment.setPreferredSize(new Dimension(200, 350));

       right.add(comment);

       this.getContentPane().add(right, gbc);

       this.pack();

       this.setLocationRelativeTo(null);

       this.setVisible(true);
    }
}
