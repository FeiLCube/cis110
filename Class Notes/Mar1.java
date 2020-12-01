public class Mar1 {
    public static long fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    
    public static long fibIter(int n) {
        if (n == 0) {
            return 0;
        } else {
            long out = 0;
            long prev = 1;
            long prevPrev = 0;
            for (int i = 1; i < n; i++) {
                out = prev + prevPrev;
                prevPrev = prev;
                prev = out;
            }
            return out;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(fibIter(6));
        System.out.println(fib(6));
    }
}