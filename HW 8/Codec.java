/**
 * Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execution: java Codec
 * 
 * Description: This class has functions that can be used
 * without creating an instance. The functions are used to
 * help decrypt and decode encrypted messages or to encode
 * and encrypt a message.
 */

public class Codec {
    
    /* Encode is a function that takes a String variable and
     * outputs an array of binary numbers that represent each
     * character in the String in order.
     */
    public static int[] encode(String str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((int) ((char) str.charAt(i)) > 127) {
                throw new RuntimeException(
                      "String contains non-ASCII characters");
            }
        }
        int[] fullArray = new int[7 * str.length()];
        for (int i = 0; i < str.length(); i++) {
            int[] temp = charToIntArray(str.charAt(i));
            for (int j = 0; j < temp.length; j++) {
                fullArray[i * 7 + j] = temp[j];
            }
        }
        return fullArray;
    }
    
    /* Decode is a function that takes in an array of binary numbers
     * and outputs the String message that those binary numbers represented.
     */
    public static String decode(int[] bits) {
        if (bits == null) {
            return null;
        }
        if (bits.length % 7 != 0) {
            throw new RuntimeException("Input array must be in multiples of 7");
        }
        String s = "";
        int index = 0;
        int[] tempArray = new int[7];
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] != 0 && bits[i] != 1) {
                throw new RuntimeException(
                     "Input array should only include 1 and 0's");
            }
            tempArray[index] = bits[i];
            index++;
            if (i % 7 == 6) {
                if (intArrayToChar(tempArray) == '\0') {
                    return s;
                }
                s += intArrayToChar(tempArray);
                index = 0;
            }
        }
        return s;
    }
    
    /* Encrypt is a function that replaces the input array values
     * with an encrypted value, which is found using the XOR operation
     * on the input array value and a random bit, which is generated
     * with the input seed and tapPosition.
     */
    public static void encrypt(int[] message, String seed, int tapPosition) {
        //error checks
        if (seed == null) {
            throw new RuntimeException("Seed is null");
        }
        if (tapPosition < 0 || tapPosition >= seed.length()) {
            throw new RuntimeException("Invalid tapPosition");
        }
        for (int i = 0; i < seed.length(); i++) {
            char c = seed.charAt(i);
            if (c != '0' && c != '1') {
                throw new RuntimeException("Seed must only contain 1's and 0's");
            }
        }
        if (message == null) {
            return;
        }
        if (message.length % 7 != 0) {
            throw new RuntimeException(
                  "Bit array should be in lengths of multiples of 7s");
        }
        for (int i = 0; i < message.length; i++) {
            if (message[i] != 0 && message[i] != 1) {
                throw new RuntimeException(
                      "Bit array should only contain 1's and 0's");
            }
        }
        //end of error checks
        LFSR random = new LFSR(seed, tapPosition);
        for (int i = 0; i < message.length; i++) {
            int x = random.nextBit();
            message[i] = message[i] ^ x;
        }
    }
    
    /* Decrypt is a function that uses decrypts an array using the
     * same method as the encrypt function.
     */
    public static void decrypt(int[] cipher, String seed, int tapPosition) {
        encrypt(cipher, seed, tapPosition);
    }
    
    /* This is a helper function that takes in a character and
     * puts out the binary representation of it stored in an array.
     */
    private static int[] charToIntArray(char ch) {
        int x = (int) ch;
        int[] binary = new int[7];
        for (int i = 1; i < binary.length + 1; i++) {
            if (x == 0) {
                break;
            }
            if (x % 2 == 1) {
                binary[binary.length - i] = 1;
                x--;
            } else {
                binary[binary.length - i] = 0;
            }
            x /= 2;
        }
        return binary;
    }
    
    /* This is a helper function that takes in a array of bits and
     * puts out the character that those bits represented.
     */
    private static char intArrayToChar(int[] bitString) {
        int decimal = 0;
        int exp = 6;
        for (int i = 0; i < bitString.length; i++) {
            decimal += bitString[i] * Math.pow(2, exp);
            exp--;
        }
        return (char) decimal;
    }
    
    public static void main(String[] args) {
        char c = 'C';
        int[] test = charToIntArray(c);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + ", ");
        }
        System.out.println(" - should be {1, 0, 0, 0, 0, 1, 1}");
        
        int[] test2 = {1, 0, 1, 0, 1, 0, 1};
        char a = intArrayToChar(test2);
        System.out.println(a + " - should be U");
        
        String str = "CA";
        int[] test3 = encode(str);
        for (int i = 0; i < 7 * str.length(); i++) {
            System.out.print(test3[i]);
        }
        System.out.println(" - should be 10000111000001");
        
        int[] test4 = {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1};
        System.out.println(decode(test4) + " - should be GA");
        
        int[] test5 = {1, 0, 0, 1, 1, 1, 1}; //O
        String seed = "0110001";
        int tap = 3;
        decrypt(test5, seed, tap);
        for (int i = 0; i < test5.length; i++) {
            System.out.print(test5[i]);
        }
        System.out.println(" - should be 1110101");
    }
}