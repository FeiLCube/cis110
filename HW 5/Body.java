/* Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * This class creates instances of an object, in which we call
 * planets in this context.
 */

public class Body { 
     
    /** 
     * DO NOT EDIT ANY CODE BELOW THIS LINE 
     *  
     * You will get a style warning that reads: 
     * "Variable '[some name]' must be private and have get/set methods." 
     * Ignore any style warnings of this form. Our tests rely on these 
     * variables being public. We will discuss public vs. private next week 
     * in class. You are not expected to know it now. 
     */ 
    public double px, py; //position 
    public double vx, vy; //velocity 
    public double m; //mass 
    public String img; //image file 
     
    public static final double G = 6.67e-11; //gravity constant 
     
    /*DO NOT EDIT ANY CODE ABOVE THIS LINE*/ 
     
    /** 
     * The constructor function creates an instance of an object, which would be
     * a certain planet.
     * Input: mass, x-position, y-position, x-velocity, y-velocity, file image.
     * Output: an instance of an object, which is a planet.
     */ 
    public Body(double mass, double posX, double posY,  
                double velX, double velY, String imageFile) { 
        m = mass;
        px = posX;
        py = posY;
        vx = velX;
        vy = velY;
        img = imageFile;
    } 
     
    /*
     * Description: returns a string representation of the body for the 
     * purposes of printing. We will discuss toString methods in class. 
     *  
     * DO NOT EDIT THIS METHOD AT ALL! 
     */ 
    public String toString() { 
        return String.format("%12.5e %12.5e %12.5e %12.5e %12.5e %12s",  
                             m, px, py, vx, vy, img); 
    } 
     
    /* Description: finds the x - distance from the other body to the current
     * body
     * Input: other planet
     * Output: x - distance to the other body
     */
    public double distanceToX(Body other) { 
        return other.px - this.px;
    } 
     
     
    /* Description: finds the y - distance from the other body to the current
     * body
     * Input: other planet
     * Output: y - distance to the other body
     */
    public double distanceToY(Body other) { 
        return other.py - this.py;
    } 
     
    /* Description: finds the distance from the other body to the current body.
     * Input: other planet
     * Output: distance to the other body
     */
    public double distanceTo(Body other) { 
        double px2 = distanceToX(other) * distanceToX(other);
        double py2 = distanceToY(other) * distanceToY(other);
        return Math.sqrt(px2 + py2);
    } 
 
    /* This function gets the gravitational force between the other body 
     * and the current body.
     * Input: other planet
     * Output: gravitational force between the two planets.
     */
    public double force(Body other) {
        return G * this.m * other.m / (distanceTo(other) * 
                                        distanceTo(other));
    } 
     
    
    /* This function gets the x component of the gravitational force
     * between the other body and the current body.
     * Input: other planet
     * Output: x component of the gravitational force between the two planets.
     */
    public double forceX(Body other) { 
        return force(other) * distanceToX(other) / distanceTo(other);
    } 
     
    /* This function gets the y component of the gravitational force
     * between the other body and the current body.
     * Input: other planet
     * Output: y component of the gravitational force between the two planets.
     */
    public double forceY(Body other) { 
        return force(other) * distanceToY(other) / distanceTo(other);
    } 
 
    /* This function draws the appropriate picture using PennDraw.
     * Input: none
     * Output: none
     */
    public void draw() { 
        PennDraw.picture(this.px, this.py, this.img); 
    } 
     
    /* This function draws updates the position of the calling body.
     * Input: none
     * Output: none
     */ 
    public void move(double timeStep) { 
        px = px + timeStep * vx;
        py = py + timeStep * vy;
    } 
     
    /* This function updates the velocity of the calling body.
     * Input: none
     * Output: none
     */
    public void getAffectedBy(Body other, double timeStep) { 
        double ax = forceX(other) / this.m;
        double ay = forceY(other) / this.m;
        vx = vx + timeStep * ax;
        vy = vy + timeStep * ay;
    }     
} 
