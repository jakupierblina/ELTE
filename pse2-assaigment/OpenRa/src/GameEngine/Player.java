/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;
import Units.*;
//import java.awt.Graphics;
//import java.awt.Image;
import java.util.ArrayList;
import units.Units;

/**
 *
 * @author RunTime Terror
 */
    
public class Player {
    
    private ArrayList<Units> myUnits;
    /* protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;*/
    
    public Player( /*int x, int y, int width, int height, Image image*/ ){
        this.myUnits = new ArrayList<Units>();
        /* this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
         this.image = image;*/
    
    }
    
    public void setMyUnits(ArrayList <Units> myUnits){
        this.myUnits = myUnits;
       
    }
    public ArrayList <Units> getMyUnits(){
        return myUnits;
    }

  
   /* public void draw(Graphics g){
        g.drawImage(image, x, y, width, height, null);
    }*/

    
}
