import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TileMapPanel extends JPanel implements KeyListener {

	File grass_0 = new File("Grass_0.png");
	File bush_6 = new File("Bush_6.png");
	File hero = new File("attack_2.png");
	private int[][] tileMap;
	private int tileSize = 16;
	BufferedImage biHero;
	public BufferedImage bi;
	private int playerX = 20;
	private int playerY = 305;
	private boolean play = false;
	private boolean right = false;
	private boolean left = true;

	public TileMapPanel(int[][] tileMap) {
		this.tileMap = tileMap;

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

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

		right = true;
		left = false;
	}

	private void moveLeft() {
		playerX -= 20;

		right = false;
		left = true;
	}

	private void moveUp() {
		playerY -= 20;

	}

	private void moveDown() {
		playerY += 20;

	}

}
