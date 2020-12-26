// erblina jakupi
//
// higo5t
//
// how many shapes contain given point
//
// 2018/10/14 23:56:00
//
// This solution was submitted and prepared by erblina jakupi, higo5t for the
// how many shapes contain given point assignment of the Practical software engineering I. course.
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



package assaigmentproject;



/**

 *

 * @author higo5t

 */



public class shape {

    private String type;
    private int sideLength;
    private int x;
    private int y;


    //public shape () { }
    public shape (String type, int sideLength,int x, int y) {
        this.type = type;
        this.sideLength=sideLength;
        this.x = x;
        this.y=y;
    } 

    /** GETTERS & SETTER
     * @return  */
    public String getType() { return type;  }
    public void setType() { this.type=type; }

    public void setSideLength(int sideLength) { this.sideLength=sideLength; }
    public int getSideLength() { return sideLength; }

    public void setX(){this.x= x; }
    public int getX() { return x; }

    public void setY(int y) { this.y=y; }
    public int getY() { return y; }


    @Override
    public String toString ()
    {
        return getType() + "  "+sideLength+" " + x+"," + y;
    }

  /**
   * formula difference between two points (c,p) = sqrt ( (x1 - x0) ^ 2 + (y1-y0) ^ 2 )
   * for circle check if the difference is less than the radius
   * for triangle check if difference between two given points, 
    finding the altitude for the triangle and doing a condition if difference number is less than the heigth
   * for hexagon find the apothem
     * @param a
     * @param b
     * @return 
    **/
   public boolean check(int a, int b){
       
       if (null != type)switch (type) {
            case "c":
            {
                int difference = (int) Math.sqrt( (Math.pow ( (getX()- a), 2) + Math.pow( ( getY() -b), 2)) );
                return difference < sideLength;
            }  
            case "t":
            {
                int difference = (int) Math.sqrt( (Math.pow ( (getX()- a), 2) + Math.pow( ( getY() -b), 2)) );
                int height= (int) ( (Math.sqrt(3) / 2 * sideLength) /2 );
                return difference < height;
            }
            case "h":
            {
                int difference = (int) Math.sqrt( (Math.pow ( (getX()- a), 2) + Math.pow( ( getY() -b), 2)) );
                int height= (int)  ( (Math.sqrt(6) / 2 * sideLength)  /2 ) ;
                return difference < height;
            }
            case "s":
            {
                int difference = (int) Math.sqrt( (Math.pow ( (getX()- a), 2) + Math.pow( ( getY() -b), 2)) );
                int height= (int)  ( (sideLength * Math.sqrt(2) ) /2 );
                return difference < height;
            }
            default:
                return false;
        }
        return false;
       
   }

}

