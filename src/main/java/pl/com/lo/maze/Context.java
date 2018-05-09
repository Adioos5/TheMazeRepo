package pl.com.lo.maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Context {

    private GameMechanics gameMechanics;
    private Player player;
    private int[][] tileMap;
    private static final String gameTitle = "The Maze";

    private static final int gameWindowX = 100;
    private static final int gameWindowY = 50;
    private static final int gameWindowWidth = 1260;
    private static final int gameWindowHeight = 828;

    private URL gameIconResourceUrl;
    private BufferedImage spikesImg;
    private BufferedImage coinImg;
    private BufferedImage grassImg;
    private BufferedImage bushImg;
    private BufferedImage menuBackground;
    
    public Context(int[][] tileMap, GameMechanics gameMechanics, Player player, URL resource1, BufferedImage img1,
            BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5) {

        this.tileMap = tileMap;
        this.gameMechanics = gameMechanics;
        this.player = player;
        this.gameIconResourceUrl = resource1;

        spikesImg = img5;
        coinImg = img4;
        grassImg = img1;
        bushImg = img2;
        menuBackground = img3;

    }

    // All getters with variables needed for other classes
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

    // Here other classes can get the grass image read at the beginning of the program
    public BufferedImage getGrassImage() {
        return grassImg;
    }

    // Here other classes can get the bush image read at the beginning of the program
    public BufferedImage getBushImage() {
        return bushImg;
    }

    // Here the player's image is being gotten from class Player
    public BufferedImage getPlayerImage() {
        return player.getPlayerImage();
    }
    
    public BufferedImage getMenuBackgroundImage() {
        return menuBackground;
    }

    public BufferedImage getCoinGif() {return coinImg;}

    public BufferedImage getSpikesImg() {return spikesImg;}

    // Here other classes can get the game icon resource Url created at the beginning of the program
    public URL getGameIconResourceUrl() {
        return gameIconResourceUrl;
    }


    // Here other classes can get a value of the play variable changed in class
    // GameMechanics
    public boolean isPlay() {
        return gameMechanics.isPlay();
    }

    // Here other classes can get playerX changed in class GameMechanics
    public int getPlayerX() {
        return gameMechanics.getPlayerX();
    }

    // Here other classes can get playerY changed in class GameMechanics
    public int getPlayerY() {
        return gameMechanics.getPlayerY();
    }

    // Here other classes can get the tileMap read at the beginning of the program
    public int[][] getTileMap() {
        return tileMap;
    }

}
