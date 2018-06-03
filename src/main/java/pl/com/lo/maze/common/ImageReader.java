package pl.com.lo.maze.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import pl.com.lo.maze.configuration.Configuration;
import pl.com.lo.maze.graphics.Graphics;

public class ImageReader {

    private static final Logger LOGGER = Logger.getLogger(ImageReader.class.getName());

    private ImageReader() {
    }

    public static Optional<BufferedImage> readImage(Graphics graphics) {
        try {
            return Optional.ofNullable(readImageFile(getGraphicsUrl(graphics)));
        } catch (IOException e) {
            LOGGER.warning("Couldn't load file: " + graphics.getFileName());
        }
        return Optional.empty();
    }

    private static Optional<URL> getGraphicsUrl(Graphics graphics) {
        return ResourceHelper.getFileUrl(Configuration.IMG_BASE_DIR + graphics.getFileName());
    }

    private static BufferedImage readImageFile(Optional<URL> urlOptional) throws IOException {
        return ImageIO.read(urlOptional.orElse(null));
    }
}
