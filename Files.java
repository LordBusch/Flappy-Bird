import java.io.*;

public class Files {

    private boolean PanelXY;

    Files() {

        HighScoreWriter();

        if (gui.OverwriteFile) {
            SizeWriter();
             gui.OverwriteFile = false;
        }
        
        SizeReader();
        HighScoreReader();
        
    }

    //Create size file

    public void SizeWriter() {

        try {
        BufferedWriter bw = new BufferedWriter(
            new FileWriter(("PanelSize.txt")));
            if (gui.INPUT_PANEL_SIZE_X == 0 || gui.INPUT_PANEL_SIZE_Y == 0) {
                gui.INPUT_PANEL_SIZE_X = 1920;
                gui.INPUT_PANEL_SIZE_Y = 1080;
            }
            bw.write(gui.INPUT_PANEL_SIZE_X + "\n"); //Size X
            bw.write(gui.INPUT_PANEL_SIZE_Y + "\n"); //Size Y
            bw.close();
        }catch(Exception ex) {
            return;
        }
    }   

    //Read size file

    public void SizeReader() {
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("PanelSize.txt"));
                String s;
                while((s = br.readLine()) != null) {
                    System.out.println(s);
                    if (PanelXY == false) {
                        gui.PANEL_SIZE_X = Integer.parseInt(s);
                        PanelXY = true;
                    }
                    else {
                        gui.PANEL_SIZE_Y = Integer.parseInt(s);
                    }
                }
                br.close();
        } catch(Exception ex) {
            return;
        }
    }

    //Create File for HighScore

    public void HighScoreWriter() {

        try {
        BufferedWriter bw = new BufferedWriter(
            new FileWriter(("HighScore.txt")));
            bw.write(GameField.ActiveHighScoreCount + "\n"); //HighScore
            bw.close();
        }catch(Exception ex) {
            return;
        }
    }   

    //Read HighScore file

    public void HighScoreReader() {
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("HighScore.txt"));
                String s;
                while((s = br.readLine()) != null) {
                    System.out.println(s + "HIGHSCORE");
                    gui.HighScoreTextBackup = s;
                    gui.HighScoreText = s;
                    gui.StartHighScoreLabel.setText(s);
                }
                br.close();
        } catch(Exception ex) {
            return;
        }
    }

}