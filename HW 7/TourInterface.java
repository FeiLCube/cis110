/**
 * DO NOT MODIFY THIS FILE
 * Interface for Tour
 */
public interface TourInterface {
    /**
     * Return a string representation of coordinates in the tour, in order
     * @return string representation of coordinates in the tour, in order
     */
    public String toString();

    /**
     * Draws the tour
     * @param c draws any edge whose start or end coordinate is c in a different color
     */
    public void draw(Coordinate c);

    /**
     * Returns the number of coordinates in the tour
     * @return the number of coordinates in the tour
     */
    public int size();

    /**
     * Returns the total length of the tour
     * @return the total length of the tour
     */
    public double distance();

    /**
     * Insert c at the end of the tour; does nothing if c is null
     * @param c the coordinate to add to the tour
     */
    public void insertInOrder(Coordinate c);
    
    /**
     * Insert c after the coordinate to which it is closest; does nothing if c is null
     * @param c the coordinate to add to the tour
     */
    public void insertNearest(Coordinate c);

    /**
     * Insert c where it will cause the shortest detour; does nothing if c is null
     * @param c the coordinate to add to the tour
     */
    public void insertSmallest(Coordinate c);
}
