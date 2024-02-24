package Windows;

import Constants.Constants;
import Objects.Fruit.FruitDaoImpl;
import Objects.Plant.Plant;
import Objects.Plant.PlantDaoImpl;
import Objects.Poison.PoisonDaoImpl;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class PlantsSearch extends JPanel {

    private final PlantDaoImpl pldi = new PlantDaoImpl();
    private final PoisonDaoImpl podi = new PoisonDaoImpl();
    private final FruitDaoImpl frdi = new FruitDaoImpl();

    private final JPanel upper;

    public PlantsSearch(){

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

        this.add(upper, gbc);

        gbc.gridx = 0;
        gbc.gridwidth = 5;
        gbc.gridy = 1;

        JTabbedPane lower = new JTabbedPane();

        JPanel plantData = new JPanel();
        JTextArea plantDataText = new JTextArea();
        plantData.add(plantDataText);

        JPanel fruitData = new JPanel();
        JTextArea fruitDataText = new JTextArea();
        fruitData.add(fruitDataText);

        JPanel poisonsData = new JPanel();
        JTextArea poisonsDataText = new JTextArea();
        poisonsData.add(poisonsDataText);

        JPanel environmentsData = new JPanel();
        JTextArea environmentsDataText = new JTextArea();
        environmentsData.add(environmentsDataText);

        JPanel statesData = new JPanel();
        JTextArea statesDataText = new JTextArea();
        statesData.add(statesDataText);

        JPanel poisonousPartsData = new JPanel();
        JTextArea poisonousPartsDataText = new JTextArea();
        poisonsData.add(poisonousPartsDataText);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Plant plant = pldi.getByName(speciesInput.getText().trim(), genericInput.getText().trim());
                    plantDataText.setText(plant.getGenus() + "\n" + plant.getSpecies());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        lower.add("Rostlina", plantData);
        lower.add("Plod", fruitData);
        lower.add("Jedy", poisonsData);
        lower.add("Prostředí", environmentsData);
        lower.add("Státy", statesData);
        lower.add("Jedovaté Části", poisonousPartsData);

        lower.setPreferredSize(new Dimension(880,520));

        this.add(lower, gbc);
    }

    public JPanel getUpper(){
        return upper;
    }
}
