public class ShapeDemo {
    public static void main(String[] args) {
        /*Circle c = new Circle(0.25, 0.25, 0.25);
        System.out.println(c.perimeter());
        c.draw();
        
        Square s = new Square(0.75, 0.75, 0.50);
        System.out.println(c.perimeter());
        s.draw();
        */
        
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(0.25, 0.25, 0.25);
        shapes[1] = new Square(0.75, 0.75, 0.50);
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
        }
        
        //You can typeCast objects.
        System.out.println(((Circle) shapes[0]).getRadius());
        System.out.println(((Square) shapes[1]).getsideLength());
    }
}