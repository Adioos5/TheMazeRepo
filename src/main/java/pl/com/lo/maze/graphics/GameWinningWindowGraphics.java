package pl.com.lo.maze.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GameWinningWindowGraphics extends JPanel{
    
    private BufferedImage gameWinningWindowBackground;
    public GameWinningWindowGraphics(BufferedImage img) {
        gameWinningWindowBackground = img;
    }

    public void paint(Graphics g) {
        // background
        g.drawImage(gameWinningWindowBackground, 0, 0, 300,400, null);
        g.dispose();
    }
}
