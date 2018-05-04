import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuGraphics {

	JButton play = new JButton("Play");
	JButton exit = new JButton("Exit");
	JButton settings = new JButton("Settings");

	static JFrame frame = new JFrame();

	int menuWidth = 100;
	int menuHeight = 30;
	int menuY = 450;
	int WIDTH = 500;
	int HEIGHT = 540;
	int[][] readMap;
	
	public MenuGraphics(int[][] readMap) {
		this.readMap = readMap;
	}

	public void runMenu() {

		play.setSize(menuWidth, menuHeight);
		play.setLocation(50, 150);
		play.addActionListener(new MenuMechanics(play, exit, settings, readMap));

		settings.setLocation(50, 225);
		settings.setSize(menuWidth, menuHeight);
		settings.addActionListener(new MenuMechanics(play, exit, settings, readMap));

		exit.setLocation(50, 300);
		exit.setSize(menuWidth, menuHeight);
		exit.addActionListener(new MenuMechanics(play, exit, settings, readMap));

		frame.add(play);
		frame.add(settings);
		frame.add(exit);

		frame.setResizable(false);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(null);
		frame.setTitle("The Maze");
		frame.setLocation(430, 80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}
}
