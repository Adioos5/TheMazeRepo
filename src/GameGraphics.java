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
	public int MouseY = 520;

	private boolean play = false;

	public GameGraphics() {

		addMouseListener(this);
		addMouseMotionListener(this);

	}

	public void paint(Graphics g) {

		// background
		g.setColor(Color.black);
		g.fillRect(0, 0, 1100, 600);

		// borders
		g.setColor(Color.white);
		g.fillRect(0, 0, 5, 600);

		g.setColor(Color.white);
		g.fillRect(0, 0, 1100, 5);

		g.setColor(Color.white);
		g.fillRect(1090, 0, 5, 600);

		g.setColor(Color.white);
		g.fillRect(70, 567, 1100, 5);

		// wall1
		g.setColor(Color.white);
		g.fillRect(0, 400, 150, 10);

		// wall2
		g.setColor(Color.white);
		g.fillRect(70, 450, 10, 150);

		// wall3
		g.setColor(Color.white);
		g.fillRect(140, 450, 10, 70);

		// wall4
		g.setColor(Color.white);
		g.fillRect(140, 520, 200, 10);

		// wall5
		g.setColor(Color.white);
		g.fillRect(140, 520, 400, 10);

		// wall6
		g.setColor(Color.white);
		g.fillRect(450, 450, 10, 70);

		// wall7
		g.setColor(Color.white);
		g.fillRect(200, 400, 10, 80);

		// wall8
		g.setColor(Color.white);
		g.fillRect(200, 470, 200, 10);

		// wall9
		g.setColor(Color.white);
		g.fillRect(600, 520, 450, 10);

		// wall10
		g.setColor(Color.white);
		g.fillRect(70, 250, 10, 100);

		// wall11
		g.setColor(Color.white);
		g.fillRect(140, 110, 10, 240);

		// wall12
		g.setColor(Color.white);
		g.fillRect(70, 250, 70, 10);

		// wall13
		g.setColor(Color.white);
		g.fillRect(0, 180, 70, 10);

		// wall14
		g.setColor(Color.white);
		g.fillRect(70, 110, 70, 10);

		// wall15
		g.setColor(Color.white);
		g.fillRect(0, 40, 150, 10);

		// wall16
		g.setColor(Color.white);
		g.fillRect(70, 110, 180, 10);

		// wall17
		g.setColor(Color.white);
		g.fillRect(200, 40, 150, 10);

		// wall18
		g.setColor(Color.white);
		g.fillRect(150, 340, 150, 10);

		// tip
		if (play != true) {
			g.setColor(Color.yellow);
			g.fillRect(32, 380, 6, 120);
			g.setFont(new Font("serif", Font.TYPE1_FONT, 15));
			g.drawString("Click on the square", 20, 370);
		}

		// player
		g.setColor(Color.CYAN);
		g.fillRect(MouseX - 7, MouseY - 7, 15, 15);

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
		if (new Rectangle(MouseX - 7, MouseY - 7, 15, 15).intersects(new Rectangle(0, 0, 5, 600))
				|| new Rectangle(MouseX - 7, MouseY - 7, 15, 15).intersects(new Rectangle(0, 0, 1100, 5))
				|| new Rectangle(MouseX - 7, MouseY - 7, 15, 15).intersects(new Rectangle(1090, 0, 5, 600))
				|| new Rectangle(MouseX - 7, MouseY - 7, 15, 15).intersects(new Rectangle(70, 567, 1100, 5))) {
			MouseX = 34;
			MouseY = 520;
			play = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if (new Rectangle(me.getX() - 7, me.getY() - 7, 15, 15).intersects(new Rectangle(34, 520, 15, 15))) {
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
