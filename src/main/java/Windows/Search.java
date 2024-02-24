package Windows;

import Constants.Constants;
import Objects.Fruit.Fruit;
import Objects.Fruit.FruitDaoImpl;
import Objects.Plant.PlantDaoImpl;
import Objects.Poison.Poison;
import Objects.Poison.PoisonDao;
import Objects.Poison.PoisonDaoImpl;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class which represents the search window. It is a singleton.
 */
public class Search extends JFrame implements ActionListener{

    private static Search instance = null;

    CardLayout cl;
    JPanel cards;

    /* Constructor: Handles most of the code in this class */
    private Search(){
        /* Initializing the frame */

        this.setTitle("Hledat");

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
               instance = null;
            }
        });

        cl = new CardLayout();
        cards = new JPanel(cl);

        PlantsSearch plantsSearch = new PlantsSearch();

        JComboBox<String> cardBoxPlants = new JComboBox<>(new String[]{"Plants", "Poisons"});
        cardBoxPlants.setSelectedIndex(0);

       cardBoxPlants.addActionListener(this);

        plantsSearch.getUpper().add(cardBoxPlants);

        cards.add("Plants", plantsSearch);

        PoisonsSearch poisonsSearch = new PoisonsSearch();

        JComboBox<String> cardBoxPoisons = new JComboBox<>(new String[]{"Plants", "Poisons"});
        cardBoxPoisons.setSelectedIndex(1);

        poisonsSearch.getUpper().add(cardBoxPoisons);

        cardBoxPoisons.addActionListener(this);

        cards.add("Poisons", poisonsSearch);

        this.setContentPane(cards);

        /* Making the frame visible */
        this.pack();

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    /* Used only to crate the window */
    public static void CreateWindow(){
        if(instance != null) return;

        instance = new Search();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String card = (String)cb.getSelectedItem();
        cl.show(cards, card);
    }
}
