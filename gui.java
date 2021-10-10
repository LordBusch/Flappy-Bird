import javax.swing.*;
import java.awt.*;

public class gui {
    public static JFrame frame;
    public static JPanel GameSettingsPanel;
    public static JButton StartGameMenuButton;
    public static JButton ExitButton;
    public static JButton StartGameButton;
    public static JButton MainMenuButton;
    public static JLabel GameOverLabel;
    public static JRadioButton HitboxRadioButton; 

    public static final int PANEL_SIZE_X = 1920;
    public static final int PANEL_SIZE_Y = 1080;

    Font fontHeading = new Font("Verdana", Font.PLAIN, PANEL_SIZE_Y / 12);
	Font fontSubheadings = new Font("Verdana", Font.PLAIN, PANEL_SIZE_Y / 30);
    Font fontsizelittle = new Font("Verdana", Font.PLAIN, PANEL_SIZE_Y / 50);

    public gui() {
        StartMenu StartMenuPanel = new StartMenu();

        ActionHandler handler = new ActionHandler();
        KeyHandler khandler = new KeyHandler();

        frame = new JFrame("Flappy Bird");
        frame.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        //frame.setLayout(null);
        frame.setFocusable(true);
        frame.setUndecorated(true);
        ImageIcon image = new ImageIcon("images/Flappy Bird Icon.png");
		frame.setIconImage(image.getImage());
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.addKeyListener(khandler);

        //Start Menu Panel

        StartGameMenuButton = new JButton("Start");
        StartGameMenuButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 2 - PANEL_SIZE_Y / 4, 300, 150);
        StartGameMenuButton.setBackground(Color.white);
        StartGameMenuButton.setForeground(Color.black);
        StartGameMenuButton.setFont(fontHeading);
        StartGameMenuButton.addActionListener(handler);
        StartGameMenuButton.setBorderPainted(true);
        StartGameMenuButton.setVisible(true);

        ExitButton = new JButton("Exit");
        ExitButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 2 + PANEL_SIZE_Y / 4, 300, 150);
        ExitButton.setBackground(Color.white);
        ExitButton.setForeground(Color.black);
        ExitButton.setFont(fontHeading);
        ExitButton.addActionListener(handler);

        //Game Settings Menu

        GameSettingsPanel = new JPanel();
        GameSettingsPanel.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
        GameSettingsPanel.setBackground(Color.green);
        GameSettingsPanel.setLayout(null);
        GameSettingsPanel.setVisible(false);

        StartGameButton = new JButton("Start");
        StartGameButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y - 150, 300, 150);
        StartGameButton.setBackground(Color.white);
        StartGameButton.setForeground(Color.black);
        StartGameButton.setFont(fontHeading);
        StartGameButton.addActionListener(handler);

        HitboxRadioButton = new JRadioButton("Hitbox On/Off");
        HitboxRadioButton.setBounds(PANEL_SIZE_X / 4, PANEL_SIZE_Y / 4, 400, 50);
        HitboxRadioButton.setForeground(Color.black);
        HitboxRadioButton.setBackground(Color.green);
        HitboxRadioButton.setFont(fontSubheadings);
        HitboxRadioButton.addActionListener(handler);

        //GameField Panel

        MainMenuButton = new JButton("Main Menu");
        MainMenuButton.setBounds(PANEL_SIZE_X / 2 - 125, 0, 250, 75);
        MainMenuButton.setBackground(Color.green);
        MainMenuButton.setForeground(Color.black);
        MainMenuButton.setFont(fontSubheadings);
        MainMenuButton.addActionListener(handler);

        GameOverLabel = new JLabel("Game Over!");
        GameOverLabel.setBackground(Color.green);
        GameOverLabel.setForeground(Color.black);
        GameOverLabel.setBounds(PANEL_SIZE_X / 2 - 300, PANEL_SIZE_Y / 2 - 100, 600, 100);
        GameOverLabel.setFont(fontHeading);

        StartMenuPanel.add(StartGameMenuButton);
        StartMenuPanel.add(ExitButton);
        GameSettingsPanel.add(StartGameButton);
        GameSettingsPanel.add(MainMenuButton);
        GameSettingsPanel.add(HitboxRadioButton);

        frame.add(StartMenuPanel);
        frame.repaint();
    }
}
