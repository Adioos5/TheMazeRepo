import javax.swing.JFrame;

public class GameFrame {

	public void run() {
		JFrame frame = new JFrame();
		
		GameGraphics gg = new GameGraphics();
		frame.setBounds(100, 50, 1100, 600);
		frame.setResizable(false);
		frame.setTitle("The Maze");
		frame.setVisible(true);
		frame.addMouseListener(new GameMechanics());
		frame.addMouseMotionListener(new GameMechanics());
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);
		frame.add(gg);

	}
}
