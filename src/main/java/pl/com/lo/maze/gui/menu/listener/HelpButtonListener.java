package pl.com.lo.maze.gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pl.com.lo.maze.gui.help.HelpDialog;

public class HelpButtonListener implements ActionListener {

    private JFrame menuWindow;
    private HelpDialog helpDialog;

    public HelpButtonListener(JFrame menuWindow) {
        this.menuWindow = menuWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (helpDialog == null) {
            helpDialog = new HelpDialog(menuWindow);
        }
        helpDialog.setVisible(true);
    }
}
