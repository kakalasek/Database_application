package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

   public MainMenu() {
       this.setTitle("Jedovaté Rostliny");

       this.setDefaultCloseOperation(EXIT_ON_CLOSE);

       JPanel panel = new JPanel();

       BorderLayout ll = new BorderLayout();
       ll.setHgap(5);
       ll.setVgap(5);

       panel.setLayout(ll);

       JButton search = new JButton("Hledat");
       search.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Search.CreateWindow();
           }
       });
       panel.add(search, BorderLayout.NORTH);

       JButton insert = new JButton("Přidat");
       insert.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Insert.createWindow();
           }
       });
       panel.add(insert, BorderLayout.EAST);

       JButton delete = new JButton("Vymazat");
       delete.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                Delete.createWindow();
           }
       });
       panel.add(delete, BorderLayout.WEST);

       JButton update = new JButton("Upravit");
       update.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Update.createWindow();
           }
       });
       panel.add(update, BorderLayout.SOUTH);
       panel.add(new JLabel(new ImageIcon("src/main/resources/images/poisonous_plant.png")), BorderLayout.CENTER);

       this.getContentPane().add(panel, BorderLayout.CENTER);

       this.pack();

       this.setLocationRelativeTo(null);  // This will make the frame appear in the center of the screen

       this.setVisible(true);

   }
}
