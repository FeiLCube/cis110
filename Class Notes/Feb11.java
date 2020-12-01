public class Feb11 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        double r = sqrt(144.0);
        System.out.println(r);
        
        //Test
        //Test isOdd()
        System.out.println(isOdd(5) + " - should be true");
        System.out.println(isOdd(6) + " - should be false");
        //Test isEven()
        System.out.println(isEven(5) + " - should be false");
        System.out.println(isEven(6) + " - should be true");
        //Test max
        System.out.println(max(5, 3) + " - should be 5");
        System.out.println(max(-3, -2) + " - should be -2");
        //T
    }
    public static boolean isOdd(int x) {
        return x % 2 == 1; //x % 2 == 1 is already a boolean statement so it will return true
        //or false
    }
    public static boolean isEven(int x) {
        return !isOdd(x);
    }
    public static double abs(double x) {
        if (x > 0) {
            return x;
        } else {
            return -x;
        }
    }
    public static int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
    
    public static double max(double x, double y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
   
    public static String reverse(String s) {
        String out = "";
        for (int i = 0; i < s.length(); i++) {
            out = s.charAt(i) + out;
        }
        return out;
    }
    
    public static boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }
    
    /*public static int abs(int x) {
        if (x > 0) {
            return x;
        } else {
            return -x;
        }
    }*/
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t) {
            t = (c/t + t) / 2.0;
        }
        return t;
    } 
}
/*Modularize -
 *Functions break your code to small, readable pieces and allow you to figure out which part
 * of the code is wrong.
 *The order of functions written do not matter but for readibility purposes...
 **/