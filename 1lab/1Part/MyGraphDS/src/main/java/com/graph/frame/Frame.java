package com.graph.frame;

import javax.swing.*;
import java.awt.*;

/**
 * Class that represents frame of pathfinding visualisation
 * app.
 */

public class Frame extends JFrame {
    private final GridPanel grid;
    private final JPanel controlPanel;

    /**
     * Constructor for the frame.
     */
    public Frame(){
        JPanel allContent = new JPanel(new BorderLayout());
        grid = new GridPanel();
        controlPanel = new JPanel(new BorderLayout());

        startButtonInit();
        comboBoxInit();

        controlPanel.setPreferredSize(new Dimension(690,75));

        allContent.add(grid,BorderLayout.CENTER);
        allContent.add(controlPanel,BorderLayout.SOUTH);

        this.add(allContent);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Shortest Path Visualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    /**
     * Method that initializes a start button on a panel.
     */

    public void startButtonInit() {
        JButton startButton = new JButton("Start");
        startButton.setActionCommand("start");
        startButton.addActionListener(e -> grid.startSearch());
        controlPanel.add(startButton, BorderLayout.WEST);
    }

    /**
     * Method that initializes combo box that allows the user to choose
     * type of the tile user wants to use.
     */

    public void comboBoxInit() {
        String[] tileTypes = {"Source", "Gate", "Wall"};
        JComboBox<String> tileModes = new JComboBox<>(tileTypes);
        tileModes.addActionListener(e -> grid.setTileMode(tileModes.getSelectedIndex()));
        controlPanel.add(tileModes, BorderLayout.CENTER);
    }
}