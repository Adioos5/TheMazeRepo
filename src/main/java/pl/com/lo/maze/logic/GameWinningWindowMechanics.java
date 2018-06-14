package pl.com.lo.maze.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;

import pl.com.lo.maze.EntryPoint;
import pl.com.lo.maze.windows.GameWinningWindow;

public class GameWinningWindowMechanics implements ActionListener {

    private JButton playAgain;
    private JButton exit;

    public GameWinningWindowMechanics(JButton playAgain, JButton exit) {
        this.playAgain = playAgain;
        this.exit = exit;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playAgain) {
            GameWinningWindow gww = new GameWinningWindow(null, null);

            EntryPoint.run();
            gww.closeWindow();

        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

}
