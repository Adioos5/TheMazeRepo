package pl.com.lo.maze.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TextFileReader {

    private static final Logger LOGGER = Logger.getLogger(TextFileReader.class.getName());

    public static Stream<String> readFile(Optional<Path> path) {
        try {
            return Files.lines(path.get(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            LOGGER.warning("Couldn't read file: " + ex);
        }
        return Stream.of("");
    }
}
