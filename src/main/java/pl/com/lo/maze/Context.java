package pl.com.lo.maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Context {

    private GameMechanics gameMechanics;
    private Player player;
    private TimeCounter timeCounter;
    private int[][] tileMap;
    private static final String gameTitle = "The Maze";
 
    private static final int gameWindowX = 100;
    private static final int gameWindowY = 50;
    private static final int gameWindowWidth = 630;
    private static final int gameWindowHeight = 414;

    private URL gameIconResourceUrl;
    private BufferedImage grassImg;
    private BufferedImage bushImg;

    public Context(int[][] tileMap,GameMechanics gameMechanics,Player player, URL resource1, BufferedImage img1, BufferedImage img2) {
      
        this.tileMap = tileMap;
        this.gameMechanics = gameMechanics;
        this.player = player;
        this.gameIconResourceUrl = resource1;
    
        grassImg = img1;
        bushImg = img2;
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
        return grassImg;
    }

    public BufferedImage getBushImage() {
        return bushImg;
    }

    public BufferedImage getPlayerImage() {
        return player.getPlayerImage();
    }

    public URL getGameIconResourceUrl() {
        return gameIconResourceUrl;
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
