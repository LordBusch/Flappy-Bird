import javax.swing.*;
import java.awt.*;

public class gui {
    public static JFrame frame;
    public static JPanel GameSettingsPanel;
    public static JPanel SettingsPanel;
    public static JButton StartGameMenuButton;
    public static JButton ExitButton;
    public static JButton StartGameButton;
    public static JButton MainMenuButton;
    public static JButton SaveSettingsButton;
    public static JButton RestartApplicationButton;
    public static JLabel GameOverLabel;
    public static JLabel InputXSizeLabel;
    public static JLabel InputYSizeLabel;
    public static JLabel ResolutionLabel;
    public static JLabel HighScoreLabel;
    public static JLabel StartHighScoreLabel;
    public static JRadioButton HitboxRadioButton; 
    public static JButton SettingsButton;
    public static JTextField InputXSizeTextField;
    public static JTextField InputYSizeTextField;

    public static int PANEL_SIZE_X;
    public static int PANEL_SIZE_Y;
    public static int INPUT_PANEL_SIZE_X = PANEL_SIZE_X;
    public static int INPUT_PANEL_SIZE_Y = PANEL_SIZE_Y;
    public static String HighScoreText;
    public static String HighScoreTextBackup = "0";

    public static boolean OverwriteFile;
    

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
        ImageIcon image = new ImageIcon("Flappy Bird Icon.png");
		frame.setIconImage(image.getImage());
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.addKeyListener(khandler);

        //Settings Panel
        SettingsPanel = new JPanel();
        SettingsPanel.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
        SettingsPanel.setBackground(Color.green);
        SettingsPanel.setLayout(null);
        SettingsPanel.setVisible(false);

        InputXSizeTextField = new JTextField();
        InputXSizeTextField.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 3, 300, 100);
        InputXSizeTextField.setBackground(Color.white);
        InputXSizeTextField.setForeground(Color.black);
        InputXSizeTextField.setFont(fontHeading);

        InputXSizeLabel = new JLabel("X");
        InputXSizeLabel.setBounds(PANEL_SIZE_X / 2 - 250, PANEL_SIZE_Y / 3, 100, 100);
        InputXSizeLabel.setBackground(Color.white);
        InputXSizeLabel.setForeground(Color.black);
        InputXSizeLabel.setFont(fontHeading);
        
        InputYSizeTextField = new JTextField();
        InputYSizeTextField.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 2, 300, 100);
        InputYSizeTextField.setBackground(Color.white);
        InputYSizeTextField.setForeground(Color.black);
        InputYSizeTextField.setFont(fontHeading);

        InputYSizeLabel = new JLabel("Y");
        InputYSizeLabel.setBounds(PANEL_SIZE_X / 2 - 250, PANEL_SIZE_Y / 2, 100, 100);
        InputYSizeLabel.setBackground(Color.white);
        InputYSizeLabel.setForeground(Color.black);
        InputYSizeLabel.setFont(fontHeading);

        ResolutionLabel = new JLabel("Resolution");
        ResolutionLabel.setBounds(PANEL_SIZE_X / 2 - 250, PANEL_SIZE_Y / 5, 500, 100);
        ResolutionLabel.setBackground(Color.white);
        ResolutionLabel.setForeground(Color.black);
        ResolutionLabel.setFont(fontHeading);

        SaveSettingsButton = new JButton("Save");
        SaveSettingsButton.setBounds(PANEL_SIZE_X / 2 - PANEL_SIZE_X / 3 - 20, PANEL_SIZE_Y / 3, 400, 100);
        SaveSettingsButton.setBackground(Color.white);
        SaveSettingsButton.setForeground(Color.black);
        SaveSettingsButton.setFont(fontHeading);
        SaveSettingsButton.addActionListener(handler);

        RestartApplicationButton = new JButton("Restart");
        RestartApplicationButton.setBounds(PANEL_SIZE_X / 2 - PANEL_SIZE_X / 3 - 20, PANEL_SIZE_Y / 2, 400, 100);
        RestartApplicationButton.setBackground(Color.white);
        RestartApplicationButton.setForeground(Color.black);
        RestartApplicationButton.setFont(fontHeading);
        RestartApplicationButton.addActionListener(handler);


        //Start Menu Panel

        SettingsButton = new JButton("Settings");
        SettingsButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 2, 300, 150);
        SettingsButton.setBackground(Color.white);
        SettingsButton.setForeground(Color.black);
        SettingsButton.setFont(fontSubheadings);
        SettingsButton.addActionListener(handler);

        StartGameMenuButton = new JButton("Start");
        StartGameMenuButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 2 - PANEL_SIZE_Y / 3, 300, 150);
        StartGameMenuButton.setBackground(Color.white);
        StartGameMenuButton.setForeground(Color.black);
        StartGameMenuButton.setFont(fontHeading);
        StartGameMenuButton.addActionListener(handler);

        ExitButton = new JButton("Exit");
        ExitButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 2 + PANEL_SIZE_Y / 3, 300, 150);
        ExitButton.setBackground(Color.white);
        ExitButton.setForeground(Color.black);
        ExitButton.setFont(fontHeading);
        ExitButton.addActionListener(handler);

        StartHighScoreLabel = new JLabel();
        StartHighScoreLabel.setBounds(0, PANEL_SIZE_Y / 10, 300, 75);
        StartHighScoreLabel.setForeground(Color.red);
        StartHighScoreLabel.setFont(fontHeading);
        StartHighScoreLabel.setText(HighScoreText);

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

        HighScoreLabel = new JLabel("100");
        HighScoreLabel.setForeground(Color.white);
        HighScoreLabel.setBounds(PANEL_SIZE_X / 2 + 125, 0, 300, 75);
        HighScoreLabel.setFont(fontHeading);

        GameOverLabel = new JLabel("Game Over!");
        GameOverLabel.setBackground(Color.green);
        GameOverLabel.setForeground(Color.black);
        GameOverLabel.setBounds(PANEL_SIZE_X / 2 - 300, PANEL_SIZE_Y / 2 - 100, 600, 100);
        GameOverLabel.setFont(fontHeading);

        StartMenuPanel.add(StartGameMenuButton);
        StartMenuPanel.add(ExitButton);
        StartMenuPanel.add(SettingsButton);
        StartMenuPanel.add(StartHighScoreLabel);
        GameSettingsPanel.add(StartGameButton);
        GameSettingsPanel.add(MainMenuButton);
        GameSettingsPanel.add(HitboxRadioButton);
        SettingsPanel.add(MainMenuButton);
        SettingsPanel.add(InputXSizeTextField);
        SettingsPanel.add(InputYSizeTextField);
        SettingsPanel.add(InputXSizeLabel);
        SettingsPanel.add(InputYSizeLabel);
        SettingsPanel.add(ResolutionLabel);
        SettingsPanel.add(SaveSettingsButton);  
        SettingsPanel.add(RestartApplicationButton);

        frame.add(StartMenuPanel);
        frame.repaint();
    }
}
