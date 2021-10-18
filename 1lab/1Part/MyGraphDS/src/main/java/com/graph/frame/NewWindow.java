package com.graph.frame;

import javax.swing.*;
import java.awt.*;

public class NewWindow extends JFrame {
    private final Window grid;

    private final JPanel allContent;
    private final JPanel controlPanel;

    private final JButton startButton;
    private final JComboBox<String> tileModes;

    public NewWindow(){
        grid = new Window();
        allContent = new JPanel(new BorderLayout());
        controlPanel = new JPanel(new BorderLayout());

        startButton = new JButton("Let's GooOoO");
        startButton.setActionCommand("start");
        startButton.addActionListener(e -> grid.startSearch());
        controlPanel.add(startButton, BorderLayout.WEST);

        String[] editList = {"Source", "Gate", "Dwayne The Rock Johnson"};
        tileModes = new JComboBox<>(editList);
        tileModes.addActionListener(e -> grid.setTileMod(tileModes.getSelectedIndex()));
        controlPanel.add(tileModes, BorderLayout.CENTER);

        controlPanel.setPreferredSize(new Dimension(690,75));

        allContent.add(grid,BorderLayout.CENTER);
        allContent.add(controlPanel,BorderLayout.SOUTH);

        this.add(allContent);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Bruh");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}