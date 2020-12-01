import static org.junit.Assert.*;
import org.junit.*;

public class FunctionsTest {
    @Test //Must be before every test function
    public void testMaxAscending() {
        //inputs
        int a = 1;
        int b = 2;
        int c = 3;
        
        //expected output
        int expected = 3;
        
        //actual output
        int actual = FunctionsFeb18.max(a, b, c);
        
        //actually run test
        assertEquals(expected, actual);
    }
    
    @Test //Must be before every test function
    public void testMaxDescending() {
        //inputs
        int a = 3;
        int b = 2;
        int c = 1;
        
        //expected output
        int expected = 3;
        
        //actual output
        int actual = FunctionsFeb18.max(a, b, c);
        
        //actually run test
        assertEquals(expected, actual);
    }
    
    @Test (expected = RuntimeException.class)
    public void testPower() {
        //inputs
        int base = 3;
        int exp = 4;
        //expected output
        int expected = 81;
        //actual output
        int actual = FunctionsFeb18.power(base, exp);
        //actually run test
        assertEquals(expected, actual);//if the arguments are doubles, there should
        //be a third argument 
    }
}