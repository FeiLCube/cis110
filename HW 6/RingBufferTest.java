import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

public class RingBufferTest {
    RingBuffer test;
    @Before
    public void setup() {
        test = new RingBuffer(3);
    }
    
    @Test
    public void testRingBuffer() {
        double[] expectedArray = new double[3];
        assertEquals(0, test.getFirst());
        assertEquals(0, test.getLast());
        assertEquals(0, test.currentSize());
        assertArrayEquals(expectedArray, test.getBuffer(), 0.0);
    }
    
    @Test
    public void testIsEmpty() {
        assertEquals(true, test.isEmpty());
        test.enqueue(5.5);
        assertEquals(false, test.isEmpty());
    }
    
    @Test
    public void testIsFull() {
        test.enqueue(3.0);
        test.enqueue(7.5);
        test.enqueue(-4.7);
        assertEquals(true, test.isFull());
        test.dequeue();
        assertEquals(false, test.isFull());
    }
    
    @Test
    public void testEnqueue() {
        test.enqueue(3.0);
        double[] expectedArrayOne = {3.0, 0.0, 0.0};
        assertEquals(0, test.getFirst());
        assertEquals(1, test.getLast());
        assertEquals(1, test.currentSize());
        assertArrayEquals(expectedArrayOne, test.getBuffer(), 0.0);
        
        test.enqueue(7.5);
        test.enqueue(-4.7);
        test.dequeue();
        test.enqueue(5.2);
        double[] expectedArrayTwo = {5.2, 7.5, -4.7};
        assertEquals(1, test.getFirst());
        assertEquals(1, test.getLast());
        assertEquals(3, test.currentSize());
        assertArrayEquals(expectedArrayTwo, test.getBuffer(), 0.0);
    }
    
    @Test (expected = RuntimeException.class)
    public void testEnqueueError() {
        test.enqueue(7.5);
        test.enqueue(-4.7);
        test.enqueue(5.2);
        test.enqueue(6.0);
    }
    
    @Test
    public void testDequeue() {
        test.enqueue(7.5);
        test.enqueue(-4.7);
        test.dequeue();
        double[] expectedArrayOne = {7.5, -4.7, 0.0};
        assertEquals(1, test.getFirst());
        assertEquals(2, test.getLast());
        assertEquals(1, test.currentSize());
        assertArrayEquals(expectedArrayOne, test.getBuffer(), 0.0);
        
        test.enqueue(2.0);
        test.enqueue(8.9);
        test.dequeue();
        test.enqueue(2.1);
        test.dequeue();
        test.dequeue();
        double[] expectedArrayTwo = {8.9, 2.1, 2.0};
        assertEquals(1, test.getFirst());
        assertEquals(2, test.getLast());
        assertEquals(1, test.currentSize());
        assertArrayEquals(expectedArrayTwo, test.getBuffer(), 0.0);
    }
    
    @Test (expected = RuntimeException.class)
    public void testDequeueError() {
        test.dequeue();
    }
    
    @Test
    public void testPeek() {
        test.enqueue(1.0);
        test.enqueue(2.0);
        assertEquals(1.0, test.peek(), 0.0);
        System.out.println(test.peek());
        
        test.dequeue();
        assertEquals(2.0, test.peek(), 0.0);
        System.out.println(test.peek());
        
        test.enqueue(0.0);
        test.dequeue();
        assertEquals(0.0, test.peek(), 0.0);
        System.out.println(test.peek());
    }
    
    @Test (expected = RuntimeException.class)
    public void testPeekError() {
        test.peek();
    }
}