
package pl.com.lo.maze.logic;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import pl.com.lo.maze.importantClasses.Player;
import pl.com.lo.maze.windows.GameFrame;
import pl.com.lo.maze.windows.GameLosingWindow;
import pl.com.lo.maze.windows.GameWinningWindow;

public class GameMechanics implements KeyListener {

	private TimeCounter timeCounter;
	private int playerX;
	private int playerY;
	private int tileSize = 32;
	private static final int playerSpeed = 32;
	private boolean play;
	private GameWinningWindow gww;
	private GameLosingWindow glw;
	private List<Rectangle> listOfRectangles = new ArrayList<>();
	
	public GameMechanics(Player player, GameWinningWindow gww, GameLosingWindow glw) {
		// Class game mechanics sets its own player's beginning coordinates by getting
		// the player's coordinates from object player
		playerX = player.getPlayerX();
		playerY = player.getPlayerY();
		this.gww = gww;
		this.glw = glw;
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

		for(Rectangle r:listOfRectangles) {
		    if(new Rectangle(playerX, playerY, 10, 10).intersects(r)) {
		        playerX = 48;
		        playerY = 716;
		    }
		}
		
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
			setAllValuesToTheBeginning();
			gww.runGameWinningWindow();
		}
		if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(-32, 2 * 388, 40 * tileSize, tileSize))) {
			moveUp();
		}
		if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(-32, 0, 40 * tileSize, tileSize))) {
			moveDown();
		}
		if (new Rectangle(playerX, playerY, 32, 32).intersects(new Rectangle(-32, 32, 2 * tileSize, 21 * tileSize))) {
			moveRight();
		}

		if (new Rectangle(playerX, playerY, 32, 32)
				.intersects(new Rectangle(2 * 624, 64, 2 * tileSize, 23 * tileSize))) {
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
	public void openGameLosingWindow(String message) {
	    GameFrame gf = new GameFrame(null, null, null);
	    gf.disposeGameWindow();
	    setAllValuesToTheBeginning();
	    glw.runGameLosingWindow(message);
	}

	public void addRectangleToTheList(Rectangle rect) {
	    listOfRectangles.add(rect);
	}
	
	public void setAllValuesToTheBeginning() {
	    timeCounter.stop();
	    timeCounter.setSeconds(0);
	    playerX = 48;
	    playerY = 716;
	    play = false;
	    
	}
}
