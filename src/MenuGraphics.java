import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuGraphics {
	// mg
	public JFrame Menu = new JFrame("The Maze");
	JButton Play = new JButton("Play");
	JButton Exit = new JButton("Exit");

	int menuWidth = 100;
	int menuHeight = 30;
	int menuY = 450; // miejsce w ktorym jest guzik
	int WIDTH = 500;
	int HEIGHT = 540;

	public void Menu() {

		Menu.setResizable(false);
		Menu.setSize(WIDTH, HEIGHT);
		Menu.setLayout(null);
		Menu.setLocationRelativeTo(null);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Play.setSize(menuWidth, menuHeight);
		Play.setLocation(180, menuY);
		Menu.add(Play);
		// dodac action listenera

		Exit.setSize(menuWidth, menuHeight);
		Exit.setLocation(320, menuY);
		Menu.add(Exit);
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}
}
