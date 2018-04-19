
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EntryPoint extends JFrame implements ActionListener {
	JButton bStart, bSettings, bExit;
	static GameFrame gf = new GameFrame();

	public EntryPoint() {
		
		setSize(500, 500);
		setTitle("The Maze");
		setLayout(null);
		setResizable(false);
		
		bStart = new JButton("Start");
		bExit = new JButton("Exit");
		bSettings = new JButton("Settings");

		bStart.setBounds(125, 100, 200, 50);
		add(bStart);
		bStart.addActionListener(this);

		bSettings.setBounds(125, 170, 200, 50);
		add(bSettings);
		bSettings.addActionListener(this);

		bExit.setBounds(125, 300, 200, 50);
		add(bExit);
		bExit.addActionListener(this);
	}

	public static void main(String[] args) {
		EntryPoint window = new EntryPoint();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bStart) {
			dispose();
			gf.run();
			// tutaj trzeba wrzuciæ to coœ co w³¹cza gre
		} else if (source == bSettings) {
			// tutaj ustawienia
		} else if (source == bExit) {
			dispose();
		}
	}
}