package pl.com.lo.maze.gui.menu;

import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.com.lo.maze.context.Context;
import pl.com.lo.maze.gui.menu.component.MenuPanel;
import pl.com.lo.maze.gui.menu.listener.ExitButtonListener;
import pl.com.lo.maze.gui.menu.listener.HelpButtonListener;
import pl.com.lo.maze.gui.menu.listener.PlayButtonListener;

@SuppressWarnings("serial")
public class MenuWindow extends JFrame {

    private static final String HELP_BUTTON_TEXT = "Help";
    private static final String EXIT_BUTTON_TEXT = "Exit";
    private static final String PLAY_BUTTON_TEXT = "Play";
    private static final String WINDOW_TITLE = "The Maze";

    private static final int MAX_BUTTON_HEIGHT = 30;
    private static final int PREF_BUTTON_HEIGHT = 30;
    private static final int MIN_BUTTON_HEIGHT = 30;

    private static final int MAX_BUTTON_WIDTH = 150;
    private static final int PREF_BUTTON_WIDTH = 150;
    private static final int MIN_BUTTON_WIDTH = 150;

    private static final int MAX_BUTTON_MARGIN = 50;
    private static final int PREF_BUTTON_MARGIN = 50;

    private static final int PREF_TOP_MARGIN = 50;
    private static final int MAX_TOP_MARGIN = 150;

    private static final int PREF_LEFT_MARGIN = 50;
    private static final int MAX_LEFT_MARGIN = 50;

    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;

    private Image windowIcon;

    private JButton playButton;
    private JButton exitButton;
    private JButton settingsButton;

    private Context context;

    public MenuWindow(Context context) {
        this.context = context;
        this.windowIcon = context.getGameIcon();

        initializeWindow();
    }

    private void initializeWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setIconImage(windowIcon);
        setTitle(WINDOW_TITLE);
        setResizable(false);

        JPanel menuPanel = createComponents();
        configureLayout(menuPanel);
    }

    private JPanel createComponents() {
        playButton = new JButton(PLAY_BUTTON_TEXT);
        playButton.addActionListener(new PlayButtonListener(this, context));

        exitButton = new JButton(EXIT_BUTTON_TEXT);
        exitButton.addActionListener(new ExitButtonListener());

        settingsButton = new JButton(HELP_BUTTON_TEXT);
        settingsButton.addActionListener(new HelpButtonListener(this));

        return new MenuPanel(context);
    }

    private void configureLayout(JPanel panel) {
        GroupLayout layout = new GroupLayout(panel);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addContainerGap(
                    PREF_LEFT_MARGIN,
                    MAX_LEFT_MARGIN)
                .addGroup(
                    layout.createParallelGroup(Alignment.CENTER)
                        .addComponent(
                            playButton,
                            MIN_BUTTON_WIDTH,
                            PREF_BUTTON_WIDTH,
                            MAX_BUTTON_WIDTH)
                        .addComponent(
                            settingsButton,
                            MIN_BUTTON_WIDTH,
                            PREF_BUTTON_WIDTH,
                            MAX_BUTTON_WIDTH)
                        .addComponent(
                            exitButton,
                            MIN_BUTTON_WIDTH,
                            PREF_BUTTON_WIDTH,
                            MAX_BUTTON_WIDTH)));

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addContainerGap(
                    PREF_TOP_MARGIN,
                    MAX_TOP_MARGIN)
                .addComponent(
                    playButton,
                    MIN_BUTTON_HEIGHT,
                    PREF_BUTTON_HEIGHT,
                    MAX_BUTTON_HEIGHT)
                .addContainerGap(
                    PREF_BUTTON_MARGIN,
                    MAX_BUTTON_MARGIN)
                .addComponent(
                    settingsButton,
                    MIN_BUTTON_HEIGHT,
                    PREF_BUTTON_HEIGHT,
                    MAX_BUTTON_HEIGHT)
                .addContainerGap(
                    PREF_BUTTON_MARGIN,
                    MAX_BUTTON_MARGIN)
                .addComponent(
                    exitButton,
                    MIN_BUTTON_HEIGHT,
                    PREF_BUTTON_HEIGHT,
                    MAX_BUTTON_HEIGHT));

        panel.setLayout(layout);
        add(panel);
    }
}
