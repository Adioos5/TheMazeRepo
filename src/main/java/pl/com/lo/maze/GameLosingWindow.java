package pl.com.lo.maze;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameLosingWindow extends JFrame implements ActionListener {
	

	private JButton bPlayAgain, bExit;

	public GameLosingWindow() {
		setBounds(200, 50, 1000, 600);
		setTitle("TheMaze");
		setLayout(null);
		bPlayAgain = new JButton("Play again");
		bPlayAgain.setBounds(205, 400, 150, 50);
		bPlayAgain.addActionListener(this);
		add(bPlayAgain);

		bExit = new JButton("Back");
		bExit.setBounds(600, 400, 150, 50);
		bExit.addActionListener(this);
		add(bExit);

	}

	 public void GameLosingWindow() {
	        setVisible(true);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == bExit) {
			dispose();

		}
	}
}
