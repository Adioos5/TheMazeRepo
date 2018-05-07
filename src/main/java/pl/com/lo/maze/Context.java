package pl.com.lo.maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Context implements KeyListener {

    EntryPoint ep = new EntryPoint();
    private TimeCounter timeCounter;
    private int playerX = 30;
    private int playerY = 305;
    private boolean play;
    private static final int playerSpeed = 20;
    private int[][] tileMap = ep.getTileMap();

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
