package Behavioural.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AngelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Don't do it, you might regret it!");
    }
}

class DevilListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Come on, do it!");
    }
}

public class SwingObserverMain {
    private JFrame frame;

    public static void main(String[] args) {
        SwingObserverMain example = new SwingObserverMain();
        example.go();
    }

    private void go() {
        frame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER, button);
        // frame properties
        frame.setSize(1200, 800);
        frame.setVisible(true);
    }
}
