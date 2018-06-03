package pl.com.lo.maze.gui.game;

import java.awt.Graphics;

import javax.swing.JPanel;

import pl.com.lo.maze.board.Board;
import pl.com.lo.maze.board.Boards;
import pl.com.lo.maze.context.Context;

@SuppressWarnings("serial")
public class TileMapPanel extends JPanel {

    private Context context;
    private Board board;

    public TileMapPanel(Context context) {
        this.context = context;
        board = context.getLoadedBoards()
            .get(Boards.DEFAULT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
    }
}
