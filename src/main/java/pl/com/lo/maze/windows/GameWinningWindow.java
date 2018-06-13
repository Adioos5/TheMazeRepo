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

import pl.com.lo.maze.graphics.GameWinningWindowGraphics;
import pl.com.lo.maze.importantClasses.Context;
import pl.com.lo.maze.logic.GameWinningWindowMechanics;

public class GameWinningWindow extends JFrame implements ActionListener {

    private JButton bPlayAgain, bExit;
    private JPanel gwwp;

    
    public GameWinningWindow(BufferedImage fireworksBackground){
        
        gwwp = new GameWinningWindowGraphics(fireworksBackground);    
        
        setBounds(200, 50, 1000, 600);
        setTitle("The Maze");
        setResizable(false);
      
        
        bPlayAgain = new JButton("Play again");
        bPlayAgain.setBounds(205, 400, 150, 50);
        bPlayAgain.addActionListener(new GameWinningWindowMechanics(bPlayAgain,bExit));

        bExit = new JButton("Exit");
        bExit.setBounds(600, 400, 150, 50);
        bExit.addActionListener(new GameWinningWindowMechanics(bPlayAgain,bExit));

        add(bPlayAgain);
        add(bExit);
        add(gwwp);
    }

    public void runGameWinningWindow() {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == bExit) {
            System.exit(0);

        }
    }
}
