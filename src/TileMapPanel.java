import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileMapPanel extends JPanel {
    File grass_0 =  new File("Grass_0.png");
    File bush_6 = new File("Bush_6.png");
    private int[][] tileMap;
    private int tileSize = 16;
    public BufferedImage bi;
    public TileMapPanel(int[][] tileMap){
        this.tileMap = tileMap;

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for(int i = 0; i < tileMap.length; i++){
            for (int j = 0; j < getMapHeight(tileMap); j++){
                Graphics g2 = g.create();
                if(tileMap[i][j] == 0){
                    try{
                        bi = ImageIO.read(grass_0);
                    }
                    catch(IOException e){
                    }
                }
                if(tileMap[i][j] == 6) {
                    try {
                        bi = ImageIO.read(bush_6);
                    } catch (IOException e) {
                    }

                }g2.drawImage(bi,i*tileSize, j*tileSize, tileSize, tileSize, null);
                g2.dispose();
            }
        }

    }
    private int getMapHeight(int[][] tileMap) {
        return tileMap[0].length;
    }
}
