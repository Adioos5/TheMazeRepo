package pl.com.lo.maze.graphics;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import pl.com.lo.maze.graphics.reader.GraphicsReader;
import pl.com.lo.maze.graphics.reader.ImageGraphicsReader;
import pl.com.lo.maze.graphics.reader.TileGraphicsReader;

public class GraphicsLoader {

    private static final Map<GraphicsType, GraphicsReader> funcToGraphicsTypes = Map.of(
            GraphicsType.TILE, new TileGraphicsReader(),
            GraphicsType.IMAGE, new ImageGraphicsReader());

    public static Map<Graphics, BufferedImage> loadGraphics() {
        Map<Graphics, BufferedImage> buffImagesToGraphics = new HashMap<>();
        for (Graphics graphics : Graphics.values()) {
            GraphicsReader graphicsReader = funcToGraphicsTypes.get(graphics.getGraphicsType());
            BufferedImage buffImage = graphicsReader.readGraphics(graphics);
            buffImagesToGraphics.put(graphics, buffImage);
        }
        return buffImagesToGraphics;
    }
}
