package pl.com.lo.maze.windows;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.com.lo.maze.graphics.GameLosingByTimeWindowGraphics;
import pl.com.lo.maze.logic.GameLosingWindowMechanics;

public class GameLosingBySpikesWindow {
    private JButton bPlayAgain, bExit;
    private BufferedImage img;
   
    private JPanel glwg;
    private static JFrame frame = new JFrame();
    private URL url;
    
    public GameLosingBySpikesWindow(BufferedImage img, URL url) {
        this.url = url;
        this.img = img;
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
        
            glwg = new GameLosingByTimeWindowGraphics(img,"You died");
            frame.add(glwg); 
        
        frame.setVisible(true);
    }
    public void closeWindow() {
        frame.dispose();
    }

}
