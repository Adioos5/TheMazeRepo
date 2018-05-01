import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameFrame extends JFrame{
	private int[][] tileMap;
	private JPanel panel;
	public GameFrame(int[][] tileMap) {
		this.tileMap = tileMap;
	}

	public void runGame() {

		GameGraphics gg = new GameGraphics();
		panel = new TileMapPanel(tileMap);

		add(panel);
		setBounds(100, 50, 640, 414);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("The Maze");
		setVisible(true);
		add(gg);

	}
}
