package pl.com.lo.maze.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GameLosingWindowGraphics extends JPanel{

    private BufferedImage gameLosingWindowBackground;
    private String message;
    
    public GameLosingWindowGraphics(BufferedImage img, String message) {
        gameLosingWindowBackground = img;
        this.message = message;
    }

    public void paint(Graphics g) {
        // background
        g.drawImage(gameLosingWindowBackground, 0, -20, 1000, 620, null);

        // writings
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.TYPE1_FONT, 100));
        g.drawString("Game Over", 250, 140);
        g.setFont(new Font("serif", Font.TYPE1_FONT, 50));
        g.drawString(message,375 , 250);
        g.dispose();
    }
}
