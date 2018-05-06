package pl.com.lo.maze;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuWindow {

	private JButton play;
	private JButton exit;
	private JButton settings;
	private ImageIcon icn;
	private URL systemResource;
	private static JFrame frame = new JFrame(); // This line probably must look like that because the frame doesn't
												// dispose otherwise

	private static final int MENU_WIDTH = 100;
	private static final int MENU_HEIGHT = 30;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 540;

	private int[][] readMap;

	public MenuWindow(int[][] readMap) {
		this.readMap = readMap;

		play = new JButton("Play");
		exit = new JButton("Exit");
		settings = new JButton("Settings");
		systemResource = ClassLoader.getSystemResource("images/TheMazeIcon.jpg");
		icn = new ImageIcon(systemResource);

		initializeMenu();

	}

	private void initializeMenu() {
		play.setSize(MENU_WIDTH, MENU_HEIGHT);
		play.setLocation(50, 150);
		play.addActionListener(new MenuMechanics(play, exit, settings, readMap));

		settings.setLocation(50, 225);
		settings.setSize(MENU_WIDTH, MENU_HEIGHT);
		settings.addActionListener(new MenuMechanics(play, exit, settings, readMap));

		exit.setLocation(50, 300);
		exit.setSize(MENU_WIDTH, MENU_HEIGHT);
		exit.addActionListener(new MenuMechanics(play, exit, settings, readMap));

		frame.add(play);
		frame.add(settings);
		frame.add(exit);

		frame.setIconImage(icn.getImage());
		frame.setResizable(false);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(null);
		frame.setTitle("The Maze");
		frame.setLocation(430, 80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		runMenu();
	}

	private void runMenu() {
		frame.setVisible(true);

	}

	public void closeMenu() {
		frame.dispose();
	}
}