/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JButton;


/**
 *
 * @author RunTime Terror
 */
   
public abstract class Sprite extends JButton{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;
    
    public Sprite(int x, int y, int width, int height, Image image) {
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
         this.image = image;
         this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.setContentAreaFilled(true);
        this.setBorderPainted(true);
    }
    
     public boolean collides(Sprite other) {
        Rectangle rect = new Rectangle(x, y, width, height);
        Rectangle otherRect = new Rectangle(other.x, other.y, other.width, other.height);        
        return rect.intersects(otherRect);
    }
    
    /* GETTERS & SETTERS*/
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
   
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
     public void draw(Graphics g){
        g.drawImage(image, x, y, width, height, null);
    }

} 

