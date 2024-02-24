package Windows;

import Constants.Constants;
import Objects.Fruit.FruitDaoImpl;
import Objects.Plant.PlantDaoImpl;
import Objects.Poison.PoisonDaoImpl;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class PoisonsSearch extends JPanel {
    private final PlantDaoImpl pldi = new PlantDaoImpl();
    private final PoisonDaoImpl podi = new PoisonDaoImpl();
    private final FruitDaoImpl frdi = new FruitDaoImpl();

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
        JPanel effectsData = new JPanel();

        lower.add("Jed", poisonData);
        lower.add("Účinky", effectsData);

        lower.setPreferredSize(new Dimension(880,520));

        this.add(lower, gbc);
    }

    public JPanel getUpper(){
        return upper;
    }

}

