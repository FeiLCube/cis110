public class AllPrimesFeb4 {
    public static void main(String[ ] args) {
        //for each value 2 to 100, determine if it's prime
        //OUTER LOOP
        for (int n = 2; n <= 100; n++) {
              //assume is prime
            boolean isPrime = true;
            //check every number from 2 to sqrt n to see if it evenly divides n
            //INNER LOOP
            for (int i = 2; i <= Math.sqrt(n); i++) {
                //if I find an evenly divisible factor
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        
            if(isPrime) {
                System.out.println(n);
            }
        }
    }
}