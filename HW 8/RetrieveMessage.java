/**
 * Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execution: java RetrieveMessage filename seed tapPosition
 * or         java RetrieveMessage filename
 * 
 * Description: This class takes in an image and extracts the
 * hidden message that is either embedded or encrypted in it,
 * and returns that message as a String.
 */
public class RetrieveMessage {
    public static void main(String[] args) {
        int[][] pic = ImageData.load(args[0]);
        
        int index = 0;
        boolean breakTrigger = false;
        
        int num = pic.length * pic[0].length;
        int[] array = new int[(num / 7) * 7];
        
        int indicesLeft = array.length;
        for (int row = 0; row < pic.length; row++) {
            for (int col = 0; col < pic[row].length; col++) {
                indicesLeft--;
                if (indicesLeft == 0) {
                    breakTrigger = true;
                    break;
                }
                if (pic[row][col] % 2 == 0) {
                    pic[row][col] = 0;
                    array[index] = 0;
                } else {
                    pic[row][col] = 1;
                    array[index] = 1;
                }
                index++;
            }
            if (breakTrigger) {
                break;
            }
        }
        
        if (args.length == 3) {
            String seed = args[1];
            int tap = Integer.parseInt(args[2]);
            
            Codec.decrypt(array, seed, tap);
        }
        String s = Codec.decode(array);
        System.out.println(s);
    }
}