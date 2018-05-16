package pl.com.lo.maze;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

public class EntryPoint {

    // all important files and variables declaration
    private static int[][] readMap;
    private static Context context;
    private static Player player;
    private static GameMechanics gameMechanics;
    private static Tile tile;
    
    private static URL spikesUrl;
    private static URL coinGifUrl;
    private static URL gameIconResourceUrl;
    private static URL grassResourceUrl;
    private static URL bushResourceUrl;
    private static URL playerResourceUrl;
    private static URL menuBackgroundResourceUrl;

    private static BufferedImage spikesImg;
    private static BufferedImage coinImg;
    private static BufferedImage grassImg;
    private static BufferedImage bushImg;
    private static BufferedImage playerImg;
    private static BufferedImage menuBackground;
    
    private static Tile spikes;
    private static Tile coin;
    private static Tile grass;
    private static Tile bush;

    public static void main(String[] args) throws URISyntaxException, IOException {

        // At first the program reads all files to convert them into images.
        readAllFiles();

    }

    public static void readAllFiles() throws URISyntaxException, IOException {
        TileMapReader tl = new TileMapReader();
        // reading map
        readMap = tl.readMap();

        // converting image paths into URL
        spikesUrl = ClassLoader.getSystemResource("images/spikes.png");
        coinGifUrl = ClassLoader.getSystemResource("images/coin1.png");
        gameIconResourceUrl = ClassLoader.getSystemResource("images/TheMazeIcon.jpg");
        playerResourceUrl = ClassLoader.getSystemResource("images/attack_2.png");
        bushResourceUrl = ClassLoader.getSystemResource("images/Bush_6.png");
        grassResourceUrl = ClassLoader.getSystemResource("images/Grass_0.png");
        menuBackgroundResourceUrl = ClassLoader.getSystemResource("images/mazeBackground.jpg");

        // Creating files from images url
        File spike = new File(spikesUrl.toURI());
        File coin1 = new File(coinGifUrl.toURI());
        File grass_0 = new File(grassResourceUrl.toURI());
        File bush_6 = new File(bushResourceUrl.toURI());
        File hero = new File(playerResourceUrl.toURI());
        File menuBackgroundFile = new File(menuBackgroundResourceUrl.toURI());

        // reading files and converting them into images, which we will use in the
        // TileMapPanel
        spikesImg = ImageIO.read(spike);
        coinImg = ImageIO.read(coin1);
        grassImg = ImageIO.read(grass_0);
        bushImg = ImageIO.read(bush_6);
        playerImg = ImageIO.read(hero);
        menuBackground = ImageIO.read(menuBackgroundFile);

        createClassObjects();
    }

    public static void createClassObjects() {

        // here all important class objects are created.
        // Class Tile keeps information about every single tile, like their images or
        // type.
        spikes = new Tile(spikesImg,2);
        coin = new Tile(coinImg, 1);
        grass = new Tile(grassImg,0);
        bush = new Tile(bushImg,6);

        // Class Player keeps player's informations like his image, and
        // coordinates(they will be changed later in class GameMechanics)
        player = new Player(playerImg, 48, 716);

        // Class GameMechanics uses class player to change player's coordinates. This
        // class is also a KeyListener for TileMapPanel. This means, that when we will
        // type anything on the keyboard while the window with this panel is opened,
        // class GameMechanics will read any of these types and do something when we for
        // example press or release some key.
        gameMechanics = new GameMechanics(player);

        // Class Context keeps(should keep) all the important information for other
        // classes. It
        // keeps player's coordinates changed in class GameMechanics,
        // player's image read at the beginning of the program from class Player and
        // tiles images read at the beginning of the program, tileMap(here readMap) read
        // at the beginning of the program
        // and other
        // variables or files needed for other classes.
        // That's why we pass to its constructor so many things. In class TileMapPanel
        // it will much easier to take them because all of them are just in one class
        // object. For example we pass
        // player object, because it keeps player's image which will be used in
        // TileMapPanel. We pass gameMechanics object
        // because it keeps changed player's coordinates from object player which will
        // be used in TileMapPanel. We pass
        // tileMap(here readMap), because then it will be used in class TileMapPanel.
        context = new Context(readMap, gameMechanics, player, gameIconResourceUrl, grass, bush, menuBackground,
                coin, spikes);

        run();
    }

    public static void run() {
        // Here the menu window begins. We pass to the MenuWindow class constructor
        // these two objects, because MenuWindow class will need one variable from
        // object context and because they will be needed later in other classes.
        new MenuWindow(context, gameMechanics);

    }

}
