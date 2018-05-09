
package pl.com.lo.maze;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class GameMechanics implements KeyListener {

    private TimeCounter timeCounter;
    private int playerX;
    private int playerY;
    private int tileSize = 32;
    private static final int playerSpeed = 32;
    private boolean play;

    public GameMechanics(Player player) {
        // Class game mechanics sets its own player's beginning coordinates by getting
        // the player's coordinates from object player
        playerX = player.getPlayerX();
        playerY = player.getPlayerY();
    }

    // All getters with variables changed in this class needed for class Context
    public boolean isPlay() {
        return play;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        GameFrame gf = new GameFrame(null, null, null);

        // Here the thread timeCounter starts, when player presses any button at the
        // beginning of
        // the game. It can't start for the second time, because then more than one
        // threads
        // would work which would cause glitches.
        if (!play) {
            timeCounter = new TimeCounter();
            timeCounter.start();
        }
        play = true;

        // Methods called depending on which key we will press
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
        // Game ending window shows when the player(made into rectangle) intersects some
        // rectangle placed at the end of the maze
        if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(2 * 630, 32, 32, 32))) {
            gf.disposeGameWindow();
            JOptionPane.showMessageDialog(null, "Good Job! You got out of the maze.", "Victory",
                    JOptionPane.INFORMATION_MESSAGE);
        }
       if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(-32, 2 * 368, 40 * tileSize, tileSize))) {
           moveUp();
        }
        if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(-32, 0, 40 * tileSize, tileSize))) {
            moveDown();
        }
        if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(-32, 32,2 * tileSize,21 * tileSize))) {
            moveRight();
        }
        if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(-32, 2 * 352, tileSize, tileSize))) {
            moveRight();
        }
        if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(2 * 614, 64, 2 * tileSize, 23 * tileSize))) {
            moveLeft();
        }

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    // Here the player's coordinates are changed
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
