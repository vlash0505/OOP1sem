package com.graph.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * Class that represents frame of pathfinding visualisation
 * app.
 */

public class Frame extends JFrame {
    private static final int FRAME_WIDTH = 690;
    private static final int CONTROL_PANEL_HEIGHT = 75;

    private final GridPanel grid;
    private final JPanel controlPanel;

    /**
     * Constructor for the frame.
     */
    public Frame(){
        JPanel allContent = new JPanel(new BorderLayout());
        this.grid = new GridPanel();
        this.controlPanel = new JPanel(new BorderLayout());

        startButtonInit();
        comboBoxInit();
        resetButtonInit();

        //width is the same as grid panel's width
        controlPanel.setPreferredSize(new Dimension(FRAME_WIDTH, CONTROL_PANEL_HEIGHT));

        allContent.add(grid,BorderLayout.CENTER);
        allContent.add(controlPanel,BorderLayout.SOUTH);

        this.add(allContent);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Pathfinding Visualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    /**
     * Method that initializes a start button on a panel.
     */

    public void startButtonInit() {
        JButton startButton = new JButton("Start");
        //when button is pressed, pathfinding algorithm starts.
        //right after it's done, animation starts.
        startButton.addActionListener(e -> grid.startSearch());
        controlPanel.add(startButton, BorderLayout.WEST);
    }

    /**
     * Method that initializes a reset button on a panel.
     */

    public void resetButtonInit() {
        JButton resetButton = new JButton("Reset");
        //when button is pressed, grid refreshes and
        //becomes blank.
        resetButton.addActionListener(e -> grid.resetFrame());
        controlPanel.add(resetButton, BorderLayout.EAST);
    }

    /**
     * Method that initializes combo box that allows the user to choose
     * type of the tile user wants to set on the grid.
     */

    public void comboBoxInit() {
        String[] tileTypes = {"Spawn", "Destination", "Wall"};
        JComboBox<String> tileModes = new JComboBox<>(tileTypes);
        //sets the type of the tile the user wants to put on the grid.
        tileModes.addActionListener(e -> grid.setTileMode(tileModes.getSelectedIndex()));
        controlPanel.add(tileModes, BorderLayout.CENTER);
    }
}