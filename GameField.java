import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;


public class GameField extends JPanel {
    public static int yposBird;
    public static int xposBird = 500;
    public static int CountFalling;
    public static int yposFalling;
    public static int CountBirdUp;
    public static int SecondBirdUp;
    public static int yposBirdUp;
    public static int BirdAngle;
    public static int radiusBird = 50;
    public static int[] xposBarrier = new int [1000000];
    public static int[] yposBarrier = new int [1000000];
    public static int[] widthBarrier = new int [1000000];
    public static int[] heightBarrier = new int [1000000];
    public static int[] xposBarrierdown = new int [1000000];
    public static int[] yposBarrierdown = new int [1000000];
    public static int[] widthBarrierdown = new int [1000000];
    public static int[] heightBarrierdown = new int [1000000];
    public static int CountDrawBarrier;
    public static int CurrentBarrier;
    public static boolean HitboxVisible;
    public static boolean Jumped;

    GameField() {
        this.setSize(gui.PANEL_SIZE_X, gui.PANEL_SIZE_Y);
        this.setBackground(Color.white);
        this.setLayout(null);
    }
    
    public void paintComponent(Graphics g) {
        if (Main.GameActive) {
            DrawBarriers(g);
            DrawBird(g);
            CheckCollision();
        }
    }


    public void DrawBarriers(Graphics g) {
        if (CountDrawBarrier == 200) {
            CountDrawBarrier = 0;
            xposBarrier[CurrentBarrier] = gui.PANEL_SIZE_X;
            yposBarrier[CurrentBarrier] = 0;
            widthBarrier[CurrentBarrier] = 50;
            heightBarrier[CurrentBarrier] = (int)(Math.random() * gui.PANEL_SIZE_Y / 3 + gui.PANEL_SIZE_Y / 3);

            xposBarrierdown[CurrentBarrier] = gui.PANEL_SIZE_X;
            yposBarrierdown[CurrentBarrier] = heightBarrier[CurrentBarrier] + 250;
            widthBarrierdown[CurrentBarrier] = 50;
            heightBarrierdown[CurrentBarrier] = gui.PANEL_SIZE_Y - (heightBarrier[CurrentBarrier] + 250);
        }

        for (int i = 0; i < CurrentBarrier - 1; i++) {
            xposBarrier[i] = xposBarrier[i] - 3;
            xposBarrierdown[i] = xposBarrierdown[i] - 3;
            g.setColor(Color.green);
            g.fillRect(xposBarrier[i], yposBarrier[i], widthBarrier[i], heightBarrier[i]);
            g.fillRect(xposBarrierdown[i], yposBarrierdown[i], widthBarrierdown[i], heightBarrierdown[i]);
        }
        if (CountDrawBarrier == 0) {
            CurrentBarrier++;
            System.out.println(CurrentBarrier + "current barrier");
        }
        CountDrawBarrier++;
    }


    public void DrawBird(Graphics g) {
        if (yposBird > 0 && yposBird < gui.PANEL_SIZE_Y) {
            //-Calculate bird-
            //Load Flappy Bird Image
            ImageIcon SpaceShipIconLeft = new ImageIcon("images/Flappy Bird Icon.png");
            Image SpaceShipImgLeftImage = SpaceShipIconLeft.getImage();
            Image resizedSpaceShipImgLeft = SpaceShipImgLeftImage.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledSpaceShipIconLeft = new ImageIcon(resizedSpaceShipImgLeft);
            //Load AffineTransform to rotate the image
            AffineTransform at = AffineTransform.getTranslateInstance(xposBird, yposBird);
            Image ShipBufferedImage = scaledSpaceShipIconLeft.getImage();
            Graphics2D g2d = (Graphics2D) g;

            if (CountBirdUp > 0) {
                CountBirdUp --;
                SecondBirdUp++;
                yposBird = (int)(yposBird - CountBirdUp / 30);
                if (SecondBirdUp == 4) {
                    SecondBirdUp = 0;
                    BirdAngle = (int)(BirdAngle - 1);
                }
                at.rotate(Math.toRadians(BirdAngle));
                Jumped = true;
                gui.frame.repaint();
            }
            else {
                
                if (Jumped) {
                    //BirdAngle = 0;
                    Jumped = false;
                }
                
                //the bird gets faster and the image turns down
                CountFalling++;
                yposFalling++;
                if (CountFalling == 3) {
                    CountFalling = 0;
                    BirdAngle = BirdAngle + 1;
                }
                yposBird = (int)(yposBird + yposFalling / 30);
                if (BirdAngle > 60) {
                    BirdAngle = 60;
                }
                at.rotate(Math.toRadians(BirdAngle));
                /*
                if (CountFalling <= 75) {
                    BirdAngle = 15;
                    at.rotate(Math.toRadians(BirdAngle));
                    yposBird++;
                }
                if (CountFalling > 75 && CountFalling <= 200) {
                    BirdAngle = 35;
                    at.rotate(Math.toRadians(BirdAngle));
                    yposBird = yposBird + 2;
                }
                if (CountFalling > 200) {
                    BirdAngle = 60;
                    at.rotate(Math.toRadians(BirdAngle));
                    yposBird = yposBird + 4;
                }
                */
            }

            //-draw bird-
            g2d.drawImage(ShipBufferedImage, at, null);
            if (HitboxVisible) {
                g.setColor(Color.red);
                g.drawOval(xposBird, yposBird, 100, 100);
            }

            

            gui.frame.repaint();
        }
        else {
            //Game Over
            GameOver();
        }
    }

    public void CheckCollision() {
        for (int i = 0; i < CurrentBarrier; i++) {
            /*
            if (yposBird + 20 < heightBarrier[i] && xposBird + 70 > xposBarrier[i] && xposBird + 70 < xposBarrier[i] + widthBarrier[i]) {
                GameOver();
                System.out.println("COLLISION");
            }

            if (yposBird + 100 > yposBarrierdown[i] && xposBird + 70 > xposBarrierdown[i] && xposBird + 70 < xposBarrierdown[i] + widthBarrierdown[i]) {
                GameOver();
                System.out.println("COLLISION");
            }
            */
            
            //Calculate 2 Points at the UpBarrier to calculate the collision
            int distanceXUpFirstPoint = ((xposBird + 50) - xposBarrier[i]);
            int distanceYUpFirstPoint = ((yposBird + 50) - heightBarrier[i]);
            int distanceXUpSecondPoint = ((xposBird + 50) - (xposBarrier[i] + 50));
            int distanceYUpSecondPoint = ((yposBird + 50) - heightBarrier[i]);
            int distanceCentersUpFirst = (int)(Math.sqrt((distanceXUpFirstPoint * distanceXUpFirstPoint) + (distanceYUpFirstPoint * distanceYUpFirstPoint)));
            int distanceCentersUpSecond = (int)(Math.sqrt((distanceXUpSecondPoint * distanceXUpSecondPoint) + (distanceYUpSecondPoint * distanceYUpSecondPoint)));

            //Calculate 2 Points at the DownBarrier to calculate the collision
            int distanceXDownFirstPoint = ((xposBird + 50) - xposBarrierdown[i]);
            int distanceYDownFirstPoint = ((yposBird + 50) - yposBarrierdown[i]);
            int distanceXDownSecondPoint = ((xposBird + 50) - (xposBarrier[i] + 50));
            int distanceYDownSecondPoint = ((yposBird + 50) - yposBarrierdown[i]);
            int distanceCentersDownFirst = (int)(Math.sqrt((distanceXDownFirstPoint * distanceXDownFirstPoint) + (distanceYDownFirstPoint * distanceYDownFirstPoint)));
            int distanceCentersDownSecond = (int)(Math.sqrt((distanceXDownSecondPoint * distanceXDownSecondPoint) + (distanceYDownSecondPoint * distanceYDownSecondPoint)));
            
            if (distanceCentersUpFirst < radiusBird) {
                GameOver();
            }
            if (distanceCentersUpSecond < radiusBird) {
                GameOver();
            }
            if (distanceCentersDownFirst < radiusBird) {
                GameOver();
            }
            if (distanceCentersDownSecond < radiusBird) {
                GameOver();
            }
            
            if (xposBird + (radiusBird * 2) == xposBarrier[i] && yposBird + (radiusBird * 2) < heightBarrier[i]) {
                GameOver();
            }
            if (xposBird + (radiusBird * 2) == xposBarrierdown[i] && yposBird > yposBarrierdown[i]) {
                GameOver();
            }
            
        }
    }

    public void GameOver() {
        Main.GameActive = false;
        this.add(gui.GameOverLabel);
        gui.GameOverLabel.setVisible(true);
    }

}