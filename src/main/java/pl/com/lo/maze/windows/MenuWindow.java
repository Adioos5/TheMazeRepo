package pl.com.lo.maze.windows;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pl.com.lo.maze.graphics.MenuGraphics;
import pl.com.lo.maze.importantClasses.Context;
import pl.com.lo.maze.logic.GameMechanics;
import pl.com.lo.maze.logic.MenuMechanics;

public class MenuWindow {

    private JButton play;
    private JButton exit;
    private JButton settings;
    private ImageIcon icn;
    private static JFrame frame = new JFrame(); // This line probably must look like that because the frame doesn't
                                                // dispose otherwise
    private JPanel menuGraphics;
    private Context context;
    private GameMechanics gameMechanics;
    private static final int MENU_WIDTH = 100;
    private static final int MENU_HEIGHT = 30;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 540;

    public MenuWindow(Context context, GameMechanics gameMechanics) {
        // these two lines here are needed to pass these objects to next classes like in
        // line 43, 47 and 51
        this.context = context;
        this.gameMechanics = gameMechanics;

        menuGraphics = new MenuGraphics(context);
        play = new JButton("Play");
        exit = new JButton("Exit");
        settings = new JButton("Help");

        // here object context is used for the first time. Variable icn needed game icon
        // resource url from class Context to set icon image for MenuWindow
        icn = new ImageIcon(context.getGameIconResourceUrl());

        initializeMenu();

    }

    private void initializeMenu() {
        play.setSize(MENU_WIDTH, MENU_HEIGHT);
        play.setLocation(50, 150);

        // we pass objects context and gameMechanics to the MenuMechanics because they
        // will be needed in next classes.
        play.addActionListener(new MenuMechanics(play, exit, settings, context, gameMechanics));

        settings.setLocation(50, 225);
        settings.setSize(MENU_WIDTH, MENU_HEIGHT);
        settings.addActionListener(new MenuMechanics(play, exit, settings, context, gameMechanics));

        exit.setLocation(50, 300);
        exit.setSize(MENU_WIDTH, MENU_HEIGHT);
        exit.addActionListener(new MenuMechanics(play, exit, settings, context, gameMechanics));

        frame.setIconImage(icn.getImage());
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("The Maze");
        frame.setLocation(430, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(play);
        frame.add(settings);
        frame.add(exit);
        frame.add(menuGraphics);

        runMenu();
    }

    public void runMenu() {
        // here the menu window gets visible
        frame.setVisible(true);
 

    }

    public void closeMenu() {
        frame.dispose();
    }
}
