package pl.com.lo.maze;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

    private int[][] tileMap;
    private JPanel panel;
    private ImageIcon icon;
    private URL systemResource;

    public GameFrame(int[][] tileMap) {
        this.tileMap = tileMap;
    }

    public void initializeGame() {
        systemResource = ClassLoader.getSystemResource("images/TheMazeIcon.jpg");
        panel = new TileMapPanel(tileMap);
        icon = new ImageIcon(systemResource);

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
