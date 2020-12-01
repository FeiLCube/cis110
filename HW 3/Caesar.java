/* Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 */

public class Caesar {
    public static void main(String[] args) {
        
        In inStream = new In(args[1]);
        String file = inStream.readAll();
        
        if (args[0].equals("encrypt")) {
            System.out.println(encrypt(file, (int) args[2].charAt(0) - 'A'));
        }
        if (args[0].equals("decrypt")) {
            System.out.println(decrypt(file, (int) args[2].charAt(0) - 'A'));
        }
        if (args[0].equals("crack")) {
            System.out.println(crack(file, args[2]));
        }
        
        /*test stringToSymbolArray
         int[] testArray1 = stringToSymbolArray("ABCD");
         for (int i = 0; i < testArray1.length; i++) {
         System.out.print(testArray1[i] + ", ");
         }
         System.out.println(" - should be 0, 1, 2, 3");
         
         int[] testArray2 = stringToSymbolArray("abcd");
         for (int i = 0; i < testArray2.length; i++) {
         System.out.print(testArray2[i] + ", ");
         }
         System.out.println(" - should be 0, 1, 2, 3");*/
        
        /*test symbolArrayToString
         int[] symbols = {1, 3, 5};
         System.out.print(symbolArrayToString(symbols) + " - should be BDF");*/
        
        /*test shift
         System.out.println(shift(2, 1) + " - should be 3");
         System.out.println(shift(3, 'B' - 'A') + " - should be 4");*/
        
        /*test encrypt
         System.out.println(encrypt("ET TU, BRUTE?", 6) + "
         - should be 'KZ ZA, HXAZK?'");
         System.out.println(encrypt("THIS IS FUN!", 5) + "
         - should be YMNX NX KZS!");*/
        
        /*test decrypt
         System.out.println(decrypt("ET TU, BRUTE?", 1) + "
         - should be DS ST, AQTSD?");*/
        
        /*test findFrequencies
         String s = "ABCDEFGHIJK!LMNO PQRST UV?WXYZ   ";
         int[] array = stringToSymbolArray(s);
         for (int i = 0; i < 26; i++) {
         System.out.println(findFrequencies(array)[i] + ", Should be 0.038");
         }
         int[] array = {0, 0, 3, 0};
         for (int i = 0; i < 26; i++) {
         System.out.print(findFrequencies(array)[i] + ", ");
         }
         System.out.println(" - should be 0.75, 0, 0, 0.25");
         int[] array = {-5, -2, 3, 0};
         for (int i = 0; i < 26; i++) {
         System.out.print(findFrequencies(array)[i] + ", ");
         }
         System.out.println(" - should be 0.50, 0, 0, 0.50");*/
        
        /*test scoreFrequencies
         double[] freq = {0.1, 0.05, 0.15};
         double[] freqTwo = {0.05, 0.1, 0.05};
         System.out.println(scoreFrequencies(freq, freqTwo) + " - should be 0.2");*/
        
        /*test getDictionaryFrequencies
         for (int i = 0; i < 26; i++) {
         System.out.println(getDictionaryFrequencies("english.txt")[i]);
         }*/
        
    }
    /* Description: This function shifts the input string to the left by (key)
     * Input: String
     * Output: Decrypted string */
    public static String decrypt(String cipher, int key) {
        int[] symbols = stringToSymbolArray(cipher);
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = unshift(symbols[i], key);
        }
        return symbolArrayToString(symbols);
    }
    /* Description: This function shifts the input string to the right by (key)
     * Input: String
     * Output: Encrypted string */
    public static String encrypt(String message, int key) {
        int[] symbols = stringToSymbolArray(message);
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = shift(symbols[i], key);
        }
        return symbolArrayToString(symbols);
    }
    
    /*
     * Description: converts a string to a symbol array,
     *              where each element of the array is an
     *              integer encoding of the corresponding
     *              element of the string.
     * Input:  the message text to be converted
     * Output: integer encoding of the message
     */
    public static int[] stringToSymbolArray(String str) {
        str = str.toUpperCase();
        int[] symbol = new int[str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            int y = (int) x - 'A';
            symbol[i] = y;
        }
        return symbol;
    }
    
    /*
     * Description: converts an array of symbols to a string,
     *              where each element of the array is an
     *              integer encoding of the corresponding
     *              element of the string.
     * Input:  integer encoding of the message
     * Output: the message text
     */
    public static String symbolArrayToString(int[] symbols) {
        String s = "";
        for (int i = 0; i < symbols.length; i++) {
            s += (char) (symbols[i] + 'A');
        }
        return s;
    }
    
    /*
     * Description: This function shifts one integer by (offset).
     * Input: integer to be shifted
     * Output: the shifted integer*/
    public static int shift(int symbol, int offset) {
        
        if (symbol < 0) {
            return symbol;
        } else {
            if (symbol > 25) {
                return symbol;
            }
        }
        symbol += offset;
        if (symbol < 0) {
            symbol = symbol % 26 + 26;
        }
        if (symbol > 25) {
            symbol = symbol % 26;
        }
        
        return symbol;
    }
    
    /*Description: unshifts an integer, or reverses the shift function
     * Input: the integer to be unshifted
     * Output: the unshifted integer*/
    public static int unshift(int symbol, int offset) {
        symbol = shift(symbol, -offset);
        return symbol;
    }
    
    /*
     * Description: reads the text from the file english.txt, and arranges the 
     * frequencies list in the text to a double array.
     * Input: The file English.txt
     * Output: a double array with the frequency of each English letter.*/
    public static double[] getDictionaryFrequencies(String english) {
        In inStreamTwo = new In(english);
        double[] letterFrequency = new double[26];
        
        for (int i = 0; i < 26; i++) {
            letterFrequency[i] = inStreamTwo.readDouble();
        }
        return letterFrequency;
    }
    
    /*
     * Description: Finds the frequency of all integers from 0 to 25 from an
     * integer array and sorts it into a double array.
     * Input: the integer array that you need to find the frequency of
     * Output: the frequency array for all integers from the input integer array
     * from 0 to 25.*/
    public static double[] findFrequencies(int[] free) {
        double[] textFreq = new double[26];
        int totalInt = 0;
        for (int i = 0; i < free.length; i++) {
            if (free[i] >= 0 && free[i] < 26) {
                totalInt++;
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < free.length; k++) {
                if (free[k] == i) {
                    textFreq[i]++;
                }
            }
            textFreq[i] = textFreq[i] / totalInt;
        }
        return textFreq;    
    }
    
    /*
     * Description: Finds a score that compares the frequencies of
     * integers from two different double arrays. The lower the score,
     * the closer are the frequencies of the integers of the two double
     * arrays.
     * Input: The two double arrays that you want to compare the frequencies
     * of its integers with.
     * Output: The score that shows how well the two frequencies matched up.*/
    public static double scoreFrequencies(double[] freqs, double[] englishFreqs) {
        double total = 0;
        for (int i = 0; i < freqs.length; i++) {
            total += Math.abs(freqs[i] - englishFreqs[i]);
        }
        return total;
    }
    
    /*
     * Description: This function cracks any encrypted file.
     * Inputs: file to be cracked and english.txt
     * Output: the cracked, legible file!*/
    public static String crack(String file, String english) {
        
        int[] integers = stringToSymbolArray(file);
        double minScore = Double.MAX_VALUE;
        int minIteration = 0;
        
        double[] englishFreqs = getDictionaryFrequencies(english);
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < integers.length; j++) {
                int k = shift(integers[j], i);
                integers[j] = k;
            }
            double[] freqs = findFrequencies(integers);
            double score = scoreFrequencies(freqs, englishFreqs);
            
            if (score < minScore) {
                minScore = score;
                minIteration = i;
            }
            integers = stringToSymbolArray(file);
        }
        for (int i = 0; i < file.length(); i++) {
            int[] arr = stringToSymbolArray(file);
            integers[i] = shift(arr[i], minIteration);
        }
            String print = symbolArrayToString(integers);
            return print;
        }
    }