package pl.com.lo.maze.windows;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameLosingWindow extends JFrame implements ActionListener {
	

	private JButton bPlayAgain, bExit;

	public GameLosingWindow() {
		setBounds(200, 50, 1000, 600);
		setTitle("The Maze");
		setResizable(false);
		bPlayAgain = new JButton("Play again");
		bPlayAgain.setBounds(205, 400, 150, 50);
		bPlayAgain.addActionListener(this);
		add(bPlayAgain);

		bExit = new JButton("Exit");
		bExit.setBounds(600, 400, 150, 50);
		bExit.addActionListener(this);
		add(bExit);

	}

	 public void runGameLosingWindow() {
	        setVisible(true);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == bExit) {
			System.exit(0);

		}
	}
}
