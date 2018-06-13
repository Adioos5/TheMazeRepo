
package pl.com.lo.maze.logic;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import pl.com.lo.maze.importantClasses.Player;
import pl.com.lo.maze.windows.GameEasterEggWindow;
import pl.com.lo.maze.windows.GameFrame;
import pl.com.lo.maze.windows.GameLosingWindow;
import pl.com.lo.maze.windows.GameWinningWindow;

public class GameMechanics implements KeyListener {
	
	private int score;
	private TimeCounter timeCounter;
	private int playerX;
	private int playerY;
	private int tileSize = 32;
	private static final int playerSpeed = 32;
	private boolean play;
	private static final int scoreForCoin = 10;
	private GameWinningWindow gww;
	private GameLosingWindow glw;
	private GameEasterEggWindow geew;
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
		    if(new Rectangle(playerX, playerY, 16, 16).intersects(r)) {
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
				.intersects(new Rectangle(32, 32, tileSize, tileSize))) { 
			stepOnCoin1();
		}
		if (new Rectangle(playerX, playerY, 32, 32)
				.intersects(new Rectangle(656, 32, tileSize, tileSize))) {
			stepOnCoin2();
		}
		if (new Rectangle(playerX, playerY, 32, 32)
				.intersects(new Rectangle((22 * tileSize) + 16, 9 * tileSize, tileSize, tileSize))) {
			stepOnCoin3();
		}
		if (new Rectangle(playerX, playerY, 32, 32)
				.intersects(new Rectangle((22 * tileSize) + 16, 17 * tileSize, tileSize, tileSize))) {
			stepOnCoin4();
		}
		if (new Rectangle(playerX, playerY, 32, 32)
				.intersects(new Rectangle((5 * tileSize) + 16, 21 * tileSize, tileSize,  tileSize))) {
			stepOnCoin5();
		}
		if (new Rectangle(playerX, playerY, 32, 32)
				.intersects(new Rectangle((37 * tileSize) + 16, 23 * tileSize, tileSize,  tileSize))) {
			stepOnCoin6();
		}
		if (new Rectangle(playerX, playerY, 32, 32)
				.intersects(new Rectangle(-32, 716, tileSize,  tileSize))) {
			System.out.println("Basiak");
			gf = new GameFrame(null, null, null);
		    gf.disposeGameWindow();
		    setAllValuesToTheBeginning();
		    geew.runGameEasterEggWindow("basiak");
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
	public void stepOnCoin1() {
		boolean coin1 = true;
		if (coin1 = true){
		score += scoreForCoin;
		coinDispose();
		//Timer += 10000;
		coin1 = false;}
	}
	public void stepOnCoin2() {
		boolean coin2 = true;
		if (coin2 = true){
		score += scoreForCoin;
		coinDispose();
		//Timer += 10000;
		coin2 = false;}
	}
	public void stepOnCoin3() {
		boolean coin3 = true;
		if (coin3 = true){
		score += scoreForCoin;
		coinDispose();
		//Timer += 10000;
		coin3 = false;}
	}
	public void stepOnCoin4() {
		boolean coin4 = true;
		if (coin4 = true){
		score += scoreForCoin;
		coinDispose();
		//Timer += 10000;
		coin4 = false;}
	}	
	public void stepOnCoin5() {
		boolean coin5 = true;
		if (coin5 = true){
		score += scoreForCoin;
		coinDispose();
		//Timer += 10000;
		coin5 = false;}
	}
	public void stepOnCoin6() {
		boolean coin6 = true;
		if (coin6 = true){
		score += scoreForCoin;
		coinDispose();
		//Timer += 10000;
		coin6 = false;}
	}
	public void stepOnSpikes() {
		
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
