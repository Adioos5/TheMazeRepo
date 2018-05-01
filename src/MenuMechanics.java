import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuMechanics implements ActionListener {
	JButton play;
	JButton exit;
	JButton settings;
	private int[][] tileMap;



	public MenuMechanics(JButton b1, JButton b2, JButton b3, int[][] tileMap) {
		play = b1;
		exit = b2;
		settings = b3;
		this.tileMap = tileMap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		MenuGraphics mg = new MenuGraphics(tileMap);
		GameFrame gf = new GameFrame(tileMap);

		if (e.getSource() == play) {
			gf.runGame();
			mg.closeWindow();
		}

		if (e.getSource() == exit) {
			mg.closeWindow();
		}

		if (e.getSource() == settings) {
			//ustawienia
		}
		
	}

}
