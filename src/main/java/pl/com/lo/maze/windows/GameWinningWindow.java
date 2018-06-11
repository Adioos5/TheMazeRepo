package pl.com.lo.maze.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.com.lo.maze.graphics.GameWinningWindowGraphics;

public class GameWinningWindow extends JFrame implements ActionListener {

    private JButton bPlayAgain, bExit;
    private static JPanel gwwp;
    private static BufferedImage gameWinningWindowBackground;
    private static URL gameWinningWindowBackgroundResourceUrl;

    public GameWinningWindow() throws IOException, URISyntaxException {

        gameWinningWindowBackgroundResourceUrl = ClassLoader.getSystemResource("images/Fireworks.jpeg");
        File someFile = new File(gameWinningWindowBackgroundResourceUrl.toURI());
        gameWinningWindowBackground = ImageIO.read(someFile);

        gwwp = new GameWinningWindowGraphics(gameWinningWindowBackground);
        setBounds(200, 50, 1000, 600);
        setTitle("The Maze");
        setLayout(null);
        bPlayAgain = new JButton("Play again");
        bPlayAgain.setBounds(205, 400, 150, 50);
        bPlayAgain.addActionListener(this);
        add(bPlayAgain);

        bExit = new JButton("Exit");
        bExit.setBounds(600, 400, 150, 50);
        bExit.addActionListener(this);
        add(bExit);

    }

    public void runGameWinningWindow() {
        add(gwwp);
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
