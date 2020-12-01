public class FLipACoinJan30 {
    public static void main(String[] args) {
        double r = Math.random(); //random number [0.0, 1.0)
        if (r < 0.5) {
            System.out.println("Heads");
        } else {
            System.out.println("Tails");
        }
    }
}
//*An if statement does not require an else statement but an else statement requires an if
//statement. If an if statement does not have an else statement, then Java implicitly creates
//an else statement that is blank.

public class FLipACoinJan30 {
    public static void main(String[] args) {
        double r = Math.random90;
        if (r < 0.5) {
            System.out.println("Heads");
        } else if (r > 0.5) {
            System.out.println("Tails");
        } else {
            System.out.println("The coin lands on its side");
        }
    }
}
//*Conditionals: if-else-if-statement
//if (boolean_expression_1) {
//    statements;
//} else if (boolean_expression_2) {
//    statements;
//} else if (boolean_expression_3) {
//    statements;
//} else (boolean_expression_4) {
//    statements;
//}