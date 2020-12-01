public class Square implements Shape {
    private double sideLength, x, y;
    
    public Square(double sideLength, double x, double y) {
        this.sideLength = sideLength;
        this.x = x;
        this.y = y;
    }
    
    public double getCenterX() {
        return x;
    }
    public double getCenterY() {
        return y;
    }
    public double perimeter() {
        return 4 * sideLength;
    }
    public double area() {
        return sideLength * sideLength;
    }
    public void draw() {
        PennDraw.square(x, y, sideLength / 2);
    }
}