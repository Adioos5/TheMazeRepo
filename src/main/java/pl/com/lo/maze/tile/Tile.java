package pl.com.lo.maze.tile;

import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage tileImage;
    private TileType tileType;

    public Tile(BufferedImage tileImage, TileType tileType) {
        this.tileImage = tileImage;
        this.tileType = tileType;
    }

    public BufferedImage getTileImage() {
        return tileImage;
    }

    public TileType getTileType() {
        return tileType;
    }

}
