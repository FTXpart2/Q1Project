// Extending JPanel class
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;	// Setting dimensions of JPanel
import java.awt.Graphics;	// Using Graphics object to draw
import java.awt.Color;		// Import Color to use colors
import java.awt.Polygon;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.util.Random;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Editor extends JFrame {
    private JPanel panel;
    private MyPanel c;
    private JComboBox<String> optionsBox;
    private int x, y;
    private Random rand;
    public Editor() {
        
        c = MyPanel.loadData("data.ser");
        if (c == null) {
            c = new MyPanel(); // Create a new instance if loading fails
        }
        rand = new Random();
        setTitle("Grand Teton (Autosave)");
        setSize(800, 670);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // sets panel for selection box
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // create a panel for the control buttons
        //Control Panel to seperate from the list panel, easier interface.
        JPanel controlPanel = new JPanel();
        JButton addItems = new JButton("Add Item");
        JButton delete = new JButton("Delete Randomly");
        JButton clear = new JButton("Clear Screen");
        // add a dropdown for sorting criteria
        optionsBox = new JComboBox<>(new String[]{"Coyote","Flower","Cloud","Trees","Berry Bush"});
        JButton shuffle = new JButton("Randomize");
        
        controlPanel.add(optionsBox);
        controlPanel.add(addItems);
        controlPanel.add(delete);
        
        
        controlPanel.add(clear);
        controlPanel.add(shuffle);
        add(controlPanel, BorderLayout.NORTH);
        // makes it scrollable if playlist extends past.
        add(new JScrollPane(panel), BorderLayout.CENTER);

        // update the panel with initial songs
        pack();
        add(c, BorderLayout.SOUTH);
        
        // add buttons and their actions
        //sorts
        addItems.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCriteria = (String) optionsBox.getSelectedItem();
                //sorts based on option from the dropdown box added. 
                switch (selectedCriteria) {
                    case "Coyote":
                        x = rand.nextInt(600)+100;
                        y = rand.nextInt(650-400+1)+400;
                        System.out.println(x);
                        System.out.println(y);
                        c.addItemsToList(x,y,"Coyote");
                        break;
                    case "Berry Bush":
                        x = rand.nextInt(700);
                        y = rand.nextInt(650-400+1)+400;
                        c.addItemsToList(x,y,"Berry Bush");
                        break;
                    case "Flower":
                        x = rand.nextInt(700);
                        y = rand.nextInt(650-400+1)+400;
                        c.addItemsToList(x,y,"Flower");
                        break;
                    case "Cloud":
                        x = rand.nextInt(700);
                        y = rand.nextInt(100);
                        c.addItemsToList(x,y,"Cloud");
                        break;
                    case "Trees":
                        x = rand.nextInt(700);
                        y = rand.nextInt(650-400+1)+400;
                        c.addItemsToList(x,y,"Trees");
                        break;
                    
                }
                updatePanel();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCriteria = (String) optionsBox.getSelectedItem();
                //sorts based on option from the dropdown box added. 
                switch (selectedCriteria) {
                    case "Coyote":
                        c.deleteItems("Coyote");
                        break;
                    case "Berry Bush":
                        c.deleteItems("Berry Bush");
                        break;
                    case "Flower":
                        c.deleteItems("Flower");
                        break;
                    case "Cloud":
                        c.deleteItems("Cloud");
                        break;
                    case "Trees":
                        c.deleteItems("Trees");
                        break;
                    
                }
                updatePanel();
            }
        });
        //shuffle
        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                c.randomizeItems();
                updatePanel();
            }
        });
        clear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                c.clear();
                updatePanel();
            }
            
        });
        //saves code when windows close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        // Add a window listener to save data on close
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                c.saveData("data.ser"); // Save data when closing
            }
        });
        pack();
    }
    



    //This method is used to draw the delete buttons next to each song (Found off stack overflow)
    private void updatePanel() {
        panel.removeAll();  // Remove all existing components
        
        c.repaint();
        panel.revalidate(); // Refresh the layout
        panel.repaint();    // Redraw the panel
        
    }
    




}