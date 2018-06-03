package pl.com.lo.maze.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TextFileReader {

    private static final Logger LOGGER = Logger.getLogger(TextFileReader.class.getName());

    private TextFileReader() {
    }

    public static Stream<String> readAsStream(Optional<Path> path) {
        try {
            return Files.lines(path.orElse(null), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            LOGGER.warning("Couldn't read file: " + ex);
        }
        return Stream.of("");
    }

    public static List<String> readAsListOfStrings(Optional<Path> path) {
        try {
            return Files.readAllLines(path.orElse(null));
        } catch (IOException ex) {
            LOGGER.warning("Couldn't read file: " + ex);
        }
        return new LinkedList<>();
    }
}
