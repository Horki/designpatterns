package Behavioural.TemplateMethod;

import javax.swing.*;
import java.awt.*;

public class TemplateFrameMain extends JFrame {
    public TemplateFrameMain(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "Still Template Method pattern";
        graphics.drawString(msg, 300, 300);
    }

    public static void main(String[] args) {
        TemplateFrameMain frame = new TemplateFrameMain("Head First: Design Patterns");
    }
}
