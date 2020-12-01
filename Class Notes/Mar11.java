public class Mar11 {
    public static void main(String[] args) {
    }
    
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(a, a & b);
    }
    
    public static int sumHelper(int[] arr, int n) {
        if (n == arr.length) {
            return 0;
        }
        return sumHelper(arr, n + 1) + arr[n];
    }
}


