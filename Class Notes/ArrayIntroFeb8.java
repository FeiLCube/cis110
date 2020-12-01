public class ArrayIntroFeb8 {
    public static void main(String[] args) {
        int[] zip = new int[args.length];
        for (int i = 0; i < zip.length; i++) {
            zip[i] = Integer.parseInt(args[i]);
        }
        //create a new, larger array
        int[] temp = new int[zip.length + 1];
        
        //copy the values from the old array to the new one
        for (int i = 0; i < zip.length; i++) {
            temp[i] = zip[i];
        }
        
        //insert into the new empty space 7
        temp[temp.length - 1] = 7;
        
        //change the array zip points to
        zip = temp;
        
        System.out.println(zip);
        
        for (int i = 0; i < zip.length; i++) {
            if (i == zip.length - 1) {
                System.out.println(zip[i]);
            }
        }
    }
}