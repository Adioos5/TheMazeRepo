package pl.com.lo.maze.gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonListener implements ActionListener {

    private static final int EXIT_STATUS = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(EXIT_STATUS);
    }
}
