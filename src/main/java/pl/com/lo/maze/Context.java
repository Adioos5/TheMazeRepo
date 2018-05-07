package pl.com.lo.maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Context implements KeyListener {

    EntryPoint ep = new EntryPoint();
    private TimeCounter timeCounter;
    private int playerX = 30;
    private int playerY = 305;
    private boolean play;
    private static final int playerSpeed = 20;
    private int[][] tileMap;

    private URL gameIconResourceUrl;
    private BufferedImage grass;
    private BufferedImage bush;
    

    private BufferedImage player;

    public Context(int[][] tileMap, URL resource1, BufferedImage img1, BufferedImage img2, BufferedImage img3) {
        this.tileMap = tileMap;

        this.gameIconResourceUrl = resource1;
        grass = img1;
        bush = img2;
        player = img3;
    }
    public BufferedImage getGrassImage() {
        return grass;
    }
    
    public BufferedImage getBushImage() {
        return bush;
    }
    
    public BufferedImage getPlayerImage() {
        return player;
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
