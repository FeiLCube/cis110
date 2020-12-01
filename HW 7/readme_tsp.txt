/**********************************************************************
 *  readme template                                                   
 *  Traveling Salesperson Problem
 **********************************************************************/

Name: Fei Liu
PennKey: liufei
Recitation: 218



/**********************************************************************
 *  Have you entered all help, collaboration, and outside resources
 *  in your help log?  If not, do so now.  (And in future, make sure
 *  you make your help log entries as you go, not at the end!)
 *
 *  If you did not get any help outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/
I did not receive any help outside of TA office hours. I did
    not collaborate with anyone, and I did not use any
    resources beyond the standard course materials.




/**********************************************************************
 *  Problem A:
 *  Explain how you implemented the nearest insertion heuristic.
 **********************************************************************/
I inserted the nearest heuristic by first instantiating a Node
    that held the new coordinates. I instantiate a variable called
    minDistance that keeps track of the minimum distance between 
    coordinates. I then create a for loop that runs through every node 
    in the Tour and calculates the distance between every node's 
    coordinates and the new coordinate. The variable minDistance will
    be equal to that minimum distance. I then run another for loop with
    an if statement saying that if the distance from the node's coordinate
    to the new coordinate was equal to minDistance, then the node holding
    the new coordinate will point to what the current node in the loop
    is point to, and then the current node will point to the new node,
    completing the insertion.




/**********************************************************************
 *  Problem B:
 *  Explain how you implemented the smallest insertion heuristic.
 *  It's sufficient to list only the differences between this
 *  heuristic and the nearest insertion heuristic.
 **********************************************************************/
The ONLY difference between implementing the smallest insertion heuristic
    and the nearest insertion heuristic is that instead of tracking
    minDistance, I am keeping track of minIncrement, which is equal to
    the distance between (in a for loop) the node's coordinate to the new 
    coordinate plus the distance between the next node's coordinate to the
    new coordinate subtracted by the distance between the node's coordinate
    and the next node's coordinate.



 
 /**********************************************************************
 *  Problem C:
 *  Why is it a good idea to repeat the first Node at the end of the Tour?
 **********************************************************************/
It is a good idea to repeat the first Node at the end of the Tour so
    the salesperson ends up where he started.
 


 
/**********************************************************************
 *  If you did the extra credit, explain your heuristic, and how
 *  you went about implementing it.
 **********************************************************************/


 
 
 
/**********************************************************************
 *  If you did the extra credit, give instructions here for 
 *  running it.
 **********************************************************************/



 
/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
None.



/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

 
 
 
