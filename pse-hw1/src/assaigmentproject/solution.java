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





import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;



public class solution{

    //list for the shapes

    private final ArrayList<shape> myshapes;


    public solution(){
        myshapes = new ArrayList<>();
    }

    public void read() throws FileNotFoundException, IOException, InvalidInputException{

        try {

             FileReader fl = new FileReader ("in.txt");
             BufferedReader br = new BufferedReader (fl);
            
            try (Scanner sc = new Scanner (br)) {
                
                shape shapes = null;
                int cnt = sc.nextInt();

               System.out.println("Inside the file are " + cnt +" different regular shapes type. ");

                sc.nextLine();
                for (int i=1; i<=cnt; i++){
                // System.out.println("-----");

                String simbol=sc.next();
                //System.out.print(simbol);
                
                String r = sc.next();
                int sideLength=Integer.parseInt(r);
                //System.out.print(radius);

                String givenPoint = sc.next();

                String p[] = givenPoint.split(Pattern.quote(","));
                p = givenPoint.split(",",2);

                int x=Integer.parseInt(p[0]);
                int y=Integer.parseInt(p[1]);
                // System.out.println(x+"\n"+y);

                 switch (simbol) {
                        case "t":
                            shapes = new triangle(sideLength,x,y);
                           //System.out.println("T "+radius+" " +x+","+y);
                            break;
                        case "s":
                            shapes = new square(sideLength,x,y);
                           //  System.out.println("S "+radius+" " +x+","+y);
                            break;
                        case "h":
                            shapes = new hexagon(sideLength,x,y);
                              //System.out.println("H "+radius+" " +x+","+y);
                            break;
                        case "c":
                            shapes = new circle(sideLength,x,y);
                            //System.out.println("C "+radius+" " +x+","+y);
                            break;
                        default:
                            throw new InvalidInputException();
                    }
                 //System.out.println();
                 myshapes.add(shapes);
                }
            }
        }
         catch (InvalidInputException e) {
             System.out.println("Error! FILE NOT FOUND");
            //System.exit(-1);
        }
    }

    public void write(){
        System.out.println("Type of the shapes are defined as: \n\n[h]-hexgaon\n[c]-circle\n[t]-triangle\n[s]-square\n ");
        //System.out.println("Data input from file: ");

        for (shape i: myshapes) {
            System.out.println(" "+ i);
        }
    }
    
    public void taskSolution (){

        int cnt=0;
        Scanner sc = new Scanner (System.in);
        System.out.println("\nGive me point (x,y coordinate:) ");
        String point = sc.nextLine();
        String p[] = point.split(Pattern.quote(","));
        p = point.split(",",2);

        int x=Integer.parseInt(p[0]);
        int y=Integer.parseInt(p[1]);
        for (shape j : myshapes){
            if (j.check(x,y) == true){
                cnt++;
            }
        }
        System.out.println("there are " +cnt + " shapes, which contain the given point");
     }
    
    public void clear(){
          myshapes.clear();
    }
}



