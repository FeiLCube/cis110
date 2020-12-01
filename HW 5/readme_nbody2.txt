/**********************************************************************
 *  N-Body Simulation readme.txt template
 **********************************************************************/


Name: Fei Liu
PennKey: liufei
Recitation: 218
Hours to complete assignment (optional):



/**********************************************************************
 *  Have you enter all help, collaboration, and outside resources
 *  in your help log?  If not, do so now.  (And in future, make sure
 *  you make your help log entries as you go, not at the end!)
 *
 *  If you did not get any help in outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/
    I did not receive any help outside of TA office hours. I did not
    collaborate with anyone, and I did not use any resources beyond
    the standard course materials.




/**********************************************************************
 *  Problem A: 
 *  Consider the class below:
 *
 *  public class Triangle {
 *   public double sideA;
 *      public double sideB;
 *   public double sideC;
 *  
 *   public Triangle(double a, double b, double c) {
 *          sideA = a;
 *          sideB = b;
 *          sideC = c;
 *      }
 *  }
 *  
 *  Write a function in the space below (not in Dr. Java, though you 
 *  can test it there) isEquilateral(Triangle t) that returns true if t 
 *  is an equilateral triangle (that is, all sides are equal). Assume 
 *  this function is NOT in Triangle.java.
 **********************************************************************/
public boolean isEquilateral(Triangle t) {
    if (t.sideA == t.sideB && t.sideB == t.sideC && t.sideA == t.sideC) {
        return true;
    } else {
        return false;
        }
}

/**********************************************************************
 *  Problem B: 
 *  Compare this approach to the approach in HW2. Why is it better to 
 *  decompose a problem using objects?
 **********************************************************************/
It is easier to read, and your train of thought is better organized
    and understood. It is also easier to debug and to alter. Also,
    objects can have private fields if you wish for them to not be altered.











/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
None.



/**********************************************************************
 *  All the questions below are optional, but we value your feedback.                                  
 **********************************************************************/
/**********************************************************************
 *  Difficulty - Very Difficult, Somewhat Difficult, Somewhat Easy, 
 *  Very Easy (you may add comments alongside your rating).                                   
 **********************************************************************/
Somewhat Difficult.






/**********************************************************************
 *  Quality of the Write-up - Very Good, Somewhat Good, Somewhat Bad, 
 *  Very Bad (you may add comments alongside your rating).                                 
 **********************************************************************/
Somewhat good





/**********************************************************************
 *  Quality of the Submission Tests: Very Good, Somewhat Good, 
 *  Somewhat Bad, Very Bad (you may add comments alongside your rating).                                
 **********************************************************************/
Very good.





/**********************************************************************
 *  Did this assignment help you understand objects better? Helped 
 *  significantly, helped somewhat, barely helped, did not help at all.                                  
 **********************************************************************/
Helped significantly.



