/**
 * - A side effect is anything that is not the return of a value from a function.
 * - A variable inside a loop or function exists only inside the loop or function.
 * - Passby value: when a function is called, the variable is passed.
 * - Passby reference: when an Object is called, the reference is passed. Strings are the
 * only exception, think of them as passby value.
 */
public class Feb15 {
    public static void main(String[] args) {
        int[] x = {5, 2, 3, 0};
        System.out.println(sum(x) + "should be 10");
    }
    
    /**
     *  This function gets the sum total of every integer in an array.
     * Input: arr - the input array to sum up
     * Output: Sum - the total of every integer in the input array
     */
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];//or sum = sum + arr[i];
        }
        return sum;
    }
    
    /*
     * Return the smallest element in the int array.
     * Input - Integer array
     * Output - smallest integer in the array
     */
    public static int min(int[] arr) {
        
        if (arr.length == 0) {//there is no valid minimum
            throw new RuntimeException("Error: cannot get min of 0 sized array");
        }
            
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    min = arr[i];
                    
                }
                
            }
            return min;
        }
    }