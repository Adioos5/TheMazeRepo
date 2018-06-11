package pl.com.lo.maze.logic;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TileMapReader {

    private static final String MAP_FILE = "tile_map.txt";

    public int[][] readMap() {
        List<String> lines = readFile();
        return convertListToArray(lines);
    }

    private List<String> readFile() {
        List<String> lines = new ArrayList<>();
        URL mapFileUrl = ClassLoader.getSystemResource(MAP_FILE);

        try {
            lines = Files.readAllLines(Paths.get(mapFileUrl.toURI()));
        } catch (IOException e) {
            System.err.println(e);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private int[][] convertListToArray(List<String> lines) {
        int maxSize = getMaxLineSize(lines);
        int map[][] = new int[maxSize][lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            char[] charArray = lines.get(i).toCharArray();
            for (int k = 0; k < maxSize; k++) {
                if (k >= charArray.length) {
                    map[k][i] = 6;
                } else {
                    map[k][i] = Character.getNumericValue(charArray[k]);
                }
            }
        }
        return map;
    }

    private int getMaxLineSize(List<String> lines) {
        int maxSize = 0;

        for (String line : lines) {
            if (line.length() > maxSize) {
                maxSize = line.length();
            }
        }

        return maxSize;
    }
}
