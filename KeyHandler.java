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
                GameField.Jumped = false;
                //GameField.BirdAngle = -20;
                GameField.CountFalling = 0;
                GameField.yposFalling = 0;
                GameField.BirdAngle = 0;
                GameField.CountBirdUp = 80;
                gui.frame.repaint();
                break;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        
    }
    
}