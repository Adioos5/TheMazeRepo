package pl.com.lo.maze.board.reader;

import pl.com.lo.maze.board.Board;
import pl.com.lo.maze.board.BoardRawData;

public interface BoardReader {

    Board createBoard(BoardRawData boardRawData);

    BoardRawData readBoardRawData(String filePath);

}
