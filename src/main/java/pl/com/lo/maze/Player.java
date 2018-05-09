package pl.com.lo.maze;

import java.awt.image.BufferedImage;

public class Player {

    private BufferedImage playerImg;
    private int playerX;
    private int playerY;

    public Player(BufferedImage playerImg, int playerX, int playerY) {
        this.playerImg = playerImg;
        this.playerX = playerX;
        this.playerY = playerY;
    }
    // Here other classes can get the player image read at the beginning of the program
    public BufferedImage getPlayerImage() {
        return playerImg;
    }
    // Here other classes can get player's beginning coordinates
    public int getPlayerX() {
        return playerX;
    }
    
    public int getPlayerY() {
        return playerY;
    }

}
