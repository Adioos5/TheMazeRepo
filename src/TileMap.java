import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TileMap {
	private static final String map = "tile_map.txt";

	public int[][] readMap() {
		List<String> lines = readFile();
		return convertListToArray(lines);
	}

	private List<String> readFile() {
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(Paths.get(map));
		} catch (IOException e) {
			System.err.println(e);
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
