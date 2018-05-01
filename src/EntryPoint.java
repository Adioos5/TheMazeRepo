

import java.util.Arrays;


public class EntryPoint {
	
	public static void main(String[] args) {

		TileMap tl = new TileMap();
		int[][] readMap = tl.readMap();
		System.out.println(Arrays.deepToString(readMap));

		MenuGraphics mg = new MenuGraphics(readMap);
		mg.runMenu();
	}

}