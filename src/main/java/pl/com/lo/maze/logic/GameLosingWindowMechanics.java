package pl.com.lo.maze.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import pl.com.lo.maze.EntryPoint;
import pl.com.lo.maze.windows.GameLosingBySpikesWindow;
import pl.com.lo.maze.windows.GameLosingBySpikesWindow;
import pl.com.lo.maze.windows.GameLosingBySpikesWindow;
import pl.com.lo.maze.windows.GameLosingBySpikesWindow;
import pl.com.lo.maze.windows.GameLosingBySpikesWindow;
import pl.com.lo.maze.windows.GameLosingByTimeWindow;

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
            GameLosingByTimeWindow glw = null;
            GameLosingBySpikesWindow gsw = new GameLosingBySpikesWindow(null,null);
            try {
                glw = new GameLosingByTimeWindow(null,null);
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            EntryPoint.run();
            gsw.closeWindow();
            glw.closeWindow();
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

}
