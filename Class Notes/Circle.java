public class Circle implements Shape {
    private double x, y;
    private double radius;
    
    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    //You can always add functions to the existing functions in the interface
    //@Override - this method comes from the parent interface
    public double getCenterX() {
        return x;
    }
    public double getCenterY() {
        return y;
    }
    public double perimeter() {
        return radius * 2 * Math.PI;
    }
    public double area() {
        return radius * radius * Math.PI;
    }
    public void draw() {
        PennDraw.circle(x, y, radius);
    }
}