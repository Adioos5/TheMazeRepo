package pl.com.lo.maze;

public class EntryPoint {

    public static void main(String[] args) {

        TileMap tl = new TileMap();
        int[][] readMap = tl.readMap();

        MenuGraphics mg = new MenuGraphics(readMap);
        mg.runMenu();
    }

}