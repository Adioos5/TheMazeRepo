package pl.com.lo.maze.board.reader;

import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;

import pl.com.lo.maze.board.Boards;
import pl.com.lo.maze.graphics.Graphics;

public class BoardReaderFactory {

    private Map<Boards, BoardReader> boardsToReaders;
    private BoardReader defaultReader;

    public BoardReaderFactory(Map<Graphics, BufferedImage> graphics) {
        defaultReader = createDefaultBoardBuilder(graphics);
        boardsToReaders = buildBoardsToReaderMap(defaultReader, graphics);
    }

    public BoardReader getBoardReader(Boards boards) {
        return boardsToReaders.getOrDefault(boards, defaultReader);
    }

    private BoardReader createDefaultBoardBuilder(Map<Graphics, BufferedImage> graphics) {
        return new TextBoardReader(graphics);
    }

    private Map<Boards, BoardReader> buildBoardsToReaderMap(
        BoardReader defaultBoardReader,
        Map<Graphics, BufferedImage> graphics) {

        Map<Boards, BoardReader> readersMap = new EnumMap<>(Boards.class);
        readersMap.put(Boards.DEFAULT, defaultBoardReader);
        return readersMap;
    }

}
