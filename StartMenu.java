import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class StartMenu extends JPanel{
    private static int yposBird1 = 0;
    private static int xposBird1 = (int)(Math.random() * gui.PANEL_SIZE_X);
    private static int yposBird2 = 0;
    private static int xposBird2 = (int)(Math.random() * gui.PANEL_SIZE_X);
    private static int BirdAngle;

    StartMenu() {
        this.setSize(gui.PANEL_SIZE_X, gui.PANEL_SIZE_Y);
        this.setBackground(Color.green);
        this.setLayout(null);
    }

    public void paintComponent(Graphics g) {
        Birds(g);
    }


    public void Birds(Graphics g) {
        //Background Color
        g.setColor(Color.green);
        g.fillRect(0, 0, gui.PANEL_SIZE_X, gui.PANEL_SIZE_Y);

        if (yposBird1 > gui.PANEL_SIZE_Y | xposBird1 > gui.PANEL_SIZE_X) {
            xposBird1 = (int)(Math.random() * gui.PANEL_SIZE_X);
            yposBird1 = -50;
        }
        if (yposBird2 > gui.PANEL_SIZE_Y | xposBird2 > gui.PANEL_SIZE_X) {
            xposBird2 = (int)(Math.random() * gui.PANEL_SIZE_X);
            yposBird2 = -50;
        }
        
        //Load Flappy Bird Image
        ImageIcon BirdImageIcon = new ImageIcon("Flappy Bird Icon.png");
        Image BirdImage = BirdImageIcon.getImage();
        Image resizedBirdimage = BirdImage.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledBirdImageIcon = new ImageIcon(resizedBirdimage);
        //Load AffineTransform to rotate the image
        AffineTransform at = AffineTransform.getTranslateInstance(xposBird1, yposBird1);
        Image BirdImage1 = scaledBirdImageIcon.getImage();
        AffineTransform at2 = AffineTransform.getTranslateInstance(xposBird2, yposBird2);
        Image BirdImage2 = scaledBirdImageIcon.getImage();
        Graphics2D g2d = (Graphics2D) g;
        
        
        
        BirdAngle = 60;
        at.rotate(Math.toRadians(BirdAngle));
        at2.rotate(Math.toRadians(BirdAngle));
        yposBird2 = yposBird2 + 5;
        xposBird2 = xposBird2 + 3;
        yposBird1 = yposBird1 + 5;
        xposBird1 = xposBird1 + 3;
        
        
        //-draw bird-
        g2d.drawImage(BirdImage1, at, null);
        g2d.drawImage(BirdImage2, at2, null);
        gui.frame.repaint();
    }
}