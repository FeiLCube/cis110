public class VisualGuitar {
    static String NOTE_MAPPING = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    static double base = 436.0;
    public static void main(String[] args) {
        GuitarString[] guitar = new GuitarString[NOTE_MAPPING.length()];
        
        for (int i = 0; i < NOTE_MAPPING.length(); i++) {
            double stringFreq = 436.0 * Math.pow(2, (i - 24.0) / 12.0); 
            guitar[i] = new GuitarString(stringFreq);
        }
        
        PennDraw.enableAnimation(30);
        PennDraw.advance();
        
        while (true) {
            if (PennDraw.hasNextKeyTyped()) {
                char key = PennDraw.nextKeyTyped();
                int index = NOTE_MAPPING.indexOf(key);
                if (index == -1) {
                    continue;
                } else {
                    guitar[index].pluck();
                }
            }
            
            double sample = 0;
            
            for (int i = 0; i < guitar.length; i++) {
                sample += guitar[i].sample();
                
            }
//            System.out.println(guitar[index].sample());
            StdAudio.play(sample);
            
            for (int i = 0; i < guitar.length; i++) {
                guitar[i].tic();
                for (double j = 0; j < 1.01; j += 0.02) {
                    PennDraw.point(j, guitar[i].sample());
                }
            }
            
            
        }
    }
}