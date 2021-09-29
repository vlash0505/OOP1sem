package com.graph.frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//GUI is not yet implemented, what
//you see here is just a playground.

public class MyGraphFrame extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;

    public MyGraphFrame() {
        this.setTitle("Graph playground");
        this.setSize(1000,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);

        button1 = new JButton();
        button1.setBounds(80,80,80,80);
        button1.addActionListener(this);
        button1.setFocusable(false);
        button1.setText("Test1");

        button2 = new JButton();
        button2.setBounds(150,150,150,150);
        button2.addActionListener(this);
        button2.setFocusable(false);
        button2.setText("Test2");

        this.add(button1);
        this.add(button2);
    }

    /**
     * Method that performs action in GUI after user
     * presses the button. The action depends on which
     * button the user press.
     *
     * @param e - action that happens when user presses
     *            the specific button.
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button1.equals(e.getSource())) {
            System.out.println("It works!");
        } else {
            System.out.println("Good Bye!");
        }
    }
}