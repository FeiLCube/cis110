public class Feb6 {
    public static void main(String[ ] args) {
        int[ ] zip = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            zip[i] = Integer.parseInt(args[i]);
        }
             System.out.println(zip);
        
        for (int i = 0; i < zip.length; i++) {
            if (i == zip.length - 1) {
                System.out.println(zip[i]);
            } else {
                System.out.print(zip[i]+", ");
            }
        }
    }
}