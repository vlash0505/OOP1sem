package com.graph.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewWindow extends JFrame implements ActionListener {
    private final Window grid;

    private final JPanel allContent;
    private final JPanel controlPanel;

    private final JButton startButton;
    private final JComboBox<String> gridEditorList;

    public NewWindow(){
        grid = new Window();

        allContent = new JPanel(new BorderLayout());
        controlPanel = new JPanel(new BorderLayout());

        startButton = new JButton("Let's GooOoO");
        startButton.setActionCommand("start");
        startButton.addActionListener(this);
        controlPanel.add(startButton, BorderLayout.WEST);

        String[] editList = {"Source", "Gate", "Dwayne The Rock Johnson"};
        gridEditorList = new JComboBox<>(editList);
        gridEditorList.addActionListener(this);
        controlPanel.add(gridEditorList,BorderLayout.CENTER);

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
