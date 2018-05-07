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
    private static Player player;
    private static URL gameIconResourceUrl;
    private static URL grassResourceUrl;
    private static URL bushResourceUrl;
    private static URL playerResourceUrl;

    private static BufferedImage grassImg;
    private static BufferedImage bushImg;
    private static BufferedImage playerImg;

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

        grassImg = ImageIO.read(grass_0);
        bushImg = ImageIO.read(bush_6);
        playerImg = ImageIO.read(hero);

        createClassObjects();
    }

    public static void createClassObjects() {
        player = new Player(playerImg);
        context = new Context(readMap, player, gameIconResourceUrl, grassImg, bushImg);
        run();
    }

    public static void run() {
        new MenuWindow(context);

    }

}