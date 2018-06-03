package pl.com.lo.maze.configuration;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class GraphicsConfigurationHelper {

    private static final GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

    private GraphicsConfigurationHelper() {
    }

    public static void estimateMaxWindowSize() {
        Rectangle maximumWindowBounds = graphicsEnvironment.getMaximumWindowBounds();
        Configuration.setMaxWindowHeight((int) maximumWindowBounds.getHeight());
        Configuration.setMaxWindowWidth((int) maximumWindowBounds.getWidth());
    }

}
