import javax.swing.JFrame;

public class GameFrame {

	public void run() {
		JFrame frame = new JFrame();
		
		GameGraphics gg = new GameGraphics();
		frame.setBounds(100, 50, 1100, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("The Maze");
		frame.setVisible(true);
		frame.add(gg);

	}
}
