package pl.com.lo.maze;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.logging.Logger;

import pl.com.lo.maze.board.Board;
import pl.com.lo.maze.board.BoardRawData;
import pl.com.lo.maze.board.Boards;
import pl.com.lo.maze.board.BoardsLoader;
import pl.com.lo.maze.configuration.GraphicsConfigurationHelper;
import pl.com.lo.maze.context.Context;
import pl.com.lo.maze.graphics.Graphics;
import pl.com.lo.maze.graphics.GraphicsLoader;
import pl.com.lo.maze.gui.menu.MenuWindow;

public class EntryPoint {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = Logger.getLogger(EntryPoint.class.getName());

    public static void main(String[] args) {
        initializeConfiguration();
        Context context = createContext();
        run(context);
    }

    public static Context createContext() {
        Map<Graphics, BufferedImage> graphics = GraphicsLoader.loadGraphics();

        BoardsLoader boardsLoader = new BoardsLoader(graphics);
        Map<Boards, BoardRawData> rawBoardsData = boardsLoader.loadRawBoardsData();
        Map<Boards, Board> loadedBoards = boardsLoader.createBoards(rawBoardsData);

        return new Context(
            rawBoardsData,
            loadedBoards,
            graphics);
    }

    private static void initializeConfiguration() {
        GraphicsConfigurationHelper.estimateMaxWindowSize();
    }

    private static void run(Context context) {
        MenuWindow menuWindow = new MenuWindow(context);
        menuWindow.setVisible(true);
    }

}
