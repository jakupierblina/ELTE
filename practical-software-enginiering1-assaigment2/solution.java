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

public class solution extends base {

    private final int size;
    private player actual;
    private int [][] table;
    private int cntred;
    private int cntblue;
    
    public solution( int size){
        
        this.size=size;
        cntred=0;
        cntblue=0;
        
        actual = player.red;
       
        table = new int[size][size]; 

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                table[i][j] = 0;
            }
        }

    }


    public int step(int row, int column) {

        int cnt=0;
      
        if (table[row][column]< 4){
            table[row][column]++;
            
            if (actual == player.red) {
                actual = player.blue;
            } else {
                actual = player.red;
            }
        } else {
            return table[row][column];
        }
        
        /* 
        * we know that the row represents the row and size is the given size which get's from selected button
        * so if the buttons which is selected hold two of the condition bellow then the condition will hold, 
        * when a button is selected it has i - which is row and j - whichh is column
        * a condition will j holds errors for columns and i - for rows.
     
        * in first time if the button selected is buton[0][0] is the first button from the row and from the column
        * that buttons goes to each condition bellow and check which of them holds, in this case the first conitdion
        * hold because 0 < 2, at this button intexed we add the new value, we need to check if this new value is 
        * the same holds on for the rows as well, we increase the neighbours 
        * 
        */
        if (column < size - 1 && table[row][column + 1]< 4){
            table[row][column + 1]++;
        }

        if (column > 0 && table[row][column - 1]< 4){
            table[row][column - 1]++;
        }
         
        if (row < size -1 && table[row +1 ][column]< 4){
            table[row + 1][column]++;
        }

        if (row > 0 && table[row - 1][column]< 4){
            table[row - 1][column]++;
        }

        return table[row][column];
    }

    public int getValue(int i,int j){
        //i = row
        //j = column
        // if ( 0 <= row &&  row < size && 0 <= column && column < size )
        if (0 <= i && i < size && 0 <= j && j < size)
             return table[i][j];

        return -1;
    }


    public player getActualPlayer() {
        return actual;
    }
    

}

