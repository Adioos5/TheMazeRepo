package pl.com.lo.maze;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Map;

import pl.com.lo.maze.entity.Player;
import pl.com.lo.maze.entity.Tile;
import pl.com.lo.maze.graphics.Graphics;
import pl.com.lo.maze.logic.GameMechanics;

public class Context {

    private GameMechanics gameMechanics;
    private Player player;
    private int[][] tileMap;
    private static final String gameTitle = "The Maze";

    private static final int gameWindowX = 100;
    private static final int gameWindowY = 50;
    private static final int gameWindowWidth = 1260;
    private static final int gameWindowHeight = 828;

    private BufferedImage gameIconResourceUrl;
    private BufferedImage menuBackground;

    private Tile grass;
    private Tile spikes;
    private Tile bush;
    private Tile coin;
    
    private Map<Graphics, BufferedImage> graphics;

    public Context(int[][] tileMap, GameMechanics gameMechanics, Player player, Tile grass, Tile bush,
            Tile coin, Tile spikes, Map<Graphics, BufferedImage> graphics) {
        this.graphics = graphics;

        this.tileMap = tileMap;
        this.gameMechanics = gameMechanics;
        this.player = player;

        this.spikes = spikes;
        this.grass = grass;
        this.bush = bush;
        this.coin = coin;

        this.gameIconResourceUrl = graphics.get(Graphics.GAME_ICON);
        this.menuBackground = graphics.get(Graphics.MENU_BACKGROUND);

    }

    public String getGameTitle() {
        return gameTitle;
    }

    public int getGamewindowx() {
        return gameWindowX;
    }

    public int getGamewindowy() {
        return gameWindowY;
    }

    public int getGamewindowwidth() {
        return gameWindowWidth;
    }

    public int getGamewindowheight() {
        return gameWindowHeight;
    }

    public BufferedImage getGrassImage() {
        return grass.getTileImage();
    }

    public BufferedImage getBushImage() {
        return bush.getTileImage();
    }

    public BufferedImage getPlayerImage() {
        return player.getPlayerImage();
    }

    public BufferedImage getMenuBackgroundImage() {
        return menuBackground;
    }

    public BufferedImage getCoinImg() {
        return coin.getTileImage();
    }

    public BufferedImage getSpikesImg() {
        return spikes.getTileImage();
    }

    public int getBushType() {
        return bush.getTileType();
    }

    public int getGrassType() {
        return grass.getTileType();
    }

    public int getSpikesType() {
        return spikes.getTileType();
    }

    public int getCoinType() {
        return coin.getTileType();
    }

    public BufferedImage getGameIconResourceUrl() {
        return gameIconResourceUrl;
    }

    public void setGameIconResourceUrl(BufferedImage gameIconResourceUrl) {
        this.gameIconResourceUrl = gameIconResourceUrl;
    }

    public boolean isPlay() {
        return gameMechanics.isPlay();
    }

    public int getPlayerX() {
        return gameMechanics.getPlayerX();
    }

    public int getPlayerY() {
        return gameMechanics.getPlayerY();
    }

    public int[][] getTileMap() {
        return tileMap;
    }

}
