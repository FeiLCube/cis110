public class Jan23 {
    public static void main(String[] args) {
        int a, b; //declaration statement, declaring a variable means creating it
        a = 1234; //a is a variable, 1234 is a literal, Assignment statement
        b = 99;
        int c = a + b; //Combined declaration and assignment statement
        System.out.println(c); //prints the value of c
    }
}

//Math Functions on Java
//*you can do simple math operations on java, but when you divide, java will only produce 
//integers rounded down.
//*if you do 5%3, this will give you 2 because this is the remainder function.
//*You can write text by putting it in between quotation marks. The text can be numeral
//or alphabetical
//*You can replace 5+3 with 5+Integer.parseInt("3"). There must be text in Integer.parseInt
//*double a = 3.0. This is the command to assign decimal numbers.
//*Floating-point numbers are numbers with decimal points.
//*Writing (int) before a double will truncate the decimals off the double to make an integer.
//*Math.sqrt (144) will give you 12.0. Math.sqrt will always produce a double.
//*Java cannot produce an irrational number or a decimal that goes on forever, thus if you put
//Math.sqrt(2)*Math.sqrt(2), you will get an answer infinitesmely close to 2.
//*Math.PI = π, Math.pi is an error.
//*0.0 / 0.0 = NaN (not a number). Similarly Math.sqrt(-k) = NaN
//*The max integer on Java is 2147483648. If it goes over this number, it will wrap around to
//-2147483648.
//*Math.abs is absolute value function.
//*Math.pow(base, exponent) is the power function.
//*char ch = 'A'. Single quotes indicates characters. A character is only one letter. Every
//letter and space bar is affiliated with a certain number. Find the associated number by
//typing 'A' + 0 = 65, thus 65 is associated with A. You can revert numbers to characters
//with (char) 65 = 'A'.
//(char) ('A' + 1) = 'B'
//*Lowercase characters are associated with different numbers than the uppercase characters.

//boolean
//*boolean are true or false statements.
//*y==x: is y equal to x, y != x: is y not equal to x.
//*true && true means both statements are true. If a statement is true && false, then
//the whole statement is false.
//*true || false means is either one true. One true makes the whole statement true.
//*If you put an ! in front of a statement, it flips true to false or the other way around.

//String
//*If you use the command String s = "text", you can put more than just a letter in the text.
//*char, int, char, double, boolean are primitive data types. However String is not.
//*String has a plus operation, but what it does is literally combine the texts.
//Example: "cat"+"dog"="catdog", "1"+"2"="12"
//*A concatenation is an operation that merges String and another primitive data type.
//For this, Java will do the operation from left to right and String converts the other
//primitive data types to a String data type.
//*To convert things to a string, just add a (+ "" ) to the command. You cannot typecast
//(String) before the command.
//*You cannot use == to compare strings (you will get false). Instead, use "A".equals("A")
//to get a true statement.
//*Instead of using "B" < "A", use "B".compareTo("A"). The answer will be an integer. If the
//integer is positive, it means the first element is greater than the second, if the integer
//is negative, the second element is greater than the first, and if it is zero, then the two
//elements are equal.
//*You cannot subtract String.

//*SUMMARY
//Data Types: int, double, boolean, char, String