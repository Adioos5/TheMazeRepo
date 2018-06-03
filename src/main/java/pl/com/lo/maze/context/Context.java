package pl.com.lo.maze.context;

import java.awt.image.BufferedImage;
import java.util.Map;

import pl.com.lo.maze.board.Board;
import pl.com.lo.maze.board.BoardRawData;
import pl.com.lo.maze.board.Boards;
import pl.com.lo.maze.graphics.Graphics;

public class Context {

    private final BufferedImage gameIcon;
    private final BufferedImage menuBackground;
    private final Map<Graphics, BufferedImage> graphics;
    private final Map<Boards, BoardRawData> rawBoardsData;
    private final Map<Boards, Board> loadedBoards;

    public Context(
        Map<Boards, BoardRawData> rawBoardsData,
        Map<Boards, Board> loadedBoards,
        Map<Graphics, BufferedImage> graphics) {

        this.loadedBoards = loadedBoards;
        this.rawBoardsData = rawBoardsData;

        this.graphics = graphics;
        this.gameIcon = graphics.get(Graphics.GAME_ICON);
        this.menuBackground = graphics.get(Graphics.MENU_BACKGROUND);
    }

    public BufferedImage getMenuBackground() {
        return menuBackground;
    }

    public BufferedImage getGameIcon() {
        return gameIcon;
    }

    public Map<Graphics, BufferedImage> getGraphics() {
        return graphics;
    }

    public Map<Boards, BoardRawData> getRawBoardsData() {
        return rawBoardsData;
    }

    public Map<Boards, Board> getLoadedBoards() {
        return loadedBoards;
    }

}
