/**
 * Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execution: 
 * 
 * Description: This class represents an object called Tour
 * which draws the paths of the salesperson.
 */

public class Tour implements TourInterface {
    
    private Node head;
    private Node lastNode;
    
    public Tour() {
        head = null;
        lastNode = null;
    }
    
    /**
     * Description: Creates a String representation of the
     * tour.
     * Input: none
     * Output: a String showing the tour.
     */
    public String toString() {
        String s = "";
        for (Node n = head; n != null; n = n.next) {
            s += n.coordinate.toString() + "\n";
        }
        return s;
    }
    
    /**
     * Description: Draws a coordinate.
     * Input: Coordinate you wish to draw
     * Output: none
     */
    public void draw(Coordinate c) {
        if (head == null) {
            return;
        }
        for (Node n = head; n != lastNode; n = n.next) {
            n.coordinate.drawTo(n.next.coordinate);
            PennDraw.setPenColor((int) Math.random() * 255,
                                 (int) Math.random() * 255, 
                                 (int) Math.random() * 255);
        }
    }
    
    /**
     * Description: Returns the number of coordinates in the tour.
     * Input: none.
     * Output: the number of coordinates in the tour.
     */
    public int size() {
        int count = 0;
        for (Node n = head; n != lastNode; n = n.next) {
            count++;
        }
        return count;
    }
    
    /**
     * Description: Returns the total distance traveled in the tour.
     * Input: none.
     * Output: total distance travelled in the tour.
     */
    public double distance() {
        double distance = 0;
        if (head == null) {
            return 0.0;
        } else {
            for (Node n = head; n != lastNode; n = n.next) {
                distance += n.coordinate.distanceTo(n.next.coordinate);
            }
        }
        return distance;
    }
    
    /**
     * Description: Inserts a coordinate to the end of the tour.
     * Input: Coordinate to add.
     * Output: none.
     */
    public void insertInOrder(Coordinate c) {
        if (head == null) {
            lastNode = new Node(c);
            head = new Node(lastNode, c);
        } else {
            for (Node n = head; n != null; n = n.next) {
                if (n.next == lastNode) {
                    Node newNode = new Node(lastNode, c);
                    n.next = newNode;
                    n = n.next;
                }
            }
        }
    }
    
    /**
     * Description: Inserts a coordinate right after an existing coordinate
     * that is closes to where the newest coordinate is.
     * Input: Coordinate to add.
     * Output: none.
     */
    public void insertNearest(Coordinate c) {
        if (head == null) {
            lastNode = new Node(c);
            head = new Node(lastNode, c);
        } else {
            Node nearestNode = new Node(c);
            double minDist = Integer.MAX_VALUE;
            for (Node n = head; n != lastNode; n = n.next) {
                double dist = c.distanceTo(n.coordinate);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
            for (Node n = head; n != lastNode; n = n.next) {
                if (c.distanceTo(n.coordinate) == minDist) {
                    nearestNode.next = n.next;
                    n.next = nearestNode;
                    break;
                }
            }
        }
    }
    
    /**
     * Description: Inserts a coordinate to the tour so that the total
     * distance of the tour gets increased minimally.
     * Input: Coordinate to add.
     * Output: none.
     */
    public void insertSmallest(Coordinate c) {
        if (head == null) {
            lastNode = new Node(c);
            head = new Node(lastNode, c);
        } else {
            Node nearestNode = new Node(c);
            double minIncrement = Integer.MAX_VALUE;
            for (Node n = head; n != lastNode; n = n.next) {
                double increment = n.coordinate.distanceTo(c) + 
                    n.next.coordinate.distanceTo(c) - 
                    n.coordinate.distanceTo(n.next.coordinate);
                if (increment < minIncrement) {
                    minIncrement = increment;
                }
            }
            for (Node n = head; n != lastNode; n = n.next) {
                if (n.coordinate.distanceTo(c) + 
                    n.next.coordinate.distanceTo(c) - 
                    n.coordinate.distanceTo(n.next.coordinate) == minIncrement) {
                    nearestNode.next = n.next;
                    n.next = nearestNode;
                    break;
                }
            }
        }
    }
            
            public static void main(String[] args) {
                Tour t = new Tour();
                Coordinate a = new Coordinate(0, 0);
                Coordinate b = new Coordinate(1, 0);
                Coordinate c = new Coordinate(1, 1);
                Coordinate d = new Coordinate(0, 1);
                t.insertSmallest(a);
                System.out.println("distance: " + t.distance());
                System.out.println("size: " + t.size());
                t.insertSmallest(b);
                System.out.println("distance: " + t.distance());
                System.out.println("size: " + t.size());
                t.insertSmallest(c);
                System.out.println("distance: " + t.distance());
                System.out.println("size: " + t.size());
                t.insertSmallest(d);
                System.out.println("distance: " + t.distance());
                System.out.println("size: " + t.size());
                t.draw(a);
                t.draw(b);
                t.draw(d);
                System.out.println(t.toString());
            }
        }