package pl.com.lo.maze;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

    private int[][] tileMap;
    private JPanel panel;
    private ImageIcon icon;
    private Context context;

    public GameFrame(int[][] tileMap, Context context) {
        this.tileMap = tileMap;
        this.context = context;
    }

    public void initializeGame() {
      
        panel = new TileMapPanel(tileMap, context);
        icon = new ImageIcon(context.getGameIconResourceUrl());

        setIconImage(icon.getImage());
        setBounds(100, 50, 630, 414);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("The Maze");
        add(panel);

        runGame();
    }

    private void runGame() {
        setVisible(true);

    }
}
