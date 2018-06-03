package pl.com.lo.maze.board;

import java.util.List;

import pl.com.lo.maze.tile.Tile;

public class Board {

    private List<Tile> tiles;
    private int width;
    private int height;

    public Board(int width, int height, List<Tile> tiles) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
