public class FunctionsFeb18 {
    public static int max(int a, int b, int c) {
        if (a > b) {
            if (a > c) return a;
            else return c;
        } else {
            if (b > c) return b;
            else return c; //should be return c
        }
    }
    
    public static double power(double base, int exp) {
        if (base == 0.0 && exp <= 0) {
            return Double.NaN;
        } else {
            double out = 1.0;
            int loopTo = Math.abs(exp);
            for (int i = 0; i < loopTo; i++) {
                out *= base;
            }
            if (exp > 0) {
                return out;
            } else {
                return 1 / out;
            }
        }
    }
    
    public static int power(int base, int exp) {
        if (exp < 0) {
            throw new RuntimeException("Error: negative exponent not allowed");
        }
        int x = 1;
        for (int i = 0; i < exp; i++) {
            x *= base;
        }
        return x;
    
    }
}