/**********************************************************************
 *  N-Body Simulation readme.txt template
 **********************************************************************/


Name: Fei Liu
PennKey: liufei
Recitation: 218
Hours to complete assignment (optional): 7



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

I did not receive any help outside of TA office hours. I
did not collaborate with anyone, and I did not use any
resources beyond the standard course materials.


/**********************************************************************
 *  Problem A:
 * 
 *  Consider the following snippet of Java source code. You can assume
 *  that an int[] input has been created BEFORE this snippet:
 *
 *  boolean b = true;
 *  for(int i = 0; i < input.length - 1; i++){
 *      if(input[i] > input[i + 1]) {
 *           b = false;
 *      }
 *  }
 *  
 *  What is the purpose of the variable b here? That is, if b is true
 *  after this snippet of code, what does it tell us about the array
 *  "input"?                
 **********************************************************************/
/*The purpose of the variable b is to tell us whether the value of the i'th index value of 
 * the array "input" is greater than the value of the next index. If b is true after this
 * snippet of code, then that means that the value of the next index in the array is greater
 * than the value of the current i'th index.



/**********************************************************************
 *  Problem B:
 * 
 *  What are the values of the arrays x and y after executing this code?
 *
 *  int[] x = {5, 4, 8, 7, 1}
 *  int[] y = {1, 2, 3}
 *  x[0]++;
 *  y = x;
 *  y[0]--;
 *  x[1]++;
 *              
 **********************************************************************/
/* x = {5, 5, 8, 7, 1}
 * y = {5, 5, 8, 7, 1}




/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
/* I had finding out how to efficiently code the distances between different planets without
 * brute forcing by declaring tons of variables. Also, it took me a while to figure out that
 * I had to reset the net acceleration to zero after I found the net acceleration for one
 * planet.


/**********************************************************************
 *  If you created your own universe for extra credit, describe it
 *  here and why it is interesting.
 **********************************************************************/



/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

