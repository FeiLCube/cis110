public class PollFeb8 {
    public static void main(String[] args) {
        int[] y = {2, 1, 3};
        int[] x = {4, 6, 7, 8, 7};//x and y are two separate arrays
        x = y;//x is pointing to the same array y is pointing to. i.e., array x becomes array y 
        x[x[0]]++;
    }
}
            