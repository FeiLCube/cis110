/**
 * Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 */
public class StampSketch {
    public static void main(String[] args) {
        // is this the first time we are drawing the background?
        boolean firstTime = true;
        
        PennDraw.clear(1, 28, 71);
        PennDraw.setPenColor(53, 122, 3);
        PennDraw.filledRectangle(0.5, 0.25, 0.5, 0.25);
        PennDraw.setPenColor(255, 255, 255);
        
        while (true) {
            PennDraw.hasNextKeyTyped();
            
            if (PennDraw.hasNextKeyTyped()) {
                
                PennDraw.clear(1, 28, 71);
                PennDraw.setPenColor(53, 122, 3);
                PennDraw.filledRectangle(0.5, 0.25, 0.5, 0.25);
                PennDraw.setPenColor(255, 255, 255);
                for (int i = 0; i < 10; i++) {
                    PennDraw.setPenColor(255, 255, 255);
                    double a = Math.random();
                    double b = Math.random() / 2.0 + 0.5;
                    PennDraw.polyline(a, b, a + 0.01, b + 0.025, a + 0.02, b, 
                                      a - 0.005, b + 0.015, a + 0.025, b + 0.015, 
                                      a, b);
                    PennDraw.setPenColor(103, 181, 130);
                    double c = Math.random() / 2.0;
                    PennDraw.filledCircle(a, c, 0.05);
                    PennDraw.setPenColor(135, 90, 51);
                    PennDraw.filledRectangle(a, c - 0.07, 0.02, 0.07);
                    
                }
                PennDraw.nextKeyTyped();
            }
            // some aspect of the background must involve a loop.
            firstTime = false;
            
            // if the mouse is clicked
            if (PennDraw.mousePressed()) {
                // get the coordinates of the mouse cursor
                double x = PennDraw.mouseX();
                double y = PennDraw.mouseY();
                
                // TODO - check which region the mouse click was in
                if (y > 0.5) {
                    PennDraw.picture(x, y, "UFO.png", y * 100, y * 100);
                }
                if (y < 0.5) {
                    PennDraw.picture(x, y, "Squirrel.jpg", (1 - y) * 66,
                                     (1 - y) * 66);
                    // draw a scaled shape
                }
            }
        }
    }
}