/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildings;

import GameEngine.*;
import java.awt.Image;
import java.awt.Graphics;

/**
 *
 * @author RunTime Terror
 */
public class Buildings extends Sprite{
    
    private int health;
    private int positionX;
    private int positionY;
    private Boolean doesExists;
    private int timeToCreate;
    private int width;
    private int length;
    private Image image;

    public Buildings(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }

    @Override    
    public void draw(Graphics g){
        g.drawImage(image, x, y, width, height, null);
    }
}


