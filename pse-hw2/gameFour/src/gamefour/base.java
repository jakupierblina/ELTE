// erblina jakupi
//
// higo5t
//
// four game
//
// 2018/11/17 17:54:05
//
// This solution was submitted and prepared by erblina jakupi, higo5t for the
// four game assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package gamefour;



/**

 *

 * @author Admin

 */


import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class base extends JFrame {

    public base(){

   
        setSize(400,400);
        setTitle("Four Game");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new FlowLayout() );
        
        addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmation(); 
            }
        });
    }
             
     private void showExitConfirmation() {
         
        int n = JOptionPane.showConfirmDialog(this, "Do you really want to quit?",
                "Exit", JOptionPane.YES_NO_OPTION);
        
            if (n == JOptionPane.YES_OPTION) {
                doUponExit();
            }
    }

    protected void doUponExit() {
        this.dispose();
    }
    
}

