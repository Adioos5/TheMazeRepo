package pl.com.lo.maze.common;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

public class ResourceHelper {

    private static final Logger LOGGER = Logger.getLogger(TextFileReader.class.getName());

    public static Optional<URL> getFileUrl(String filePath) {
        Optional<URL> urlOptional = Optional.ofNullable(ClassLoader.getSystemResource(filePath));
        if (!urlOptional.isPresent()) {
            LOGGER.warning("Failed to read URL for filePath: " + filePath);
        }
        return urlOptional;
    }

    public static Optional<Path> getFilePath(String filePath) {
        Optional<URI> uriOptional = getFileUri(filePath);
        return uriOptional.map(ResourceHelper::uriToPath);
    }

    public static Optional<URI> getFileUri(String filePath) {
        Optional<URL> urlOptional = getFileUrl(filePath);
        return urlOptional.map(ResourceHelper::urlToUri);
    }

    private static URI urlToUri(URL url) {
        try {
            return url.toURI();
        } catch (URISyntaxException ex) {
            LOGGER.warning("Couldn't read file URI: " + ex);
        }
        return null;
    }

    private static Path uriToPath(URI uri) {
        File file = new File(uri);
        return file.toPath();
    }
}
