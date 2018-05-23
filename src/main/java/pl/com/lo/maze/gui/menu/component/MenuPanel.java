package pl.com.lo.maze.gui.menu.component;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import pl.com.lo.maze.Context;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

    private BufferedImage backgroundImage;

    public MenuPanel(Context context) {
        backgroundImage = context.getMenuBackgroundImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
