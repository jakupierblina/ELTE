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



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**

 *

 * @author Admin

 */

public class home extends base {

    private final JButton b1;
    private final JButton b2;
    private final JButton b3;
    private final List<frame> gameWindows = new ArrayList<>();

    public home(){

        JPanel panel1 = new JPanel(new GridLayout(3, 1));
        panel1.setSize(350,350);

        JLabel label =new JLabel("To play Four Game please select a size\n");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setBackground(Color.LIGHT_GRAY);

        panel1.add(label);

        JPanel panel3 = new JPanel(new GridLayout(1, 3));
        panel3.setSize(350,300);

        b1 = new JButton();
        b1.setText("3X3");
        b1.setFont(new Font("Serif", Font.BOLD, 18));
        b1.addActionListener(getActionListener(3));
        panel3.add(b1);

    
        b2 = new JButton();
        b2.setText("5X5");
        b2.setFont(new Font("Serif", Font.BOLD, 18));
        b2.addActionListener(getActionListener(5));
        panel3.add(b2);

        
        b3 = new JButton();
        b3.setText("7x7");
        b3.setFont(new Font("Serif", Font.BOLD, 18));
        b3.addActionListener(getActionListener(7));
        panel3.add(b3);

        
        getContentPane().add(panel1, BorderLayout.NORTH);
        getContentPane().add(panel3, BorderLayout.CENTER);

    }


    private ActionListener getActionListener(final int size) {
        return new ActionListener() { 
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frame tmp = new frame(size, home.this);
                tmp.setVisible(true);
                gameWindows.add(tmp);
            }
        };
    }

    public List<frame> getList() {
        return gameWindows;
    }

    
    @Override
    protected void doUponExit() {
        System.exit(0);
    }

}

