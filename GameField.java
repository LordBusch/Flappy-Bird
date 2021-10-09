import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    GameField() {
        this.setSize(gui.PANEL_SIZE_X, gui.PANEL_SIZE_Y);
        this.setBackground(Color.white);
        this.setLayout(null);
    }
}