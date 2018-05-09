package pl.com.lo.maze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TileMapPanel extends JPanel implements ActionListener {

    private int[][] tileMap;

    private static final int tileSize = 16;

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

    public TileMapPanel(int[][] tileMap, Context context, GameMechanics gameMechanics) {

        timeCounter = new TimeCounter();
        this.context = context;
        this.tileMap = context.getTileMap();

        addKeyListener(gameMechanics);

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        playerX = context.getPlayerX();
        playerY = context.getPlayerY();
        play = context.isPlay();

        Graphics g2 = g.create();
        // map
        for (int i = 0; i < tileMap.length; i++) {
            for (int j = 0; j < getMapHeight(tileMap); j++) {
                if (tileMap[i][j] == 0) {
                    bi = context.getGrassImage();

                }
                if (tileMap[i][j] == 6) {

                    bi = context.getBushImage();

                }
                g2.drawImage(bi, i * tileSize, j * tileSize, tileSize, tileSize, null);
            }
        }

        // tip
        if (play != true) {

            g2.setColor(Color.yellow);
            g2.fillRect(32, 180, 6, 120);
            g2.setFont(new Font("serif", Font.TYPE1_FONT, 15));
            g2.drawString("Press any button", 20, 170);

        }

        // timeCounter
        g2.setColor(Color.white);
        g2.setFont(new Font("serif", Font.TYPE1_FONT, 30));

        if (seconds == 0) {
            g2.drawString("Time left: 1:00", 230, 50);
        } else if (seconds > 0 && seconds <= 50) {
            g2.drawString("Time left: 0:" + (60 - seconds), 230, 50);
        } else {
            g2.drawString("Time left: 0:0" + (60 - seconds), 230, 50);
        }

        // player
        biHero = context.getPlayerImage();
        g2.drawImage(biHero, playerX, playerY, 30, 30, null, null);

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
        seconds = timeCounter.getSeconds();
        timer.start();
        repaint();

    }

}
