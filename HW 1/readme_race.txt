/**********************************************************************
 *  readme template
 *  HW1: Conditionals and Loops
 **********************************************************************/

Name:Fei Liu
PennKey:liufei
Recitation:218
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
I did not receive any help outside of TA office hours. I did not collaborate wth anyone, and 
    I did not use any resources beyond the standard course materials.




/**********************************************************************
 *  Problem A:  What is the output of the following code?
 * 
 *     for (int i = 1; i < 8; i = i * 2) { 
 *         for (int j = 0; j < i; j++) {
 *             System.out.print(i * j); 
 *         } 
 *         System.out.println(); 
 *     }
 * 
 *  You should work your answer out by hand first.  Once you've
 *  traced through the code manually, you can confirm it using DrJava.
 *********************************************************************/
0, 0, 2, 0, 4, 8, 12





/**********************************************************************
 *  Problem B:  Translate the following while loop into an equivalent 
 *  for loop, without changing the initial value of n, so that the same
 *  values print.  Once you have done the conversion by hand, verify 
 *  your answer using DrJava.
 * 
 *     int n = 1024; 
 *     while (n > 0) { 
 *         n /= 2;
 *         System.out.println(n); 
 *     } 
 *********************************************************************/
for (int n = 1024; n > 0; n = n / 2) {
    System.out.println(n);
}




/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
Took me a while to figure out how to resolve the problem of the pennants in the race program
    not moving foward, but rather staying at the starting position and a pixel to the right.
Figuring out where the PennDraw.hadNextKeyTyped() and PennDraw.nextKeyTyped() functions went
    to get the stampsketch program to work properly.



/**********************************************************************
 *  If you completed the extra credit or added any additional features,
 *  provide DETAILED and CLEAR instructions for how to use them and 
 *  what we should look for when grading your assignment.
 *********************************************************************/
Instead of the pennants, I used a rabbit and turtle for the race contestants. I compressed
    both images into a zip file and in the code for the race program, I simply changed the
    file name to the appropriate ones to change the pictures shown on PennDraw.



/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

