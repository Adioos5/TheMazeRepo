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

import pl.com.lo.maze.graphics.GameLosingWindowGraphics;
import pl.com.lo.maze.logic.GameLosingWindowMechanics;

public class GameLosingWindow implements ActionListener {

    private JButton bPlayAgain, bExit;
    private BufferedImage img;
    private BufferedImage spikesTrap;
    private JPanel glwg;
    private static JFrame frame = new JFrame();
    private URL url;
    private URL urlSpikesTrap;
    public GameLosingWindow(BufferedImage img, URL url) throws IOException {
        urlSpikesTrap = ClassLoader.getSystemResource("images/SpikesTrap.png");
        try {
            File spikesTrapFile = new File(urlSpikesTrap.toURI());
            spikesTrap = ImageIO.read(spikesTrapFile);
        } catch (URISyntaxException e) {
            System.err.println(e);
        }
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

    public void runGameLosingWindow(int message) {
      
        ImageIcon icn;
        icn = new ImageIcon(url);
        frame.setIconImage(icn.getImage());
        if(message==2) {
            glwg = new GameLosingWindowGraphics(img,"Time's up!");
            frame.add(glwg); 
        } else if (message==1){
            glwg = new GameLosingWindowGraphics(spikesTrap,"You died");
            frame.add(glwg);   
            
        }
        frame.setVisible(true);
    }
    public void closeWindow() {
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == bExit) {
            System.exit(0);

        }
    }
}
