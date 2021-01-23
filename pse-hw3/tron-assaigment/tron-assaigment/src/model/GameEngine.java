package model;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;


public class GameEngine extends JPanel implements ActionListener, KeyListener {
	 
	//double x,double y,Color color, String tastier, Graphics2D g
        //Player p1;
        //Player p2;
        // Graphics2D g2;
         
        Timer t = new Timer(10,this);
        double x=50,y=200,vely=0,velx=0,x1=800,y1=200;
	
	 public GameEngine() {
		super();
                t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
                
                /*
                 p1 = new Player(50,100,Color.BLACK,"wasd",g2);
                // p1.actionPerformed(e);
                 p1.paint(g2);
                 
                p2 = new Player(800,100,Color.WHITE,"arrow",g2);
                */
	}

    public void paint(Graphics g) 
        {
            super.paintComponents(g);
                //(10, 10, 905, 700);
                
            /* supposed border */
            //g.draw3DRect(20, 20, 850, 600, true);
            
            /* fake playerX */
            Graphics2D g2 =  (Graphics2D)g;
            g2.fill(new Ellipse2D.Double(x,y,20,20));
           // g2.setColor(Color.BLACK);
          
            /* fake playerY */
            Graphics2D q2 =  (Graphics2D)g;
            q2.fill(new Ellipse2D.Double(x1,y1,20,20));
           // q2.setColor(Color.WHITE);
        
        }
	
	public void actionPerformed(ActionEvent e) 
        {
            //905, 700
            repaint();
                
            /* bounds! */
            /*
            if (x<0 || x>870 && x1<0 || x1>870)
               { 
                    x=-x; 
                }    
            if (y<0 || y>600 && y1<0 || y1>600)
                {
                    y=-y;
                }
            */
                
            x+=velx;
            y+=vely;
                
            x1+=velx;
            y1+=vely;
	}
	 
        //moves
        public void up()
        {
	    vely=-1.5;
	    velx=0;
	 }
	public void down()
        {
	    vely=1.5;
	    velx=0;
        }   
	public void left()
        {
	    velx=-1.5;
	    vely=0;  
	}
	public void right()
        {
	    vely=0;
	    velx=1.5;
	}
      
	public void keyPressed(KeyEvent e)
        {
	    int code=e.getKeyCode();
            
            /* arrow type */
                if (code == KeyEvent.VK_UP){ up();  }
                if (code == KeyEvent.VK_DOWN){ down(); }
                if (code == KeyEvent.VK_RIGHT){  right(); }
                if (code == KeyEvent.VK_LEFT){ left(); }
                
                
            /* wasd type */
                if (code == KeyEvent.VK_W){ up(); }
                if (code == KeyEvent.VK_A){ left(); }
                if (code == KeyEvent.VK_D) { right(); }
                if (code == KeyEvent.VK_S) { down(); }
        }
	

    @Override
    public void keyTyped(KeyEvent e) { }
    
    @Override
    public void keyReleased(KeyEvent e) { }
	
	
}
