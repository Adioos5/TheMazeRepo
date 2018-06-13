package pl.com.lo.maze.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GameEasterEggWindowGraphics extends JPanel{

    private BufferedImage gameEasterEggWindowBackground;
    private String message;
    
    public GameEasterEggWindowGraphics(BufferedImage img, String message) {
        gameEasterEggWindowBackground = img;
        this.message = message;
    }

    public void paint(Graphics g) {
        g.drawImage(gameEasterEggWindowBackground, 0, 0, 768, 1024, null);
        g.dispose();
    }
}