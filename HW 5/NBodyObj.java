/* Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * 
 * Execution: java NBodyObj simulationTime timeStep filename
 * 
 * This class takes in three command line arguments, which enables
 * us to see an animation of a solar system in motion.
 */

public class NBodyObj {
    public static void main(String[] args) {
        double simulationTime = Double.parseDouble(args[0]);
        double timeStep = Double.parseDouble(args[1]);
        String filename = args[2];
        Space s = new Space(filename);
        s.draw();
        PennDraw.enableAnimation(30);
        for (double elapsedTime = 0; elapsedTime < simulationTime;
             elapsedTime += timeStep) {
            s.simulate(timeStep);
            s.draw();
            PennDraw.advance();
        }
        PennDraw.disableAnimation();
        System.out.println(s);
    }
}