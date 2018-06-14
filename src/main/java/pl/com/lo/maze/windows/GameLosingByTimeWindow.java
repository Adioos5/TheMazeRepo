package pl.com.lo.maze.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.com.lo.maze.graphics.GameLosingByTimeWindowGraphics;
import pl.com.lo.maze.logic.GameLosingWindowMechanics;

public class GameLosingByTimeWindow {

    private JButton bPlayAgain, bExit;
    private BufferedImage img;
   
    private JPanel glwg;
    private static JFrame frame = new JFrame();
    private URL url;
   
    public GameLosingByTimeWindow(BufferedImage img, URL url) throws IOException {
        
        this.img = img;
        this.url = url;
        frame.setBounds(200, 50, 1000, 600);
        frame.setTitle("The Maze");
        frame.setResizable(false);
        bPlayAgain = new JButton("Back to menu");
        bPlayAgain.setBounds(205, 400, 150, 50);
        bPlayAgain.addActionListener(new GameLosingWindowMechanics(bPlayAgain,bExit));
        frame.add(bPlayAgain);
        
        bExit = new JButton("Exit");
        bExit.setBounds(600, 400, 150, 50);
        bExit.addActionListener(new GameLosingWindowMechanics(bPlayAgain,bExit));
        frame.add(bExit);

    }

    public void runGameLosingWindow() {
      
        ImageIcon icn;
        icn = new ImageIcon(url);
        frame.setIconImage(icn.getImage());
        
            glwg = new GameLosingByTimeWindowGraphics(img,"Time's up!");
            frame.add(glwg); 
        
        frame.setVisible(true);
    }
    public void closeWindow() {
        frame.dispose();
    }

   
}
