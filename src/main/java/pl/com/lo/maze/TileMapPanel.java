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

    private File grass_0;
    private File bush_6;
    private File hero;

    private int[][] tileMap;

    private static final int tileSize = 16;

    private int delay = 1;
    private int secounds;
    private boolean play = false;
    private int playerX;
    private int playerY;
    private BufferedImage biHero;
    private BufferedImage bi;
    private TimeCounter timeCounter;
    private Timer timer;
    Context context = new Context();

    public TileMapPanel(int[][] tileMap) {

        URL grassResourceUrl = ClassLoader.getSystemResource("images/Grass_0.png");
        URL bushResourceUrl = ClassLoader.getSystemResource("images/Bush_6.png");
        URL attackResourceUrl = ClassLoader.getSystemResource("images/attack_2.png");
        try {
            grass_0 = new File(grassResourceUrl.toURI());
            bush_6 = new File(bushResourceUrl.toURI());
            hero = new File(attackResourceUrl.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        timeCounter = new TimeCounter();
        this.tileMap = context.getTileMap();

        addKeyListener(context);

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
                    try {
                        bi = ImageIO.read(grass_0);
                    } catch (IOException e) {
                    }
                }
                if (tileMap[i][j] == 6) {
                    try {
                        bi = ImageIO.read(bush_6);
                    } catch (IOException e) {
                    }

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

        if (secounds == 0) {
            g2.drawString("Time left: 1:00", 230, 50);
        } else if (secounds > 0 && secounds <= 50) {
            g2.drawString("Time left: 0:" + (60 - secounds), 230, 50);
        } else {
            g2.drawString("Time left: 0:0" + (60 - secounds), 230, 50);
        }

        // player
        try {
            biHero = ImageIO.read(hero);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        g2.drawImage(biHero, playerX, playerY, 30, 30, null, null);

        g2.dispose();
    }

    private int getMapHeight(int[][] tileMap) {
        return tileMap[0].length;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        secounds = timeCounter.getSecounds();
        timer.start();
        repaint();

    }

}
