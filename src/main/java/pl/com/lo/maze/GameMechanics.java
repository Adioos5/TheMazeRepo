
package pl.com.lo.maze;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

public class GameMechanics implements MouseListener, MouseMotionListener {

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

    @Override
    public void mouseClicked(MouseEvent me) {

        // Here the thread timeCounter starts, when player presses any button at the
        // beginning of
        // the game. It can't start for the second time, because then more than one
        // threads
        // would work which would cause glitches.
        if(new Rectangle(me.getX(), me.getY(), 10,10).intersects(new Rectangle(playerX-16, playerY-16, 32, 32))) {
            if (!play) {
                timeCounter = new TimeCounter();
                timeCounter.start();
            }
            play = true;
            
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent me) {
        GameFrame gf = new GameFrame(null, null, null);
        if (play) {
            playerX = me.getX();
            playerY = me.getY();
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
        if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(-32, 32, 2 * tileSize, 21 * tileSize))) {
            moveRight();
        }
        if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(-32, 2 * 352, tileSize, tileSize))) {
            moveRight();
        }
        if (new Rectangle(playerX, playerY, 32, 32)
                .intersects(new Rectangle(2 * 614, 64, 2 * tileSize, 23 * tileSize))) {
            moveLeft();
        }

    }

}
