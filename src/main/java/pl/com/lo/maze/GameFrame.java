package pl.com.lo.maze;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame {

    private int[][] tileMap;
    private JPanel tileMapPanel;
    private ImageIcon gameIcon;
    private Context context;
    private GameMechanics gameMechanics;
    private static JFrame frame = new JFrame();
    //XD
    public GameFrame(int[][] tileMap, Context context, GameMechanics gameMechanics) {
        this.tileMap = tileMap;
        this.context = context;
        this.gameMechanics = gameMechanics;
    }

    public void initializeGame() {
        // Here we make an object of class TileMapPanel where we finally pass context
        // and gameMechanics objects for the last time, because they won't be needed in
        // any more classes.
        tileMapPanel = new TileMapPanel(tileMap, context, gameMechanics);

        // Here we initialize game window using the variables got from object context.
        gameIcon = new ImageIcon(context.getGameIconResourceUrl());

        int x = context.getGamewindowx();
        int y = context.getGamewindowy();
        int width = context.getGamewindowwidth();
        int height = context.getGamewindowheight();
        String title = context.getGameTitle();

        frame.setIconImage(gameIcon.getImage());
        frame.setBounds(x, y, width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);

        // Here we add the tileMapPanel on which we paint the maze map, player, and other
        // things to the game window. tileMapPanel object is treated as a JPanel because
        // class TileMapPanel extends JPanel
        frame.add(tileMapPanel);

        runGame();
    }

    private void runGame() {
        // Here the maze map gets visible
        frame.setVisible(true);

    }

    public void disposeGameWindow() {
        frame.dispose();
    }
}
