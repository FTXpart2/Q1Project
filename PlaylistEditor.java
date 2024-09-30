import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;	// Extending JPanel class
import java.awt.Dimension;	// Setting dimensions of JPanel
import java.awt.Graphics;	// Using Graphics object to draw
import java.awt.Color;		// Import Color to use colors
import java.awt.Polygon;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class PlaylistEditor extends JFrame {

    private JPanel panel;
    private JTextField t1,t2,t3;
    private JComboBox<String> optionsBox;
    private int cloudX, cloudY;
    public PlaylistEditor() {
        setTitle("Grand Teton");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // sets panel for selection box
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // create a panel for the control buttons
        //Control Panel to seperate from the list panel, easier interface.
        JPanel controlPanel = new JPanel();
        JButton addSong = new JButton("Add Song");
        JButton shuffle = new JButton("Shuffle");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        // add a dropdown for sorting criteria
        optionsBox = new JComboBox<>(new String[]{"Coyote","Flower","Cloud","Trees","Berry Bush"});
        JButton sort = new JButton("Sort");
        controlPanel.add(addSong);
        controlPanel.add(optionsBox);
        controlPanel.add(sort);
        controlPanel.add(shuffle);
        
        add(controlPanel, BorderLayout.NORTH);
        // makes it scrollable if playlist extends past.
        add(new JScrollPane(panel), BorderLayout.CENTER);

        // update the panel with initial songs
        updatePanel();
        MyPanel c = new MyPanel();
        add(c, BorderLayout.SOUTH);
        // add buttons and their actions
        addSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText().trim();
                String album = t2.getText().trim();
                String artist = t3.getText().trim();
                if (!name.isEmpty() && !album.isEmpty() && !artist.isEmpty()) {

                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    updatePanel();
                }
            }
        });
        //sorts
        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCriteria = (String) optionsBox.getSelectedItem();
                //sorts based on option from the dropdown box added. 
                switch (selectedCriteria) {
                    case "Sort by Name":
                        
                        break;
                    case "Sort by Album":
                        
                        break;
                    case "Sort by Artist":
                        
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
        c.update();
        panel.revalidate(); // Refresh the layout
        panel.repaint();    // Redraw the panel
    }



}