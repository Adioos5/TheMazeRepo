package pl.com.lo.maze;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

public class EntryPoint {
    private static int[][] readMap;
    private static Context context;
    private static URL gameIconResourceUrl;
    private static URL grassResourceUrl;
    private static URL bushResourceUrl;
    private static URL playerResourceUrl;

    private static BufferedImage grass;
    private static BufferedImage bush;
    private static BufferedImage player;

    public static void main(String[] args) throws URISyntaxException, IOException {
        readAllFiles();

    }

    public static void readAllFiles() throws URISyntaxException, IOException {
        TileMapReader tl = new TileMapReader();
        readMap = tl.readMap();

        gameIconResourceUrl = ClassLoader.getSystemResource("images/TheMazeIcon.jpg");
        playerResourceUrl = ClassLoader.getSystemResource("images/attack_2.png");
        bushResourceUrl = ClassLoader.getSystemResource("images/Bush_6.png");
        grassResourceUrl = ClassLoader.getSystemResource("images/Grass_0.png");

        File grass_0 = new File(grassResourceUrl.toURI());
        File bush_6 = new File(bushResourceUrl.toURI());
        File hero = new File(playerResourceUrl.toURI());

        grass = ImageIO.read(grass_0);
        bush = ImageIO.read(bush_6);
        player = ImageIO.read(hero);

        makeAContextClassObject();
    }

    public static void makeAContextClassObject() {
        context = new Context(readMap, gameIconResourceUrl, grass, bush, player);
        run();
    }

    public static void run() {
        new MenuWindow(context);

    }

}