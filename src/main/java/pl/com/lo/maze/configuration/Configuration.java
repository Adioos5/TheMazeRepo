package pl.com.lo.maze.configuration;

public class Configuration {

    public static final String HELP_CONTENT_FILE = "help_content.txt";
    public static final String LOGGER_PROPERTIES_FILE = "logger.properties";
    public static final String IMG_BASE_DIR = "images/";
    public static final String MAP_BASE_DIR = "maps/";

    public static final int TILE_HEIGHT = 16;
    public static final int TILE_WIDTH = 16;

    private static Integer maxWindowWidth;
    private static Integer maxWindowHeight;

    private Configuration() {
    }

    public static Integer getMaxWindowWidth() {
        return maxWindowWidth;
    }

    public static void setMaxWindowWidth(Integer maxWindowWidth) {
        Configuration.maxWindowWidth = maxWindowWidth;
    }

    public static Integer getMaxWindowHeight() {
        return maxWindowHeight;
    }

    public static void setMaxWindowHeight(Integer maxWindowHeight) {
        Configuration.maxWindowHeight = maxWindowHeight;
    }

}
