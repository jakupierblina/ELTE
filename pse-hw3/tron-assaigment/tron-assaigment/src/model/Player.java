/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class Player {
    //Timer t = new Timer(10,this);
    
    double x,y;
    Color color;
    String tastier;
    Graphics2D g;
    double vely=0,velx=0,x1=800,y1=100;
    
    public Player(double x,double y,Color color, String tastier, Graphics2D g){
         
        this.x=x;
        this.y=y;
        this.color=color;
        this.tastier=tastier;
        this.g=g;
    }
    public void setX(double x){
        this.x=x;
    }
    public double getX(){
        return x;
    }
    public void setY(double y){
        this.y=y;
    }
    
    public void setTastier(String tastier){
        this.tastier=tastier;
    }
    
    public String getTastier(){
        return tastier;
    }
    
    public void setColor(Color color){
        this.color=color;
    }
    public Color getColor(){
        return color;
    }
    
    public void setG(Graphics2D g){
     this.g=g;
    }
    public Graphics2D getG(){
        return g;
    }
   
}
