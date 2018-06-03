package pl.com.lo.maze.tile.builder;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import pl.com.lo.maze.graphics.Graphics;
import pl.com.lo.maze.tile.builder.impl.BushTileBuilder;
import pl.com.lo.maze.tile.builder.impl.GrassTileBuilder;
import pl.com.lo.maze.tile.builder.impl.SpikesTileBuilder;

public class TileBuilderFactory {

    private Map<Character, TileBuilder> charToBuilderMap;
    private TileBuilder defaultTileBuilder;

    public TileBuilderFactory(Map<Graphics, BufferedImage> graphics) {
        defaultTileBuilder = createDefaultTileBuilder(graphics);
        charToBuilderMap = buildCharToBuilderMap(defaultTileBuilder, graphics);
    }

    public TileBuilder getBuilder(Character ch) {
        return charToBuilderMap.getOrDefault(ch, defaultTileBuilder);
    }

    private TileBuilder createDefaultTileBuilder(Map<Graphics, BufferedImage> graphics) {
        return new GrassTileBuilder(graphics);
    }

    private Map<Character, TileBuilder> buildCharToBuilderMap(
        TileBuilder defaultTileBuilder,
        Map<Graphics, BufferedImage> graphics) {

        Map<Character, TileBuilder> buildersMap = new HashMap<>();
        buildersMap.put(' ', defaultTileBuilder);
        buildersMap.put('X', new BushTileBuilder(graphics));
        buildersMap.put('S', new SpikesTileBuilder(graphics));
        return buildersMap;
    }
}
