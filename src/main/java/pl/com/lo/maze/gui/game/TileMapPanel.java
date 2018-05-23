package pl.com.lo.maze.gui.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

import pl.com.lo.maze.Context;
import pl.com.lo.maze.logic.GameMechanics;
import pl.com.lo.maze.logic.TimeCounter;

@SuppressWarnings("serial")
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
                if (tileMap[i][j] == context.getGrassType()) {

                    bi = context.getGrassImage();

                }
                if (tileMap[i][j] == context.getBushType()) {

                    bi = context.getBushImage();

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


        if (play != true) {

            g2.setColor(Color.yellow);
            g2.fillRect(32, 180, 6, 120);
            g2.setFont(new Font("serif", Font.TYPE1_FONT, 15));
            g2.drawString("Press any button", 20, 170);

        }


        g2.setColor(Color.white);
        g2.setFont(new Font("serif", Font.TYPE1_FONT, 50));


        if (seconds == 0) {
            g2.drawString("Time left: 1:00", 460, 80);
        } else if (seconds > 0 && seconds <= 50) {
            g2.drawString("Time left: 0:" + (60 - seconds), 460, 80);
        } else {
            g2.drawString("Time left: 0:0" + (60 - seconds), 460, 80);
        }

        biHero = context.getPlayerImage();
        g2.drawImage(biHero, playerX-16, playerY-16, 32, 32, null, null);

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
