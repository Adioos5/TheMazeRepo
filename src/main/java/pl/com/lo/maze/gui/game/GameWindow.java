package pl.com.lo.maze.gui.game;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.com.lo.maze.context.Context;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

    private static final String WINDOW_TITLE = "The Maze";

    private Context context;
    private JPanel tileMapPanel;

    public GameWindow(Context context) {
        this.context = context;
    }

    public void initializeGame() {
        tileMapPanel = new TileMapPanel(context);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(context.getGameIcon());
        // setBounds(x, y, width, height);
        setResizable(false);
        setTitle(WINDOW_TITLE);

        add(tileMapPanel);
    }
}
