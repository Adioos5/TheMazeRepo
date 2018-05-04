import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TileMapPanel extends JPanel implements MouseListener, MouseMotionListener {

	File grass_0 = new File("Grass_0.png");
	File bush_6 = new File("Bush_6.png");
	private int[][] tileMap;
	private int tileSize = 16;
	public BufferedImage bi;
	public int MouseX = 34;
	public int MouseY = 320;
	private boolean play = false;
	
	public TileMapPanel(int[][] tileMap) {
		this.tileMap = tileMap;
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
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
			g2.drawString("Click on the square", 20, 170);

		}

		// player
		g2.setColor(Color.CYAN);
		g2.fillRect(MouseX - 7, MouseY - 7, 8, 8);

		g2.dispose();

	}

	private int getMapHeight(int[][] tileMap) {
		return tileMap[0].length;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent me) {
		if (play) {
			MouseX = me.getX();
			MouseY = me.getY();
			repaint();

		}

	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if (new Rectangle(me.getX() - 7, me.getY() - 7, 15, 15).intersects(new Rectangle(34, 320, 15, 15))) {
			play = true;
			repaint();
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
}
