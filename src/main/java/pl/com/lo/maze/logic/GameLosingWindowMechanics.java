package pl.com.lo.maze.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;

import pl.com.lo.maze.EntryPoint;
import pl.com.lo.maze.windows.GameLosingWindow;

public class GameLosingWindowMechanics implements ActionListener {

    private JButton playAgain;
    private JButton exit;

    public GameLosingWindowMechanics(JButton playAgain, JButton exit) {
        this.playAgain = playAgain;
        this.exit = exit;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playAgain) {
            GameLosingWindow glw = new GameLosingWindow(null,null);
            try {
                EntryPoint.readAllFiles();
                glw.closeWindow();
            } catch (URISyntaxException e1) {

                System.err.println(e1);
            } catch (IOException e1) {
                
                System.err.println(e1);
            }
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

}
