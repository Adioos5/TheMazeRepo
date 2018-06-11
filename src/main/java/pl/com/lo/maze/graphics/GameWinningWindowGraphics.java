package pl.com.lo.maze.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameWinningWindowGraphics extends JPanel{
  
    private int score = 0;
  
    private BufferedImage gameWinningWindowBackground;
    
    public GameWinningWindowGraphics(BufferedImage img) {
        gameWinningWindowBackground = img;
    }

    public void paint(Graphics g) {
        // background
        g.drawImage(gameWinningWindowBackground, 0, 0, 1000,600, null);

        // writings
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.TYPE1_FONT,70));
        g.drawString("Congratulations!", 230, 130);
        g.setFont(new Font("serif", Font.TYPE1_FONT,40));
        g.setColor(Color.yellow);
        g.drawString("Your score: " + score, 240, 240);
        g.dispose();
    }
}
