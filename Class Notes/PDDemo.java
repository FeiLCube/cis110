public class PDDemo {
    public static void main(String[] args) {
        //this is an instance of PezDispenser
        PezDispenser yoshi = new PezDispenser("Yoshi the Dinosaur", "White");
       
        
        //this is another instance of PezDispenser
        PezDispenser mario = new PezDispenser("Mario", "Red");
        yoshi.load();//use parentheses because this is an action/method, not a field/descriptor
        mario.dispense();
        mario.load();
        mario.dispense();
        System.out.println(mario);                                      
        System.out.println(yoshi);
    }
}