package pl.com.lo.maze.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class LoggerConfiguration {

    private static final LogManager LOGGER_MANAGER = LogManager.getLogManager();

    static {
        try {
            InputStream inputStream = ClassLoader.class.getResourceAsStream(Configuration.LOGGER_PROPERTIES_FILE);
            LOGGER_MANAGER.readConfiguration(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private LoggerConfiguration() {
    }
}
