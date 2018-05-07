package pl.com.lo.maze;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

    private int[][] tileMap;
    private JPanel tileMapPanel;
    private ImageIcon gameIcon;
    private Context context;

    public GameFrame(int[][] tileMap, Context context) {
        this.tileMap = tileMap;
        this.context = context;
    }

    public void initializeGame() {

        tileMapPanel = new TileMapPanel(tileMap, context);
        gameIcon = new ImageIcon(context.getGameIconResourceUrl());
        
        int x = context.getGamewindowx();
        int y = context.getGamewindowy();
        int width = context.getGamewindowwidth();
        int height = context.getGamewindowheight();
        String title = context.getGameTitle();
        
        setIconImage(gameIcon.getImage());
        setBounds(x, y, width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        add(tileMapPanel);

        runGame();
    }

    private void runGame() {
        setVisible(true);

    }
}
