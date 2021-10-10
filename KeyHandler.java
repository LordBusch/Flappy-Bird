import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GameField GameFieldPanel = new GameField();

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        if (Main.GameActive) {
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                
                case KeyEvent.VK_SPACE:
                //GameField.BirdAngle = -20;
                GameField.CountFalling = 0;
                GameField.yposBird = GameField.yposBird - 150;
                new GameField();
                gui.frame.repaint();
                break;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        
    }
    
}
