package GameEngine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author RunTime Terror
 */
public class GameGUI {
    private final JFrame frame;
    private final GameEngine gameArea;
    
    public GameGUI(){
        frame = new JFrame("OpenRA Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu gameMenu = new JMenu("Menu");
        menuBar.add(gameMenu);
        JMenuItem restartMenuItem = new JMenuItem("Restart");
        gameMenu.add(restartMenuItem);
        
        /////// Restart Method Later
           
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override        
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        JButton newGame = new JButton("Start New Game");
        newGame.setBounds(330, 180, 130, 30);  
        newGame.setBackground(Color.black);
        newGame.setForeground(Color.yellow);
        frame.add(newGame);

        
        //action listenner for button one
        newGame.addActionListener(getActionListener(1));
        
        JButton joinGame = new JButton("Join Game");
        joinGame.setBounds(330, 250, 130, 30);
        joinGame.setBackground(Color.black);
        joinGame.setForeground(Color.yellow);
        frame.add(joinGame);

        joinGame.addActionListener(getActionListener(2));

        /* adding the panel of the game to the frame class*/
        gameArea = new GameEngine();
        frame.getContentPane().add(gameArea);
       
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

    }
    
    private ActionListener getActionListener(final int test) {
        return new ActionListener() { 
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                frame.getContentPane().add(gameArea);
                boolean name = JOptionPane.showConfirmDialog(null, "Do you want to play again?") == 
                        JOptionPane.YES_OPTION; 
                
            }
        };
    }
    
}
