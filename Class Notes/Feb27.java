public class Feb27 {
    public static long factorialLoop(long n) {
        long product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }
    
    public static long fact(long n) { //stack overflow error
        if (n == 0) {
            return 1;
        } else { 
            return n * fact(n - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(factorialLoop(6) + " - shuold be 720");
        System.out.println(fact(-1) + " - shuold be 720");
    }
}