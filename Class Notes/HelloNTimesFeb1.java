public class HelloNTimesFeb1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        
        for (int i = 0; i < n; i++) {
            System.out.println("Hello World");
        }
        
        /**(while loop)
        int i = 0;
        while (i < n) {
            System.out.println("Hello World");
            i++;
        }
        */
        
        /**(while loop)
        int i = 0;
        int v = 1;
        while (i <= n) {
            System.out.println(i + " " + v);
            i++; //i++ is i = i + 1
            v *= 2; //v *= 2 is v = v * 2
        }
        */
    }
}

//*A while loop should be used when you cannot predict the amount of times the loop will occur
//or you know that it will loop infinitely.
//*An accumulator variable is a variable that is modified by a for loop.