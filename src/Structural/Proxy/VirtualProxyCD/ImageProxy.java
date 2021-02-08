package Structural.Proxy.VirtualProxyCD;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {
    private volatile ImageIcon imageIcon;
    private final URL imageURL;
    private boolean retrieving;
    private final int width;
    private final int height;

    public ImageProxy(URL url) {
        imageURL = url;
        retrieving = false;
        width = 800;
        height = 600;
    }

    private synchronized void setImageIcon(ImageIcon i) {
        imageIcon = i;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            System.out.println("Already loaded");
            imageIcon.paintIcon(c, g, x, y);
            return;
        }
        g.drawString("Loading album cover, please wait...", x + 300, y + 190);
        if (!retrieving) {
            retrieving = true;
            System.out.println("Fetching URL!!!");

            Thread thread = new Thread(() -> {
                try {
                    setImageIcon(new ImageIcon(imageURL, "Album Cover"));
                    c.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        }
        return width;
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        }
        return height;
    }
}
