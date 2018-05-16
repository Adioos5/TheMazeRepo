package pl.com.lo.maze;

import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage tileImage;
    private int tileType;
    
    public Tile(BufferedImage tileImage, int tileType) {
        this.tileImage = tileImage;
        this.tileType = tileType;
    }

    public BufferedImage getTileImage() {
        return tileImage;
    }

    public int getTileType() {
        return tileType;
    }
    
    
    
}
