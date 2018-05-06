package pl.com.lo.maze;

public class EntryPoint {

    public static void main(String[] args) {

        TileMapReader tl = new TileMapReader();
        int[][] readMap = tl.readMap();

        new MenuWindow(readMap);
    }

}