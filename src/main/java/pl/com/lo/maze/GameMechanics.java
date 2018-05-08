package pl.com.lo.maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class GameMechanics implements KeyListener {

	private TimeCounter timeCounter;
	private Player player;
	private int playerX;
	private int playerY;
	private static final int playerSpeed = 20;
	private boolean play;

	public GameMechanics(Player player) {
		this.player = player;
		playerX = player.getPlayerX();
		playerY = player.getPlayerY();
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
		if (2 + 2 == 4) {
			JOptionPane.showMessageDialog(null, "Good Job! You got out of the maze.", "Victory",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

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
