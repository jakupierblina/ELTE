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



import java.io.FileNotFoundException;

import java.io.IOException;



public class Assaigmentproject {

  
    public static void main(String[] args) throws FileNotFoundException,InvalidInputException, IOException /*throws Exception */{


      solution test = new solution ();

        try {
            test.read();
            test.write();
            test.taskSolution();
            test.clear();
        } catch (InvalidInputException ex) {


       }

    }

}

