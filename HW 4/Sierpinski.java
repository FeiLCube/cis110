/* Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execution: java Sierpinski numLevels
 * */

public class Sierpinski {
    public static void main(String[] args) {
        triangle(0.5, 0.5, Math.sqrt(3) / 2.0);
        int numLevels = Integer.parseInt(args[0]);
        sierpinski(numLevels, 0.5, 0.5, Math.sqrt(3) / 2.0);
    }
    
    public static void triangle(double sideLength, double x, double y) {
        PennDraw.filledPolygon(x, y, x + sideLength / 2.0, 
                               y - sideLength * (Math.sqrt(3)) / 2.0, 
                               x - sideLength / 2.0, 
                               y - sideLength * (Math.sqrt(3)) / 2.0);
    }
    
    public static void sierpinski(int numLevels, double size, double x, double y) {
        if (numLevels < 1) {
            return;
        }
        double x1 = x + size / 2;
        double x2 = x - size / 2;
        double y3 = y - size * (Math.sqrt(3) / 2.0);
        triangle(size / 2, x1, y);
        triangle(size / 2, x2, y);
        triangle(size / 2, x, y3);
        PennDraw.enableAnimation(10);
        PennDraw.advance();
        System.out.println("" + numLevels + " " + size);
        sierpinski(numLevels - 1, size / 2, x1, y);
        sierpinski(numLevels - 1, size / 2, x2, y);
        sierpinski(numLevels - 1, size / 2, x, y3);
    }
}