package pl.com.lo.maze;

public class EntryPoint {
    private static int[][] readMap;

    public static void main(String[] args) {

        TileMapReader tl = new TileMapReader();
        readMap = tl.readMap();

        new MenuWindow();
    }
    
    public int[][] getTileMap() {
        return readMap;
    }

}