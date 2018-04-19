import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameGraphics extends JPanel {

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

		// wall4
		g.setColor(Color.white);
		g.fillRect(600, 520, 450, 10);

		// player
		g.setColor(Color.CYAN);
		g.fillRect(27, 520, 15, 15);
	}
}
