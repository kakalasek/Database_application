package Windows;

import Constants.Constants;
import Objects.Fruit.FruitDaoImpl;
import Objects.Plant.PlantDaoImpl;
import Objects.Poison.PoisonDaoImpl;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

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
        JPanel fruitData = new JPanel();
        JPanel poisonsData = new JPanel();
        JPanel environmentsData = new JPanel();
        JPanel statesData = new JPanel();
        JPanel poisonousPartsData = new JPanel();

        lower.add("Rostlina", plantData);
        lower.add("Plod", fruitData);
        lower.add("Jed", poisonsData);
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
