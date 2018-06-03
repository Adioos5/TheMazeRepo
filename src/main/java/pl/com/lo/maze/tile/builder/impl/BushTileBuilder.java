package pl.com.lo.maze.tile.builder.impl;

import java.awt.image.BufferedImage;
import java.util.Map;

import pl.com.lo.maze.graphics.Graphics;
import pl.com.lo.maze.tile.Tile;
import pl.com.lo.maze.tile.TileType;
import pl.com.lo.maze.tile.builder.TileBuilder;

public class BushTileBuilder implements TileBuilder {

    private static final Graphics TILE_GRAPHICS = Graphics.BUSH;
    private static final TileType TILE_TYPE = TileType.BUSH;

    private BufferedImage graphics;

    public BushTileBuilder(Map<Graphics, BufferedImage> graphics) {
        this.graphics = graphics.get(TILE_GRAPHICS);
    }

    @Override
    public Tile build() {
        return new Tile(graphics, TILE_TYPE);
    }

}
