import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;



public class ListDemo {
    public static void main(String[] args) {
        List<String> words = new LinkedList<String>();
        words.add("Cat");
        words.add("Dog");
        words.add("Bird");
        words.add("apple");
        System.out.println(words);
        
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(8);
        numbers.add(5);
        numbers.add(4);
        numbers.add(-17);
        System.out.println(sum(numbers) + " - should be 0");
    }
    
    private static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i; //NOT list(i)
        }
        return sum;
    }
}