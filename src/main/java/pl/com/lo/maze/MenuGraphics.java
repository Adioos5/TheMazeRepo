package pl.com.lo.maze;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MenuGraphics extends JPanel {

    BufferedImage menuBackground;

    public MenuGraphics(Context context) {
        menuBackground = context.getMenuBackgroundImage();
    }

    public void paint(Graphics g) {
        // background
        g.drawImage(menuBackground,0, 0, 500, 540, null, null);
        g.dispose();
    }
}
