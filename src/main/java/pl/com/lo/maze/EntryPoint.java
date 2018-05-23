package pl.com.lo.maze;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import pl.com.lo.maze.common.ImageReader;
import pl.com.lo.maze.common.TileMapReader;
import pl.com.lo.maze.entity.Player;
import pl.com.lo.maze.entity.Tile;
import pl.com.lo.maze.graphics.Graphics;
import pl.com.lo.maze.graphics.GraphicsLoader;
import pl.com.lo.maze.gui.menu.MenuWindow;
import pl.com.lo.maze.logic.GameMechanics;

public class EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(EntryPoint.class.getName());

    private static int[][] readMap;
    private static Context context;
    private static Player player;
    private static GameMechanics gameMechanics;

    private static Map<Graphics, BufferedImage> graphics;

    private static Tile spikes;
    private static Tile coin;
    private static Tile grass;
    private static Tile bush;

    public static void main(String[] args) throws URISyntaxException, IOException {
        readAllFiles();
    }

    public static void readAllFiles() throws URISyntaxException, IOException {
        TileMapReader tl = new TileMapReader();

        readMap = tl.readMap();

        graphics = GraphicsLoader.loadGraphics();

        createClassObjects();
    }

    public static void createClassObjects() {

        spikes = new Tile(graphics.get(Graphics.SPIKES), 2);
        coin = new Tile(graphics.get(Graphics.COIN), 1);
        grass = new Tile(graphics.get(Graphics.GRASS), 0);
        bush = new Tile(graphics.get(Graphics.BUSH), 6);
        player = new Player(graphics.get(Graphics.PLAYER), 48, 716);
        gameMechanics = new GameMechanics(player);

        context = new Context(
            readMap,
            gameMechanics,
            player,
            grass,
            bush,
            coin,
            spikes,
            graphics);

        run();
    }

    public static void run() {
        MenuWindow menuWindow = new MenuWindow(context, gameMechanics);
        menuWindow.setVisible(true);
    }

}
