
package GameEngine;

/**
 *
 * @author RunTime Terror
 */


import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

    

public class Level {
    
    private final int ROCK_WIDTH = 15;
    private final int ROCK_HEIGHT = 15;
    public ArrayList<Rock> rocks;
    
    
    public Level(String levelPath) throws IOException {
        loadLevel(levelPath);
    }


    public void loadLevel(String levelPath) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(levelPath));
        rocks = new ArrayList<>();
        int y = 0;
        String line;
        while ((line = br.readLine()) != null) {
            int x = 0;
            for (char blockType : line.toCharArray()) {
                if (Character.isDigit(blockType)) {
                    Image image = new ImageIcon("data/images/brick0" + blockType + ".png").getImage();
                   rocks.add(new Rock(x * ROCK_WIDTH, y * ROCK_HEIGHT, ROCK_WIDTH, ROCK_HEIGHT, image));
                }
                x++;
            }
            y++;
        }
    }

    void draw(Graphics grphcs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
