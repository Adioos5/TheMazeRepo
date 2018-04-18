import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameGraphics extends JPanel {
	
	public void paint(Graphics g) {
	
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, 1100, 600);
		
		//wall1
		g.setColor(Color.white);
		g.fillRect(0,400,150,10);
		
		//wall2
		g.setColor(Color.white);
		g.fillRect(70, 450, 10, 150);
		
		//player
		g.setColor(Color.CYAN);
		g.fillRect(27,520,15,15);
	}
}
