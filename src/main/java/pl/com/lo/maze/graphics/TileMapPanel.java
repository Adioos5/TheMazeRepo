package pl.com.lo.maze.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import pl.com.lo.maze.importantClasses.Context;
import pl.com.lo.maze.logic.GameMechanics;
import pl.com.lo.maze.logic.TimeCounter;

public class TileMapPanel extends JPanel implements ActionListener {

    private int[][] tileMap;

    private static final int tileSize = 32;

    private int delay = 1;
    private int seconds;
    private boolean play = false;
    private int playerX;
    private int playerY;
    private BufferedImage biHero;
    private BufferedImage bi;
    private TimeCounter timeCounter;
    private Timer timer;
    private Context context;
    private GameMechanics gm;
    private List<Rectangle> listOfRectangles = new ArrayList<>();

    public TileMapPanel(int[][] tileMap, Context context, GameMechanics gameMechanics) {
        // Here we initialize the time counter object which will be needed for
        // TileMapPanel to change the time left to end the game
        timeCounter = new TimeCounter();
        gm = gameMechanics;
        this.context = context;
        // Here we initialize the tileMap using the tileMap read at the beginning of the
        // program kept in object context
        this.tileMap = context.getTileMap();

        // Here we add the keylistener to the TileMapPanel. It is important to use the
        // object from the constructor parameter because this object keeps the beginning
        // player's coordinates from object player created at the beginning of the
        // program
        addKeyListener(gameMechanics);
        // Without these two lines the keylistener doesn't work. I don't know why xD
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Here we initialize the timer object from class Timer. This object sends
        // ActionEvents to the actionPerformed method which causes that this method is
        // doing the code which is inside it. Class Timer keeps two variables in its
        // constructor. int delay - which says how often should the timer object send
        // ActionEvents to the actionPerformed method in milliseconds. ActionListener -
        // here we say to which ActionListener should the timer object send
        // ActionEvents. I wrote "this" because I want it to send ActionEvents to the
        // TileMapPanel(TileMapPanel is also an ActionListener because it implements
        // ActionListener);

        // But why do we need this timer? Well I added it to repaint the TileMapPanel
        // automatically, because of the time counter which is added. Otherwise the
        // TileMapPanel would repaint only when we would make some move by pressing the
        // key and there would be a situation when the time counter shows for example
        // "0:58", and we press the key after a few seconds and then it shows "0:52"

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Here the paint method gets player's coordinates and variables kept in object
        // context
        playerX = context.getPlayerX();
        playerY = context.getPlayerY();
        play = context.isPlay();

        Graphics g2 = g.create();
        // map
        for (int i = 0; i < tileMap.length; i++) {
            for (int j = 0; j < getMapHeight(tileMap); j++) {
                if (tileMap[i][j] == context.getGrassType()) {
                    // Here is the grass image gotten from object context
                    bi = context.getGrassImage();
                }
                
                if (tileMap[i][j] == context.getBushType()) {
                    // Here is the bush image gotten from object context
                    bi = context.getBushImage();
                    Rectangle rect = new Rectangle(i*tileSize,j*tileSize,tileSize,tileSize);
                    listOfRectangles.add(rect);
                    gm.addRectangleToTheList(rect);
                }
                
                if (tileMap[i][j] == context.getCoinType()){
                    bi = context.getCoinImg();
                }
                if (tileMap[i][j] == context.getSpikesType()){
                    bi = context.getSpikesImg();
                }
                g2.drawImage(bi, i * tileSize, j * tileSize, tileSize, tileSize, null);
            }
        }

        for(Rectangle r:listOfRectangles) {
            if(new Rectangle(playerX, playerY, 10, 10).intersects(r)) {
                playerX = 48;
                playerY = 716;
            }
        }
        // Until the player don't press any key, the tip will be showed on screen
        // tip
        if (play != true) {

            g2.setColor(Color.yellow);
            g2.fillRect(40, 580, 6, 120);
            g2.setFont(new Font("serif", Font.TYPE1_FONT, 20));
            g2.drawString("Press any button", 20, 570);

        }

        // timeCounter
        g2.setColor(Color.white);
        g2.setFont(new Font("serif", Font.TYPE1_FONT, 50));

        // Some logic to make the time counter look fine
        if (seconds == 0) {
            g2.drawString("Time left: 1:00", 460, 80);
        } else if (seconds > 0 && seconds <= 50) {
            g2.drawString("Time left: 0:" + (60 - seconds), 460, 80);
        } else {
            g2.drawString("Time left: 0:0" + (60 - seconds), 460, 80);
        }

        // player
        // Here is the player image gotten from object context
        biHero = context.getPlayerImage();
        g2.drawImage(biHero, playerX-16, playerY-16, 32, 32, null, null);

        // help

        /*
         * g2.setColor(Color.white); g2.fillRect(630, 16, 10, 10);
         */
        g2.dispose();
    }

    private int getMapHeight(int[][] tileMap) {
        return tileMap[0].length;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        // The seconds are being changed every time, the thread time counter stops
        // sleeping
        seconds = timeCounter.getSeconds();
        timer.start();
        
        if(seconds == 60) {
            gm.openGameLosingWindow("Time's up!");
        }
        // Here the TileMapPanel is being repainted automatically
        repaint();

    }

}
