package pl.com.lo.maze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TileMapPanel extends JPanel implements KeyListener, ActionListener {

	private File grass_0;
	private File bush_6;
	private File hero;

	private int[][] tileMap;

	private static final int tileSize = 16;
	private static final int delay = 1;

	private int playerX = 20;
	private int playerY = 305;
	private int secounds;

	private boolean play = false;

	private BufferedImage biHero;
	private BufferedImage bi;
	private TimeCounter tc;
	private Timer timer;

	public TileMapPanel(int[][] tileMap) {

		URL grassResourceUrl = ClassLoader.getSystemResource("images/Grass_0.png");
		URL bushResourceUrl = ClassLoader.getSystemResource("images/Bush_6.png");
		URL attackResourceUrl = ClassLoader.getSystemResource("images/attack_2.png");
		try {
			grass_0 = new File(grassResourceUrl.toURI());
			bush_6 = new File(bushResourceUrl.toURI());
			hero = new File(attackResourceUrl.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		tc = new TimeCounter();
		this.tileMap = tileMap;

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		timer = new Timer(delay, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = g.create();
		// map
		for (int i = 0; i < tileMap.length; i++) {
			for (int j = 0; j < getMapHeight(tileMap); j++) {
				if (tileMap[i][j] == 0) {
					try {
						bi = ImageIO.read(grass_0);
					} catch (IOException e) {
					}
				}
				if (tileMap[i][j] == 6) {
					try {
						bi = ImageIO.read(bush_6);
					} catch (IOException e) {
					}

				}
				g2.drawImage(bi, i * tileSize, j * tileSize, tileSize, tileSize, null);
			}
		}

		// tip
		if (play != true) {

			g2.setColor(Color.yellow);
			g2.fillRect(32, 180, 6, 120);
			g2.setFont(new Font("serif", Font.TYPE1_FONT, 15));
			g2.drawString("Press any button", 20, 170);

		}

		// timeCounter
		g2.setColor(Color.white);
		g2.setFont(new Font("serif", Font.TYPE1_FONT, 30));

		if (secounds == 0) {
			g2.drawString("Time left: 1:00", 230, 50);
		} else if (secounds > 0 && secounds <= 50) {
			g2.drawString("Time left: 0:" + (60 - secounds), 230, 50);
		} else {
			g2.drawString("Time left: 0:0" + (60 - secounds), 230, 50);
		}

		// player
		try {
			biHero = ImageIO.read(hero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g2.drawImage(biHero, playerX, playerY, 30, 30, null, null);

		g2.dispose();
	}

	private int getMapHeight(int[][] tileMap) {
		return tileMap[0].length;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (!play) {
			Thread t = new TimeCounter();
			t.start();
		}
		play = true;

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight();

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft();
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moveUp();
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveDown();
		}

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	private void moveRight() {
		playerX += 20;

	}

	private void moveLeft() {
		playerX -= 20;

	}

	private void moveUp() {
		playerY -= 20;

	}

	private void moveDown() {
		playerY += 20;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		secounds = tc.getSecounds();
		timer.start();
		repaint();

	}

}
