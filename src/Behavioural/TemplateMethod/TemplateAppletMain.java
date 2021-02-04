package Behavioural.TemplateMethod;

import java.applet.Applet;
import java.awt.Graphics;

public class TemplateAppletMain extends Applet {
    private String message;

    public void init() {
        message = "Hello World! Still Template Method, design pattern";
        repaint();
    }

    public void start() {
        message = "Now I'm starting template method";
        repaint();
    }

    public void stop() {
        message = "Template method being stopped...";
        repaint();
    }

    public void destroy() {
        //
    }

    public void paint(Graphics graphics) {
        graphics.drawString(message, 5, 15);
    }
}
