package ui;

import javax.swing.*;

/**
 * Represents the frame of the graphical user interface of WeaveMaster application
 */
public class Frame extends JFrame {
    private Panel p;

    public Frame() {
        p = new Panel();
        add(p);
        setTitle("Weave Master");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }


}
