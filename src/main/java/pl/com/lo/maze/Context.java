package pl.com.lo.maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Context implements KeyListener {

    private TimeCounter timeCounter;
    private Player player;
    private int playerX;
    private int playerY;
    private boolean play;
    private int[][] tileMap;
    private static final String gameTitle = "The Maze";
    private static final int playerSpeed = 20;
    private static final int gameWindowX = 100;
    private static final int gameWindowY = 50;
    private static final int gameWindowWidth = 630;
    private static final int gameWindowHeight = 414;

    private URL gameIconResourceUrl;
    private BufferedImage grass;
    private BufferedImage bush;


    public Context(int[][] tileMap,Player player, URL resource1, BufferedImage img1, BufferedImage img2) {
        this.tileMap = tileMap;
        this.player = player;
        this.gameIconResourceUrl = resource1;
        playerX = player.getPlayerX();
        playerY = player.getPlayerY();
        grass = img1;
        bush = img2;
    }
    
    public String getGameTitle() {
        return gameTitle;
    }
    
    public int getGamewindowx() {
        return gameWindowX;
    }

    public int getGamewindowy() {
        return gameWindowY;
    }

    public int getGamewindowwidth() {
        return gameWindowWidth;
    }

    public int getGamewindowheight() {
        return gameWindowHeight;
    }

    public BufferedImage getGrassImage() {
        return grass;
    }

    public BufferedImage getBushImage() {
        return bush;
    }

    public BufferedImage getPlayerImage() {
        return player.getPlayerImage();
    }

    public URL getGameIconResourceUrl() {
        return gameIconResourceUrl;
    }

    public boolean isPlay() {
        return play;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int[][] getTileMap() {
        return tileMap;
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        if (!play) {
            timeCounter = new TimeCounter();
            timeCounter.start();
        }
        play = true;

        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }

        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        }

        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            moveUp();
        }

        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        // TODO Auto-generated method stub

    }

    public void moveRight() {
        playerX += playerSpeed;
    }

    public void moveLeft() {
        playerX -= playerSpeed;
    }

    public void moveUp() {
        playerY -= playerSpeed;
    }

    public void moveDown() {
        playerY += playerSpeed;
    }
}
