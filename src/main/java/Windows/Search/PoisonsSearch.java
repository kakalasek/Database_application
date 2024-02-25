package Windows.Search;

import Constants.Constants;
import Objects.Plant.PlantDaoImpl;
import Objects.Poison.Poison;
import Objects.Poison.PoisonDaoImpl;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class PoisonsSearch extends JPanel {
    private final PlantDaoImpl pldi = new PlantDaoImpl();
    private final PoisonDaoImpl podi = new PoisonDaoImpl();
    private final JPanel upper;

    public PoisonsSearch(){

        this.setLayout(new GridBagLayout());
        this.setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        upper = new JPanel();
        upper.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 3));

        JLabel nameLabel = new JLabel("Název:");
        nameLabel.setFont(Constants.DEFAULT_FONT);
        upper.add(nameLabel);

        JTextField nameInput= new JTextField();
        nameInput.setPreferredSize(new Dimension(150, 25));
        upper.add(nameInput);

        JButton search = new JButton("HLEDAT");
        search.setFont(Constants.DEFAULT_FONT_BOLD);
        upper.add(search);

        upper.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.black), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        this.add(upper, gbc);

        gbc.gridx = 0;
        gbc.gridwidth = 5;
        gbc.gridy = 1;

        JTabbedPane lower = new JTabbedPane();

        JPanel poisonData = new JPanel();
        JTextArea poisonDataText = new JTextArea();
        poisonData.add(poisonDataText);

        JPanel effectsData = new JPanel();
        JTextArea effectsDataText = new JTextArea();
        effectsData.add(effectsDataText);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Poison poison = podi.getByName(nameInput.getText().trim().toLowerCase());
                    poisonDataText.setText("");
                    effectsDataText.setText("");
                    poisonDataText.setText(
                            "Název: " + poison.getName() + "\n" +
                                    "Skupina: " + poison.getGroup() + "\n" +
                                    "LD50: " + poison.getLd50()
                    );
                    for(String effect : poison.getEffects()) effectsDataText.setText(effectsDataText.getText() + effect + "\n");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        lower.add("Jed", poisonData);
        lower.add("Účinky", effectsData);

        lower.setPreferredSize(new Dimension(880,520));

        this.add(lower, gbc);
    }

    public JPanel getUpper(){
        return upper;
    }

}

