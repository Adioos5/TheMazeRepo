package pl.com.lo.maze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuMechanics implements ActionListener {

    private JButton play;
    private JButton exit;
    private JButton settings;
    private int[][] tileMap;

    public MenuMechanics(JButton b1, JButton b2, JButton b3, int[][] tileMap) {
        play = b1;
        exit = b2;
        settings = b3;
        this.tileMap = tileMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MenuWindow mw = new MenuWindow(tileMap);
        GameFrame gf = new GameFrame(tileMap);

        if (e.getSource() == play) {
            gf.initializeGame();
            mw.closeMenu();
        }

        if (e.getSource() == exit) {
            mw.closeMenu();
        }

        if (e.getSource() == settings) {
            // ustawienia
        }

    }

}
