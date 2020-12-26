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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**

 *

 * @author Admin

 */

public class frame extends base {

    

    private final int size;
    private final solution st;
    private final JLabel label;
    private final home tmp;
    private final JButton[][] buttons;
    private int cntred;
    private int cntblue;

    public frame(int size, home tmp){
        
        this.size=size;
        this.tmp=tmp;
        tmp.getList().add(this);

        st = new solution(size);

        buttons = new JButton [size][size];

        cntred=0;
        cntblue=0;

        JPanel top = new JPanel();
        
        label = new JLabel();
        label.setFont(new Font("Serif", Font.BOLD, 20));
        
        updateLabelText();

       
        JButton newGameButton = new JButton();
        newGameButton.setText("New game");
        newGameButton.setFont(new Font("Serif", Font.BOLD, 20));
        newGameButton.addActionListener(e -> newGame());
        newGameButton.setSize(50,50);
        
        top.add(label);
        top.add(newGameButton);

        
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(size, size));

       
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                addButton(gamePanel, i, j);
            }
        }
        
        //to add the content in the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        
    }

  
    //solution to handle the errors for each button
    
    private void addButton(JPanel panel, final int i, final int j) {

        final JButton button = new JButton();
        buttons[i][j] = button;
        
        button.addActionListener(e -> {
            
            //need to count the value for each buttons, and to save them seperately 
            int oldvalue = st.getValue(i, j);
            int oldvalue1 = st.getValue(i,j+1);
            int oldvalue2 = st.getValue(i, j-1);
            int oldvalue3 = st.getValue(i+1, j);
            int oldvalue4 = st.getValue(i-1, j);
            
            //the new value each button and neighbours gets after is selected, 
            int newValue = st.step(i, j);
            int newvalue1 = st.getValue(i,j+1);
            int newvalue2 = st.getValue(i,j-1);
            int newvalue3 = st.getValue(i+1,j);
            int newvalue4 = st.getValue(i-1, j);
            
            /* firstly
            * we know that the j represents the column and size is the given size which get's from selected button
            * so if the buttons which is selected hold two of the condition bellow then the condition will hold, 
            * when a button is selected it has i - which is row and j - whichh is column
            * a condition will j holds errors for columns and i - for rows.
            * 
            *           * * *
            * 
            * in first time if the button selected is buton[0][0] is the first button from the row and from the column
            * that buttons goes to each condition bellow and check which of them holds, in this case the first conitdion
            * hold because 0 < 2, at this button intexed we add the new value, we need to check if this new value is 
            * the same holds on for the rows as well, we increase the neighbours 
            * 
            */
            if (j < size-1 ){
                buttons[i][j+1].setText(Integer.toString(st.getValue(i, j+1)));
                if (newvalue1 >=4  && oldvalue1 <newvalue1 ){
                    if (st.getActualPlayer() == player.red){
                        buttons[i][j+1].setBackground(Color.blue);
                        cntblue++;
                    } else {
                            buttons[i][j+1].setBackground(Color.red);
                            cntred++;
                          }
                    }             
            }
            
            if (j > 0){
                buttons[i][j-1].setText(Integer.toString(st.getValue(i, j-1)));
                if(newvalue2 >= 4 && oldvalue2 < newvalue2){
                    if(st.getActualPlayer() == player.red){
                        buttons[i][j-1].setBackground(Color.blue);
                        cntblue++;
                    } else {
                        buttons[i][j-1].setBackground(Color.red);
                        cntred++;
                     }
                 }
            }
            
            if (i < size -1){
                buttons[i + 1][j].setText(Integer.toString(st.getValue(i+1, j)));
                if (newvalue3 >= 4 && oldvalue3 <newvalue3){
                    if (st.getActualPlayer() == player.red){
                        buttons[i+1][j].setBackground(Color.blue);
                        cntblue++;
                    } else {
                        buttons[i+1][j].setBackground(Color.red);
                        cntred++;
                    }
                }
            } 

            if (i>0){
                buttons[i - 1][j].setText(Integer.toString(st.getValue(i-1, j)));
                if (newvalue4 >=4 && oldvalue4 < newvalue4 ){
                    if (st.getActualPlayer() == player.red){
                        buttons[i-1][j].setBackground(Color.blue);
                        cntblue++;
                    } else {
                        buttons[i-1][j].setBackground(Color.red);
                        cntred++;
                    }
                } 
            }

    
            //convert to string the value of box
            /* 
            * at the selected button i need to write a text, which with text will be integer value
            * if in the selected button the value we are counting is equal to 4, and  and prevous value is less than
            * this new value thenn color that button with the players color.
            * we have created the cntblue and cntred to use them in the find winner method. This variable represents
            * the number of buttons which are colored.
            */
            String tmp = Integer.toString(newValue);
            button.setText(tmp);
            if (newValue == 4  && oldvalue <newValue ){
                if (st.getActualPlayer() == player.red){
                    button.setBackground(Color.blue);
                    cntblue++;
                } else {
                    button.setBackground(Color.red);
                    cntred++;
                }
            } 

            updateLabelText();

           
            //player winner = st.findWinner();
            if (cntblue + cntred == size*size ) {
                showGameOverMessage(findWinner());
            }
        });

        panel.add(button);
    }

     player findWinner() {
        if (cntblue > cntred){
            return player.blue;
        } else {
            return player.red;
        }
    }

    private void showGameOverMessage(player winner) {
        
        JOptionPane.showMessageDialog(this,
                "Game is over. Winner: " + winner.name());
        newGame();
    }

    

    private void newGame() {
        frame newWindow = new frame(size, tmp);
        newWindow.setVisible(true);

        this.dispose();
        tmp.getList().remove(this);
    }

   
    private void updateLabelText() {
        label.setText("Current player: "
                + st.getActualPlayer().name())  ;
    }

    @Override
    protected void doUponExit() {
        super.doUponExit();
        tmp.getList().remove(this);
    }

}

