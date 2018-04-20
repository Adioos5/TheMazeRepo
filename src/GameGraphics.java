import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameGraphics extends JPanel {

	private int MouseX = 27;
	private int MouseY = 520;
	
	
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

		// player
		g.setColor(Color.CYAN);
		g.fillRect(MouseX, MouseY, 15, 15);
	
	}

	
	
	public void setMouseCoOrdinates(int x, int y) {
		MouseX = x;
		MouseY = y;
		System.out.println("X: "+ MouseX+" Y: "+MouseY);
		repaint();
		
	}

	
}
