package pl.com.lo.maze.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpWindow extends JFrame implements ActionListener {

    private JButton bBack;

    public HelpWindow() {
        setBounds(200, 50, 500, 500);
        setTitle("Help");
        setLayout(null);
        bBack = new JButton("Back");
        bBack.setBounds(125, 300, 200, 50);
        bBack.addActionListener(this);
        add(bBack);

        JLabel lb1 = new JLabel("Controlls");
        lb1.setBounds(200, 20, 100, 50);
        add(lb1);

        JLabel lb4 = new JLabel("Up - Up Arrow Key");
        lb4.setBounds(100, 100, 500, 50);
        add(lb4);

        JLabel lb5 = new JLabel("Down - Down Arrow Key");
        lb5.setBounds(100, 125, 500, 50);
        add(lb5);

        JLabel lb2 = new JLabel("Left - Left Arrow Key");
        lb2.setBounds(100, 150, 500, 50);
        add(lb2);

        JLabel lb3 = new JLabel("Right - Right Arrow Key");
        lb3.setBounds(100, 175, 500, 50);
        add(lb3);

    }

    public void runHelpWindow() {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == bBack) {
            dispose();

        }
    }
}
