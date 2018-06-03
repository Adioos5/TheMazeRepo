package pl.com.lo.maze.tile.builder.impl;

import java.awt.image.BufferedImage;
import java.util.Map;

import pl.com.lo.maze.graphics.Graphics;
import pl.com.lo.maze.tile.Tile;
import pl.com.lo.maze.tile.TileType;
import pl.com.lo.maze.tile.builder.TileBuilder;

public class GrassTileBuilder implements TileBuilder {

    private static final Graphics TILE_GRAPHICS = Graphics.GRASS;
    private static final TileType TILE_TYPE = TileType.GRASS;

    private BufferedImage graphics;

    public GrassTileBuilder(Map<Graphics, BufferedImage> graphics) {
        this.graphics = graphics.get(TILE_GRAPHICS);
    }

    @Override
    public Tile build() {
        return new Tile(graphics, TILE_TYPE);
    }

}
