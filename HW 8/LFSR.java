/**
 * Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execution: java LFSR
 * 
 * Description: This class is an object that represents a seed as 
 * an array and has a tapPosition. It uses those to generate pseudo
 * random bits, which will be pushed into the array at the end, and
 * every value in the array is then shifted to the left.
 */

public class LFSR {
    private int[] register;
    private int tapPosition;
    
    public LFSR(String seed, int tapPosition) {
        if (tapPosition >= seed.length() || tapPosition < 0) {
            throw new RuntimeException(
                "Tap position is out of the bounds of the array");
        }
        this.tapPosition = tapPosition;
        this.register = new int[seed.length()];
        for (int i = seed.length(); i > 0; i--) {
            int x = (int) seed.charAt(i - 1) - 48;
            if (x != 1 && x != 0) {
                throw new RuntimeException("Seed may only include 1's and 0's");
            } else {
                register[i - 1] = x;
            }
        }
    }
    
    public LFSR(int seedLength, int tapPosition) {
        if (seedLength < 0) {
            throw new RuntimeException("Seedlength must be 0 or positive");
        }
        if (tapPosition >= seedLength || tapPosition < 0) {
            throw new RuntimeException(
                "Tap position is out of the bounds of the array");
        }
        this.tapPosition = tapPosition;
        this.register = new int[seedLength];
        for (int i = 0; i < seedLength; i++) {
            register[i] = (int) Math.random() * 2;
        }
    }
    
    /* This function returns the register's values as a String.
     */ 
    public String toString() {
        String s = "";
        for (int i = 0; i < register.length; i++) {
            s += register[i];
        }
        return s;
    }
    
    /* This function returns the tapPosition of this instance
     * of LFSR.
     */
    public int getTapPosition() {
        return tapPosition;
    }
    
    /* This function performs a left shift on the LFSR's register
     * array. Every indice value is shifted to the left by 1, and
     * the last index is replaced with a pseudo-random bit.
     */
    public int nextBit() {
        int bit = register[0] ^ register[register.length - 1 - tapPosition];
        for (int i = 0; i < register.length - 1; i++) {
            register[i] = register[i + 1];
        }
        register[register.length - 1] = bit;
        return bit;
    }
    
    public static void main(String[] args) {
        LFSR lfsr = new LFSR("01101000010", 8);
        for (int i = 0; i < 10; i++) {
            int bit = lfsr.nextBit();
            System.out.println(lfsr.toString() + " " + bit);
        }
    }
}