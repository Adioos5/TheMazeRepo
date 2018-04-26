import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuMechanics implements ActionListener {

	JButton play;
	JButton exit;
	JButton settings;

	public MenuMechanics(JButton b1, JButton b2, JButton b3) {
		play = b1;
		exit = b2;
		settings = b3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		MenuGraphics mg = new MenuGraphics();
		GameFrame gf = new GameFrame();

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
