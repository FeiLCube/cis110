/*Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 */
public class Race {    
    public static void main(String[] args) {
        boolean pennWins = false;       // has Penn won the race?
        boolean princetonWins = false;  // has Princeton won the race?
        
        // TODO - define any variables you need here
        double a = Math.random();
        double b = Math.random();
        double i = 0.147;
        double j = 0.147;
        
        // the width of 1 pixel in window coordinates,
        // assuming you do NOT call PennDraw.setXscale()
        double ONE_PIXEL = 1.0 / 512;  
        
        
        // enable animation at 10 frames/second
        // TODO - you may change the frame rate to be any speed you like
        PennDraw.enableAnimation(60);
        
        while (!pennWins && !princetonWins) {
            /* TODO the following
             * 1. clear the screen
             * 2. draw the start line
             * 3. draw the finish line
             * 4. draw the Penn and Princeton pennants
             * 5. determine whether the Penn pennant position changes 
             * 6. determine whether the Princeton pennant position changes
             * 7. based on current positions, determine if anyone has won. 
             * DO NOT USE BREAK 
             */
            PennDraw.clear(0, 255, 50);
            PennDraw.line(0.30, 0.0, 0.30, 1.0);
            PennDraw.line(0.90, 0.0, 0.90, 1.0);
            PennDraw.picture(i, 0.25, "penn.png");
            PennDraw.picture(j, 0.75, "princeton.png");
            
            a = Math.random();
            if (a < 0.62) {
                i = i + ONE_PIXEL;
                PennDraw.picture(i, 0.25, "penn.png");
            }
            
            b = Math.random();
            if (b < 0.60) {
                j = j + ONE_PIXEL;
                PennDraw.picture(j, 0.75, "princeton.png");
            }
            if (i >= 0.75) {
                pennWins = true;
            }
            if (j >= 0.75) {
                princetonWins = true;
            }
            
            if (pennWins) {
                PennDraw.text(0.5, 0.5, "PENN WINS!!", 45);
            }
             if (princetonWins) {
                 PennDraw.text(0.5, 0.5, "PRINCETON WINS!!", 315);
             }
            PennDraw.advance(); // show this frame and go on to the next one
        }
        
        PennDraw.disableAnimation(); // the race is over so turn off animation
        // TODO - draw text containing a victory message in the sketch
    }
}
