package pl.com.lo.maze.graphics.reader;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import pl.com.lo.maze.common.ImageReader;
import pl.com.lo.maze.configuration.Configuration;
import pl.com.lo.maze.graphics.Graphics;

public class TileGraphicsReader implements GraphicsReader {

    @Override
    public BufferedImage readGraphics(Graphics graphics) {
        return ImageReader.readImage(graphics)
            .map(this::resize)
            .orElse(getOpacueImage());
    }

    private BufferedImage resize(BufferedImage originalImage) {
        Image scaledInstance = originalImage.getScaledInstance(
            Configuration.TILE_WIDTH,
            Configuration.TILE_HEIGHT,
            Image.SCALE_SMOOTH);

        BufferedImage resizedImage = new BufferedImage(
            Configuration.TILE_WIDTH,
            Configuration.TILE_HEIGHT,
            BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(scaledInstance, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    private BufferedImage getOpacueImage() {
        return new BufferedImage(
            Configuration.TILE_WIDTH,
            Configuration.TILE_HEIGHT,
            BufferedImage.OPAQUE);
    }
}
