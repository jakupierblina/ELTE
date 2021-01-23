package model;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static sun.java2d.loops.CustomComponent.register;

/**
 *
 * @author bli
 */
public class Game extends JFrame {
    
    private final GameEngine gameArea;

    public Game() {
        setTitle("Tron Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameArea = new GameEngine();
        getContentPane().add(gameArea);
        
        
        setBounds(10, 10, 905, 700);
        setBackground(Color.DARK_GRAY);
        
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        Menu register = new Menu("Register");
        MenuItem reg = new MenuItem("Register");
        
        MenuItem score = new MenuItem("Show best scores");
        MenuItem restart = new MenuItem("Restart game");
        menu.add(score);
        menu.add(restart);
        register.add(reg);
        
        register.addActionListener(e -> register());
        restart.addActionListener(e -> newGame());
        score.addActionListener(e -> bestScore());
        
        menuBar.add(menu);
        menuBar.add(register);
        
       
        setMenuBar(menuBar);
        setTitle("Tron Game");
        
 
        setResizable(false);
        setVisible(true);
            
      
    }      

     private void newGame() {
       GameEngine g = new GameEngine();
        getContentPane().add(g);
        //this.dispose();
        
    }
     
     private void Register()
     {    
        JFrame f = new JFrame();
        
        f.setSize(400, 300);
        f.setTitle("Register");
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel =  new JPanel();
        
        JLabel name = new JLabel();
        name.setText("Name:");
        
         
        JLabel color = new JLabel();
        color.setText("Color");
        
        panel.setLayout(new GridLayout(2, 3));
        panel.add(name);
        panel.add(color);
        
        f.add(panel);
        f.pack();
        f.setVisible(true);
     }

    private void bestScore() {
       //DATABASE
    }
   
     
}