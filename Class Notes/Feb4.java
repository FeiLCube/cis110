public class Feb4 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        //assume is prime
        boolean isPrime = true;
        //check every number from 2 to sqrt n to see if it evenly divides n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            //if I find an evenly divisible factor
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        
        if(isPrime) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is composite");
        }
        /**for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;//skip this iteration of the loop and then re-enter the loop.
                break;//leave the loop and do not re-enter even if the condition is true.
            }
            System.out.println(i);
        } */
    }
}