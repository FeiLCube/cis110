/**
 * Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execution: java GuitarString int
 * 
 * Description: This class is an object that resembles a guitar
 * string, with the functions pluck and tic to resemble the waves
 * that form when you pluck a guitar.
 */

public class GuitarString {
    
    private static int SAMPLING_RATE = 44100;
    private static double ENERGY_DECAY_FACTOR = 0.991;
    private double frequency;
    private double numSamples;

    private RingBuffer buffer; // ring buffer
    // TODO: YOUR OTHER INSTANCE VARIABLES HERE (IF ANY)
    private int count = 0;

    /**
     * Constructor: Creates a guitar string of the given frequency
     */
    public GuitarString(double frequency) {
        this.frequency = frequency;
        numSamples = Math.ceil(SAMPLING_RATE / this.frequency);
        buffer = new RingBuffer((int) numSamples);
        for (int i = 0; i < numSamples; i++) {
            buffer.enqueue(0.0);
        }
    }

    /**
     * Description: This function resets all of the values in
     * bufferArray to a random value between -0.5 inclusive
     * and 0.5 exclusive.
     * Input: none
     * Output: none
     */
    public void pluck() {
        for (int i = 0; i < numSamples; i++) {
            buffer.dequeue();
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    /**
     * Description: This function applies the Karplus-Strong
     * algorithm to buffer.
     * Input: none
     * Output: none
     */
    public void tic() {
        double numOne = sample();
        buffer.dequeue();
        double numTwo = sample();
        double newNum = (numOne + numTwo) * ENERGY_DECAY_FACTOR / 2;
        buffer.enqueue(newNum);
    }

    /**
     * Description: This function simply gives the value of the first
     * index in the array bufferArray from the object variable buffer.
     * Input: none
     * Output: value of the first index of bufferArray.
     */
    public double sample() {
        return buffer.peek();
    }

    /**
     * Description: This function keeps track of how many times
     * tic function is called.
     * Input: none
     * Output: number of times tic was called.
     */
    public int time() {
        return count++;
    }

    // TODO: ADD MORE THOROUGH TESTING
    public static void main(String[] args) {
        // how many samples should we "play"
        int numSamplesToPlay = Integer.parseInt(args[0]);

        // a starting set of samples; it's pretty easy to calculate
        // the new samples that will get generated with a calculator
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  

        // create a guitar string to test with exactly samples.length,
        // this looks a little funny because the HarpString constructor
        // expects a frequency, not a number of elements
        GuitarString testString = new GuitarString(44100.0 / samples.length);

        // at this point the RingBuffer underlying testString should have
        // a capacity of samples.length and should be full
        System.out.println("testString.buffer.isEmpty(): " + 
                            testString.buffer.isEmpty());
        System.out.println("testString.buffer.isFull():  " + 
                            testString.buffer.isFull());

        // replace all the zeroes with the starting samples
        for (int i = 0; i < samples.length; i++) {
            testString.buffer.dequeue();
            testString.buffer.enqueue(samples[i]);
        }

        // "play" for numSamples samples; printing each one for inspection
        for (int i = 0; i < numSamplesToPlay; i++) {
            int t = testString.time();
            double sample = testString.sample();

            // this statement prints the time t, padded to 6 digits wide
            // and the value of sample padded to a total of 8 characters
            // including the decimal point and any - sign, and rounded
            // to four decimal places
            System.out.printf("%6d %8.4f\n", t, sample);

            testString.tic(); // advance to next sample
        }
    }
}
