package pl.com.lo.maze.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.JPanel;

public class GameEasterEggWindowGraphics extends JPanel{

    private BufferedImage gameEasterEggWindowBackground;
  
    
    public GameEasterEggWindowGraphics(BufferedImage img) {
        gameEasterEggWindowBackground = img;
       
    }

    public void paint(Graphics g) {
        g.drawImage(gameEasterEggWindowBackground, 0, 0, 768, 1024, null, null);
        g.dispose();
    }
}