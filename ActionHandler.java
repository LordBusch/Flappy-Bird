import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    GameField GameFieldPanel = new GameField();

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.StartGameMenuButton) {
            gui.frame.remove(gui.StartMenuPanel);
			gui.frame.add(gui.GameSettingsPanel);
            gui.GameSettingsPanel.setVisible(true);
			gui.frame.repaint();

            gui.GameSettingsPanel.add(gui.MainMenuButton);
        }

        if (e.getSource() == gui.ExitButton) {
            System.exit(0);
        }

        if (e.getSource() == gui.StartGameButton) {
            Main.GameActive = true;
            GameField.yposBird = gui.PANEL_SIZE_Y / 2 - 50;

            GameFieldPanel.add(gui.MainMenuButton);
            gui.frame.remove(gui.GameSettingsPanel);
			gui.frame.add(GameFieldPanel);
            GameFieldPanel.setVisible(true);
			gui.frame.repaint();
        }

        if (e.getSource() == gui.MainMenuButton) {
            GameField.CountFalling = 0;
            GameField.CurrentBarrier = 0;
            GameField.CountDrawBarrier = 0;
            Main.GameActive = false;
            gui.GameOverLabel.setVisible(false);

            gui.frame.remove(GameFieldPanel);
            gui.frame.remove(gui.GameSettingsPanel);
			gui.frame.add(gui.StartMenuPanel);
            gui.StartMenuPanel.setVisible(true);
			gui.frame.repaint();
        }
    }
    
}