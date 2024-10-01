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

public class PlaylistEditor extends JFrame {

    private JPanel panel;
    private MyPanel c;
    private JComboBox<String> optionsBox;
    private int x, y;
    private Random rand;
    public PlaylistEditor() {
        rand = new Random();
        setTitle("Grand Teton");
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
        
        // add a dropdown for sorting criteria
        optionsBox = new JComboBox<>(new String[]{"Coyote","Flower","Cloud","Trees","Berry Bush"});
        JButton shuffle = new JButton("Randomize");
        
        controlPanel.add(optionsBox);
        controlPanel.add(addItems);
        controlPanel.add(delete);
        
        controlPanel.add(shuffle);
        
        add(controlPanel, BorderLayout.NORTH);
        // makes it scrollable if playlist extends past.
        add(new JScrollPane(panel), BorderLayout.CENTER);

        // update the panel with initial songs
        
        c = new MyPanel();
        add(c, BorderLayout.SOUTH);
        
        // add buttons and their actions
        //sorts
        delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCriteria = (String) optionsBox.getSelectedItem();
                //sorts based on option from the dropdown box added. 
                switch (selectedCriteria) {
                    case "Coyote":
                        
                        break;
                    case "Berry Bush":
                        
                        break;
                    case "Flower":
                        
                        break;
                    case "Cloud":
                        break;
                    case "Tree":
                        break;
                    
                }
                updatePanel();
            }
        });
        addItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCriteria = (String) optionsBox.getSelectedItem();
                //sorts based on option from the dropdown box added. 
                switch (selectedCriteria) {
                    case "Coyote":
                        
                        break;
                    case "Berry Bush":
                        
                        break;
                    case "Flower":
                        
                        break;
                    case "Cloud":
                        break;
                    case "Tree":
                        break;
                    
                }
                updatePanel();
            }
        });
        //shuffle
        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                updatePanel();
            }
        });
    }
    



    //This method is used to draw the delete buttons next to each song (Found off stack overflow)
    private void updatePanel() {
        panel.removeAll();  // Remove all existing components
        
        c.repaint();
        panel.revalidate(); // Refresh the layout
        panel.repaint();    // Redraw the panel
    }



}