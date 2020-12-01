/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Modified from section 3.2, An Introduction to Programming (in Java) by Robert
 *  Sedgewick and Kevin Wayne
 *
 *  Compilation:  javac Coordinate.java
 *  Execution:    java Coordinate
 *
 *  Immutable data type for 2D coordinates.
 *
 *************************************************************************/
/**
 * A coordinate class
 */
public class Coordinate { 
    public final double x;   // Cartesian
    public final double y;   // coordinates
   
    /**
     * create and initialize a coordinate with given (x, y)
     * @param x x-coordinate of coordinate
     * @param y y-coordinate of coordinate
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns Euclidean distance to coordinate c
     * @param  c target coordinate
     * @return Euclidean distance from this coordinate to coordinate c
     * @throws NullPointerException if c is null
     */
    public double distanceTo(Coordinate c) {
        double dx = x - c.x;
        double dy = y - c.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    /**
     * draws this coordinate using standard draw
     */
    public void draw() {
        PennDraw.point(x, y);
    }

    /**
     * draws the line from this coordinate to coordinate c
     * @param c end-coordinate of line
     * @throws NullPointerException if c is null
     */
    public void drawTo(Coordinate c) {
        PennDraw.line(x, y, c.x, c.y);
    }

    /**
     * returns string representation of this coordinate
     * @return string representation of this coordinate
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // test client
    public static void main(String[] args) {
        // get dimensions
        In inStream = new In(args[0]);
        int w = inStream.readInt();
        int h = inStream.readInt();
        PennDraw.setCanvasSize(w, h);
        PennDraw.setXscale(0, w);
        PennDraw.setYscale(0, h);
        PennDraw.setPenRadius(.005);

        // read in and plot points one at at time
        while (!inStream.isEmpty()) {
            double x = inStream.readDouble();
            double y = inStream.readDouble();
            Coordinate c = new Coordinate(x, y);
            c.draw();
        }
    }
}
