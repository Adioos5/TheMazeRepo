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
