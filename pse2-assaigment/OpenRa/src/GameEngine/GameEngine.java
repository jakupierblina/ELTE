/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

import buildings.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import units.*;
/**
 *
 * @author RunTime Terror
 */
public class GameEngine extends JPanel{
        
        private final int FPS = 10;
        private Image background;
        private int levelNum = 0;
        private Level level;
        private String direction = "LEFT";
        private boolean paused = false;
        private Timer newFrameTimer;
        private Player player;
        
   	public GameEngine() {
	     super();
        background = new ImageIcon("data/images/background.jpg").getImage();
        this.getInputMap().put(KeyStroke.getKeyStroke("A"), "pressed left");
        this.getActionMap().put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!"RIGHT".equals(direction))
                {
                    direction="LEFT";
                }
                    
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "pressed right");
        this.getActionMap().put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!"LEFT".equals(direction))
                {
                    direction="RIGHT";
                }
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("S"), "pressed down");
        this.getActionMap().put("pressed down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!"UP".equals(direction))
                {
                    direction="DOWN";
                }
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "pressed up");
        this.getActionMap().put("pressed up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!"DOWN".equals(direction))
                {
                    direction="UP";
                }
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        this.getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paused = !paused;
            }
        });
        restart();
        
        
	}
	/* this method builds buildings*/
	public void build(Buildings b){
	    
	}
	/* this method restarts the game*/
	public void restart(){
            try {
            level = new Level("data/levels/level0" + levelNum + ".txt");
        } catch (IOException ex) {
            Logger.getLogger(GameEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
	    
	} 
	/* moves units*/
	public void move(Units u){
	    
            
	} 
	/*starts game*/
	public void StartGame(){
	    
	} 
	/*boolean method to finish the game*/
	public boolean isOver(){   
               return false;
	} 
        
        @Override
        protected void paintComponent(Graphics grphcs){
        super.paintComponent(grphcs);
        grphcs.drawImage(background, 0, 0, 800, 600, null);
        //level.draw(grphcs);
        //player.draw(grphcs);
    }
       
   
 
   
}
