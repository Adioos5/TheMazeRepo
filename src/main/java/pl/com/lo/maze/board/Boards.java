package pl.com.lo.maze.board;

import pl.com.lo.maze.board.BoardType;

public enum Boards {

    DEFAULT("tile_map.txt", BoardType.TEXT);

    private String filePath;
    private BoardType mapType;

    Boards(String filePath, BoardType mapType) {
        this.filePath = filePath;
        this.mapType = mapType;
    }

    public String getFilePath() {
        return filePath;
    }

    public BoardType getMapType() {
        return mapType;
    }

}
