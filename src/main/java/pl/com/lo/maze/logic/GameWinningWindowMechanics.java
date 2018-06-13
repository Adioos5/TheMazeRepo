package pl.com.lo.maze.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameWinningWindowMechanics implements ActionListener{

    private JButton playAgain;
    private JButton exit;
    
    public GameWinningWindowMechanics(JButton playAgain, JButton exit) {
        this.playAgain = playAgain;
        this.exit = exit;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==playAgain) {
            
        }
        
        if(e.getSource()==exit) {
            System.exit(0);
        }
    }

}
