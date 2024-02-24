package Windows;

import Constants.Constants;
import Objects.Plant.Plant;
import Objects.Plant.PlantDaoImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

public class Delete extends JFrame {
    private static Delete instance = null;

    private PlantDaoImpl pdi = new PlantDaoImpl();

    public static Delete createWindow(){
        if (instance == null){
            instance = new Delete();
            return instance;
        }
        return instance;
    }

    private Delete(){
        this.setTitle("Vymazat");

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

        JButton submit = new JButton("Vymazat");
        submit.setFont(Constants.DEFAULT_FONT);
        lowestLeft.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pdi.delete(new Plant(genericInput.getText().trim(), speciesInput.getText().trim()));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        this.getContentPane().add(lowestLeft, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 3;

        JTextArea comment = new JTextArea("Zadejte údaje rostliny, kterou chcete vymazat");
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
