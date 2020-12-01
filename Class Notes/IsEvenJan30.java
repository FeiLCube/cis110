//*Conditonal and Loops
//*If statement: evaluate a boolean and then execute some statement for the evaluated boolean.

public class IsEvenJan30 {
    public static void main(String[] args) {
        //Get a number from the command line arguments
        int x = Integer.parseInt(args[0]);
        
        //if the number is even, print that it's even
        if (x % 2 == 0) {
        System.out.println(x + " is Even");
        } else {
        //otherwise, print that it's odd
        System.out.println(x + " is Odd");
        }
    }
}