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
    
    public GameFrame(int[][] tileMap, Context context, GameMechanics gameMechanics) {
        this.tileMap = tileMap;
        this.context = context;
        this.gameMechanics = gameMechanics;
    }

    public void initializeGame() {

        tileMapPanel = new TileMapPanel(tileMap, context, gameMechanics);
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
        frame.add(tileMapPanel);

        runGame();
    }

    private void runGame() {
        frame.setVisible(true);

    }

    public void disposeGameWindow() {
        frame.dispose();
    }
}
