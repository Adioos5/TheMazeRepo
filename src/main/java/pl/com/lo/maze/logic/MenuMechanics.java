package pl.com.lo.maze.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.com.lo.maze.importantClasses.Context;
import pl.com.lo.maze.windows.GameFrame;
import pl.com.lo.maze.windows.HelpWindow;
import pl.com.lo.maze.windows.MenuWindow;

public class MenuMechanics implements ActionListener {

    private JButton play;
    private JButton exit;
    private JButton settings;
    private int[][] tileMap;
    private Context context;
    private GameMechanics gameMechanics;

    public MenuMechanics(JButton b1, JButton b2, JButton b3, Context context, GameMechanics gameMechanics) {
        play = b1;
        exit = b2;
        settings = b3;
        this.context = context;
        this.gameMechanics = gameMechanics;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MenuWindow mw = new MenuWindow(context, gameMechanics);
        // Here we make a GameFrame object to which we pass our two important objects.
        // Thanks to that it will be able to use them in next classes.
        GameFrame gf = new GameFrame(tileMap, context, gameMechanics);
        HelpWindow hw = new HelpWindow();
        
        if (e.getSource() == play) {
            gf.initializeGame();
            mw.closeMenu();
        }

        if (e.getSource() == exit) {                               
            System.exit(0);
        }

        if (e.getSource() == settings) {
            hw.runHelpWindow();
        }

    }

}
