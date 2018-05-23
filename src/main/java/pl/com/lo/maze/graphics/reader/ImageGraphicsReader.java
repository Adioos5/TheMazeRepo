package pl.com.lo.maze.graphics.reader;

import java.awt.image.BufferedImage;

import pl.com.lo.maze.common.ImageReader;
import pl.com.lo.maze.graphics.Graphics;

public class ImageGraphicsReader implements GraphicsReader {

    @Override
    public BufferedImage readGraphics(Graphics graphics) {
        return ImageReader.readImage(graphics)
                .orElse(getOpacueImage());
    }

    private BufferedImage getOpacueImage() {
        return new BufferedImage(1, 1, BufferedImage.OPAQUE);
    }

}
