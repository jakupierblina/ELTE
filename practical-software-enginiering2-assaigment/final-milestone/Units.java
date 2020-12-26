/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;


import GameEngine.Sprite;
import java.awt.Graphics;
import java.awt.Image;



/**
 *
 * @author RunTime Terror
 */


public class Units extends Sprite{
     private double health;
     private int positionX;
     private int positionY;
     private int width;
     private int height;
     private int velocityX;
     private int velocityY;
     private int go_x;
     private int go_y;
     private int timeToCreate;
     private Image image;
     private boolean selected;
     
     
     public Units(int x, int y, int width, int height, Image image){
        super(x, y, width, height, image);
        this.health = 100;
        this.velocityX = 0;
        this.velocityY = 0;
        this.go_x = positionX;
        this.go_y = positionY;
        this.timeToCreate = 2;
        this.setBounds(this.getPositionX(),this.getPositionY(),this.getUWidth(),this.getUHeight());
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
     
     } 
     
     public void move(int a, int b){
          if(this.getPositionX() == a){
                        this.setVelocityX(0);
                        
                    }else{
                        this.setVelocityX(1);
                    }
                    if(this.getPositionY() == b){
                        this.setVelocityY(0);
                        
                    }else{
                        this.setVelocityY(1);
                    }
                    
                   if(a > this.positionX){
                this.setPositionX(this.getPositionX()+this.getVelocityX());
                
                   }
                    if(a < this.positionX){
                this.setPositionX(this.getPositionX()- this.getVelocityX());
                   }
                    
                     if(b > this.positionY){
                this.setPositionY(this.getPositionY()+ this.getVelocityY());
                   }
                    if(b < this.positionY){
                this.setPositionY(this.getPositionY()- this.getVelocityY());
                   }
                    
                this.setBounds(this.getPositionX(),this.getPositionY(),this.getUWidth(),this.getUHeight());
     
     }
     
     
     
     
     
     
     
     
     
     
     
     
     public void draw(Graphics g) {
        g.drawImage(image, positionX, positionY, width, height, null);
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public int getGo_x() {
        return go_x;
    }

    public void setGo_x(int go_x) {
        this.go_x = go_x;
    }

    public int getUWidth() {
      return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getUHeight() {
      return height;
  }
   
    
    public void setHeight(int height) {
        this.height = height;
    }

    public int getGo_y() {
        return go_y;
    }

    public void setGo_y(int go_y) {
        this.go_y = go_y;
    }


    public int getTimeToCreate() {
        return timeToCreate;
    }

    public void setTimeToCreate(int timeToCreate) {
        this.timeToCreate = timeToCreate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public boolean isSelected()
    {
        return selected;
    }
    public void Select()
    {
        selected = true;
    }
    
    
     public boolean isAlive() {
    if(this.health < 1){
       return false;
    }else{
        return true;
    }
    }
    
    
}
