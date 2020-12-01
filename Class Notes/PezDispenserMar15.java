/**
 * This is the version of PezDispenser used on March 15, 2019, in class
 * 
 * It is uploaded because this is the version of the file used with
 * PezJunitTestMar15
 */

public class PezDispenserMar15 {
    //fields
    String characterName;
    private String sleeveColor;
    int count;
    int capacity;
    
    /**
     * This is the constructor, which create a new "standard"
     * Pez Dispenser, standard meaning it holds 12 candies. It
     * is initially empty.
     */
    public PezDispenserMar15(String name, String color) {
        characterName = name;
        sleeveColor = color;
        count = 0;
        capacity = 12;
    }
    
    /* For this constructor function, the local variable name is the same
     * as the class-level variable name, so if I did not use this.characterName,
     * java overrides the class-level variable and recognizes it as the local (input)
     * variable. this.characterName actually calls to the object instance.
     * 
     * public PezDispenserMar15(String characterName, String sleeveColor) {
     *    this.characterName = characterName; <- correct
     *    sleeveColor = sleeveColor; <- wrong
     * }
     */
    
    //actions - methods
    
    /**
     * This method attemps to dispense a candy. If there are no
     * candies to dispense, it returns false. Otherwise it returns
     * true and dispenses a candy.
     */
    public boolean dispense() {
        if (count == 0) {
            return false; //no candy for you
        } else {
            count--;
            return true;
        }
    }
    
    //getter, accessor - allows you to read a field but not change it.
    public int getCount() {
        //yoshi.getCount -> this == yoshi
        return count; //if I typed this.count, it would be the same as count. 
    }
    
    //setter, mutator - allows you to change a field.
    public void setColor(String newColor) {
        sleeveColor = newColor;
    }
    
    public void setCount(int n) {
        if (n >= 0 && n <= capacity) {
            count = n;
        } else {
            throw IllegalArgumentException("ERROR: invalid input to setCount");
        }
    }
    
    /**
     * This method fills the Pez Dispenser to capacity
     */
    public void load() {
        count = capacity;
    }
    /**
     * This method tries to add 'n' candies to the Pez Dispenser.
     * If n exceeds the number of empty spaces, it simply filles
     * the Dispenser as much as it can.
     * If n is negative, the program crashes.
     */
    public void load(int n) {
        if (n < 0) {
            throw new RuntimeException("ERROR: cannot load negative candies");
        }
        if (count + n > capacity) {
            count = capacity;
        } else {
            count += n;
        }
    }
    
    public void switchCandies(PezDispenser other) {
        //yoshi.switchCandies(Mario);
        //Mario == other
        //yoshi == this
        int temp = other.count;
        other.count = count;
        count = temp;
    }
    
    /**
     * This method allows us to print a custom message to describe
     * the Pez Dispenser whenever we print it.
     */
    public String toString() {
        String out = "Name: " + characterName;
        out += "\nSleeve: " + sleeveColor;
        out += "\nHolding " + count + " of " + capacity;
        return out;
    }
}