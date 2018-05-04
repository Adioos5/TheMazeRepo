import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class GameGraphics extends JPanel implements MouseListener, MouseMotionListener {

	public int MouseX = 34;
	public int MouseY = 320;
	private int tileMap[][];

	private boolean play = false;

	public GameGraphics() {

		addMouseListener(this);
		addMouseMotionListener(this);

	}

	public void paint(Graphics g) {
		// tip
		if (play != true) {

			g.setColor(Color.yellow);
			g.fillRect(32, 180, 6, 120);
			g.setFont(new Font("serif", Font.TYPE1_FONT, 15));
			g.drawString("Click on the square", 20, 170);

		}

		// player
		g.setColor(Color.CYAN);
		g.fillRect(MouseX - 7, MouseY - 7, 8, 8);

		g.dispose();

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
		if (new Rectangle(MouseX - 7, MouseY - 7, 15, 15).intersects(new Rectangle(0, 0, 5, 400))
				|| new Rectangle(MouseX - 7, MouseY - 7, 15, 15).intersects(new Rectangle(0, 0, 640, 5))
				|| new Rectangle(MouseX - 7, MouseY - 7, 15, 15).intersects(new Rectangle(630, 0, 5, 400))
				|| new Rectangle(MouseX - 7, MouseY - 7, 15, 15).intersects(new Rectangle(70, 367, 640, 5))) {
			MouseX = 34;
			MouseY = 320;
			play = false;
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
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
