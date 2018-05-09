package pl.com.lo.maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MenuGraphics extends JPanel {

    public void paint(Graphics g) {
        // background
        g.setColor(Color.red);
        g.fillRect(0, 0, 500, 540);

    }
}
