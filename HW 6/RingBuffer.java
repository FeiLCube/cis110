/**
 * Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execution: java RingBuffer int
 * 
 * Description: This class creates the representation
 * of waves on a guitar string.
 */

public class RingBuffer {
    private double[] bufferArray; // items in the buffer
    private int first;            // index for the next dequeue or peek
    private int last;             // index for the next enqueue
    private int currentSize;      // number of items in the buffer

    /**
     * Constructor: Creates an empty buffer, with given max capacity
     */
    public RingBuffer(int capacity) {
        bufferArray = new double[capacity];
        first = 0;
        last = 0;
        currentSize = 0;
    }


    /**
     * Testing Methods Only - The three methods here, getFirst,
     * getLast, and getBuffer are only allowed to be used in
     * RingBufferTest.java, and NO OTHER PLACES
     */
    /**
     * Description: A function to be used in RingBufferTest.java to get
     * the value of the private field first in this class to be able to
     * compare to an expected value.
     * Input: none
     * Output: The first index of this RingBuffer.
     */
    public int getFirst() {
        return this.first;
    }

    /**
     * Description: A function to be used in RingBufferTest.java to get
     * the value of the private field last in this class to be able to
     * compare to an expected value.
     * Input: none
     * Output: The last index of this RingBuffer.
     */
    public int getLast() {
        return this.last;
    }
    
    /**
     * Description: A function to be used in RingBufferTest.java to get
     * the value of the private field bufferArray of an object of class
     * RingBuffer. Used to compare to my expected array in the test code.
     */
    public double[] getBuffer() {
        return this.bufferArray;
    }

    /**
     * These methods below can and be used in GuitarString.java.
     * In fact, you may need to use them ;)
     */

    /**
     * Description: A getter function that returns the current number of
     * filled indices in bufferArray.
     * Input: none
     * Output: the current number of filled indices in bufferArray.
     */
    public int currentSize() {
        return this.currentSize;
    }

    /**
     * Description: This function tells whether bufferArray has any
     * filled indices.
     * Input: none
     * Output: true if bufferArray is empty.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Description: This function tells whether bufferArray has all
     * of its indices filled.
     * Input: none
     * Output: true if bufferArray is full.
     */
    public boolean isFull() {
        return currentSize == bufferArray.length;
    }

    /**
     * Description: Fills x in as the value of the next avilable empty
     * index. Also increments "last", or last points to the next index,
     * wrapping back to the first index if the next index is out of
     * bounds.
     * Input: a double value
     * Output: none.
     */
    public void enqueue(double x) {
        if (isFull()) {
            throw new RuntimeException("ERROR: Attempting to enqueue " +
                                       "to a full buffer.");
        }
        bufferArray[last] = x;
        currentSize++;
        last = first + currentSize;
        if (last >= bufferArray.length) {
            last -= bufferArray.length;
        }
    }

    /**
     * Description: Increments "last", or first points to the next index,
     * wrapping back to the first index if the next index is out of
     * bounds. Returns the double value of the index that was dequeued.
     * Input: none
     * Output: the value of the dequeued index.
     */
    public double dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: Attempting to dequeue " +
                                       "from an empty buffer.");
        }
        double temp = bufferArray[first];
        first++;
        if (first >= bufferArray.length) {
            first -= bufferArray.length;
        }
        currentSize--;
        return temp;
    }

    /**
     * Description: This method returns the value of the
     * "first" index of bufferArray.
     * Input: none
     * Output: the value of the "first" index of bufferArray.
     */
    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: Attempting to peek " +
                                       "at an empty buffer.");
        }
        return bufferArray[first];
    }

    // print the contents of the RingBuffer object for debugging
    // TODO: ADD TO THIS METHOD IF YOU ADD ANY INSTANCE VARIABLES OF YOUR OWN
    private void printBufferContents() {
        // print out first, last, and currentSize
        System.out.println("first:        " + first);
        System.out.println("last:         " + last);
        System.out.println("currentSize:  " + currentSize);

        /* print bufferArray's length and contents if it is not null
           otherwise just print a message that it is null */
        if (bufferArray != null) {
            System.out.println("array length: " + bufferArray.length);
            System.out.println("Buffer Contents:");
            for (int i = 0; i < bufferArray.length; i++) {
                System.out.println(bufferArray[i]);
            }
        } else {
            System.out.println("bufferArray is null");
        }
    }

    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) {
        /* create a RingBuffer with bufferSize elements
           where bufferSize is a command-line argument */
        int bufferSize = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(bufferSize);

        /*buffer.enqueue(9.9);
        buffer.enqueue(-8.7);
        buffer.enqueue(6.4);
        buffer.dequeue();
        System.out.println("first should be 1");
        System.out.println("last should be 0");
        System.out.println("size should be 2");
        System.out.println("array legnth should be 3");
        System.out.println("Array should be {9.9, -8.7, 6.4");*/

        buffer.printBufferContents();
    }

}
