/**********************************************************************
 *  readme.txt template                                                   
 *  Recursive Graphics
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
 *  Describe your artistic creation, and how you went about writing   
 *  a program to produce it. If you used any sources such as the book
 *  or booksite, reference them here. 
 **********************************************************************/
I created a typical snowing scenery. I used a helper function that
    drew a simple snowflake and then used my recursive function
    to draw lots of snowflakes, and they would get smaller and more
    numerous after each recursion, giving an impression of a 3D picture.
    After the recursion is finished, I drew a picture frame around the
    scenery and hung the frame on a wall.
 
 

/**********************************************************************
 *  Consider the following power function for integer inputs:
 *  
 *  public static double pow(int base, int exp) {
 *      boolean negative = exp < 0;
 *      exp = Math.abs(exp);
 *      double product = 1.0;
 *      for (int i = 0; i < exp; i++) {
 *         product *= base;
 *      }
 *      if (negative) {
 *          return 1.0 / product;
 *      } else {
 *          return product;
 *      }
 *   }
 *
 *   Rewrite this as a recursive function. Note that you may need more than one
 *   case for recursing towards the base case.
 *
 **********************************************************************/
    /*public static double pow(int base, int exp) {
    if (exp < 1) {
        return 1;
    }
    return base * pow(base, exp - 1)
}*/





/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
None.



/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
