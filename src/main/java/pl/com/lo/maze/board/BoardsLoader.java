package pl.com.lo.maze.board;

import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

import pl.com.lo.maze.board.reader.BoardReader;
import pl.com.lo.maze.board.reader.BoardReaderFactory;
import pl.com.lo.maze.graphics.Graphics;

public class BoardsLoader {

    private BoardReaderFactory boardReaderFactory;

    public BoardsLoader(Map<Graphics, BufferedImage> graphics) {
        boardReaderFactory = new BoardReaderFactory(graphics);
    }

    public Map<Boards, Board> createBoards(Map<Boards, BoardRawData> rawMapsData) {
        Map<Boards, Board> boardsToBoard = new EnumMap<>(Boards.class);
        for (Entry<Boards, BoardRawData> entry : rawMapsData.entrySet()) {
            BoardReader boardReader = boardReaderFactory.getBoardReader(entry.getKey());
            Board board = boardReader.createBoard(entry.getValue());
            boardsToBoard.put(entry.getKey(), board);
        }
        return boardsToBoard;
    }

    public Map<Boards, BoardRawData> loadRawBoardsData() {
        Map<Boards, BoardRawData> boardsToRawBoardData = new EnumMap<>(Boards.class);
        for (Boards boards : Boards.values()) {
            BoardReader boardReader = boardReaderFactory.getBoardReader(boards);
            BoardRawData boardRawData = boardReader.readBoardRawData(boards.getFilePath());
            boardsToRawBoardData.put(boards, boardRawData);
        }
        return boardsToRawBoardData;
    }

}
