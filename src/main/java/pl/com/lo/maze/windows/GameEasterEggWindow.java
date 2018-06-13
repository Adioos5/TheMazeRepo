package pl.com.lo.maze.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.com.lo.maze.graphics.GameEasterEggWindowGraphics;


public class GameEasterEggWindow implements ActionListener {

    private JButton bPlayAgain, bExit;
    private BufferedImage img;
    private JPanel gegwg;
    private static JFrame frame = new JFrame();
    private URL url;
    
    public GameEasterEggWindow(BufferedImage img, URL url) {

        this.img = img;
        this.url = url;
        frame.setBounds(200, 50, 768, 1024);
        frame.setTitle("EasterEgg");
        frame.setResizable(false);
        gegwg = new GameEasterEggWindowGraphics(img);
        

    }

    public void runGameEasterEggWindow() {
      
        ImageIcon icn;
        icn = new ImageIcon(url);
        frame.setIconImage(icn.getImage());
        frame.add(gegwg);
        frame.setVisible(true);
    }
    public void closeWindow() {
        frame.dispose();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


    
   
}
