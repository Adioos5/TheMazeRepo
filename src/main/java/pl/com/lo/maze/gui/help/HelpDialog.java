package pl.com.lo.maze.gui.help;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import pl.com.lo.maze.common.ResourceHelper;
import pl.com.lo.maze.common.TextFileReader;
import pl.com.lo.maze.configuration.Configuration;

@SuppressWarnings("serial")
public class HelpDialog extends JDialog {

    private static final int MAX_HEIGHT = 640;
    private static final int MAX_WIDTH = 480;
    private static final int MARGIN_TOP = 15;
    private static final int MARGIN_LEFT = 15;
    private static final int MARGIN_RIGHT = 15;
    private static final int MARGIN_BOTTOM = 15;

    private static final String DIALOG_TITLE = "Help";

    private Frame owner;
    private JScrollPane scrollPane;

    public HelpDialog(Frame owner) {
        super(owner);
        this.owner = owner;
        initializeDialog();
    }

    private void initializeDialog() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
        setLocationRelativeTo(owner);
        setTitle(DIALOG_TITLE);
        setResizable(false);

        JPanel panel = createComponents();
        configureLayout(panel);
    }

    private JPanel createComponents() {
        JTextArea helpText = new JTextArea(readHelpContentFromFile());
        helpText.setEditable(false);
        helpText.setLineWrap(true);
        helpText.setBorder(BorderFactory.createEmptyBorder(
            MARGIN_TOP,
            MARGIN_LEFT,
            MARGIN_BOTTOM,
            MARGIN_RIGHT));

        scrollPane = new JScrollPane(helpText);
        scrollPane.setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setMaximumSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));

        return new JPanel();
    }

    private void configureLayout(JPanel panel) {
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        add(panel);
        pack();
    }

    private String readHelpContentFromFile() {
        Optional<Path> pathOptional = ResourceHelper.getFilePath(Configuration.HELP_CONTENT_FILE);
        return TextFileReader.readAsStream(pathOptional)
            .collect(Collectors.joining("\n"));
    }
}
