package pl.com.lo.maze.gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pl.com.lo.maze.Context;

public class PlayButtonListener implements ActionListener {

    private JFrame menuWindow;
    private Context context;

    public PlayButtonListener(JFrame menuWindow, Context context) {
        this.menuWindow = menuWindow;
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
