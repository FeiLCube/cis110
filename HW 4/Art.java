/*Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execeution: java Art n
 * */

public class Art {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        PennDraw.clear(0, 0, 0);
        PennDraw.setPenColor(14, 71, 21);
        PennDraw.filledRectangle(0.5, 0.15, 0.5, 0.15);
        snowStorm(n, 255, 255, 0.05, 8.0, n);
        PennDraw.setPenColor(255, 249, 178);
        PennDraw.filledRectangle(0.075, 0.50, 0.075, 0.50);
        PennDraw.filledRectangle(0.925, 0.50, 0.075, 0.50);
        PennDraw.filledRectangle(0.50, 0.05, 0.50, 0.05);
        PennDraw.filledRectangle(0.50, 0.85, 0.50, 0.15);
        PennDraw.setPenColor(79, 62, 52);
        PennDraw.filledRectangle(0.14, 0.40, 0.01, 0.32);
        PennDraw.filledRectangle(0.86, 0.40, 0.01, 0.32);
        PennDraw.filledRectangle(0.50, 0.71, 0.35, 0.01);
        PennDraw.filledRectangle(0.50, 0.09, 0.35, 0.01);
        PennDraw.setPenColor(0, 0, 0);
        PennDraw.filledCircle(0.50, 0.90, 0.05);
        PennDraw.line(0.14, 0.71, 0.48, 0.93);
        PennDraw.line(0.86, 0.71, 0.52, 0.93);
    }
    
    /*draws a 6 pointed snowflake. A helper function for the recursive function
     * snowStorm.
     * Input: The colors red and green, the size of the snowflake, and the 
     * thickness of the snowflake. */
    public static void snowflake(int r, int g, double size, double thickness) {
        PennDraw.setPenColor(r, g, 255);
        PennDraw.setPenWidthInPoints(thickness);
        double x = Math.random();
        double y = 1 - Math.random() * 0.6;
        PennDraw.line(x, y, x, y + size);
        PennDraw.line(x, y, x + size * (Math.sqrt(3) / 2.0), y + size / 2.0);
        PennDraw.line(x, y, x + size * (Math.sqrt(3) / 2.0), y - size / 2.0);
        PennDraw.line(x, y, x, y - size);
        PennDraw.line(x, y, x - size * (Math.sqrt(3) / 2.0), y - size / 2.0);
        PennDraw.line(x, y, x - size * (Math.sqrt(3) / 2.0), y + size / 2.0);
    }
    
    /*A recursive function that makes the snowflakes smaller and fade in color
     * as the function calls itself more and more. Also the snow on the ground
     * slowly piles up as each iteration is completed.
     * Input: The colors red and green, the size of the snowflake, and the 
     * command first line argument. */
    public static void snowStorm(int iterations, int r,
                                 int g, double size, double thickness, int n) {
        if (iterations < 1) {
            return;
        }
        PennDraw.filledRectangle(0.5, 0.15, 0.5, 0.15 + (0.10 - 0.10 / iterations));
        snowStorm(iterations - 1, r - 24, g - 12, size * 0.65, thickness * 0.8, n);
        snowStorm(iterations - 1, r - 24, g - 12, size * 0.65, thickness * 0.8, n);
        snowStorm(iterations - 1, r - 24, g - 12, size * 0.65, thickness * 0.8, n);
        snowflake(r, g, size, thickness);
        snowflake(r, g, size, thickness);
        snowflake(r, g, size, thickness);
    }
}

