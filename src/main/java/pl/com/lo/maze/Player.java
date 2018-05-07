package pl.com.lo.maze;

import java.awt.image.BufferedImage;

public class Player{
    
    private BufferedImage playerImg;
    private int playerX = 25;
    private int playerY = 305;
    
    public Player(BufferedImage playerImg) {
        this.playerImg = playerImg;
    }
    
    public BufferedImage getPlayerImage() {
        return playerImg;
    }
    
    public int getPlayerX() {
        return playerX;
    }
    
    public int getPlayerY() {
        return playerY;
    }
    
}
