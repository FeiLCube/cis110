/* Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218 
 * 
 * This class draws the background photo and planets, and calls
 * on the Body class to update planet velocities and positions as
 * well as draw the new positions after those are updated.
 */

public class Space { 
     
    /** 
     * DO NOT EDIT ANY CODE BELOW THIS LINE 
     *  
     * You will get a style warning that reads: 
     * "Variable '[some name]' must be private and have get/set methods." 
     * Ignore any style warnings of this form. Our tests rely on these 
     * variables being public. We will discuss public vs. private next week 
     * in class. You are not expected to know it now. 
     */ 
    public Body[] bodies; //array of Body objects in the space 
    public double radius; //radius of the universe 
     
    /* DO NOT EDIT ANY CODE ABOVE THIS LINE */ 
     
    /* Description: this constructor stores all of the planets into an array
     * Input: a filename (specifically solar_system.txt)
     * Output: none
     */ 
    public Space(String filename) { 
        In inStream = new In(filename);
        int numParticles = inStream.readInt();
        bodies = new Body[numParticles];
        radius = inStream.readDouble();
        PennDraw.setXscale(-radius, radius);
        PennDraw.setYscale(-radius, radius);
        for (int i = 0; i < numParticles; i++) {
            double m = inStream.readDouble();
            double px = inStream.readDouble();
            double py = inStream.readDouble();
            double vx = inStream.readDouble();
            double vy = inStream.readDouble();
            String img = inStream.readString();
            bodies[i] = new Body(m, px, py, vx, vy, img);
        }
    } 
     
    /** 
     * Description: returns a string representation of space for the purposes  
     * of printing. We have discussed toString methods in class. 
     *  
     * DO NOT EDIT THIS METHOD AT ALL! 
     */ 
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("" + bodies.length + "\n"); 
        sb.append(String.format("%.2e\n", radius) + "\n"); 
        for (int i = 0; i < bodies.length; i++) { 
            sb.append(bodies[i].toString() + "\n"); 
        } 
        return sb.toString(); 
    } 
     
    /* Description: Draws the background and each body.
     * Input: none
     * Output: none
     */
    public void draw() { 
        PennDraw.picture(0.0, 0.0, "starfield.jpg");
        for (int i = 0; i < bodies.length; i++) {
            bodies[i].draw();
        }
    } 
     
    /* Description: updates the velocity and position of a Body object.
     * Input: timeStep
     * Output: none
     */
    public void simulate(double timeStep) { 
        for (int i = 0; i < bodies.length; i++) {
            for (int k = 0; k < bodies.length; k++) {
                if (i == k) {
                    continue;
                } else {
                    bodies[i].getAffectedBy(bodies[k], timeStep);
                }
            }
        }
        
        for (int i = 0; i < bodies.length; i++) {
            bodies[i].move(timeStep);
        }
    }    
}