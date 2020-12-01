/*Name: Fei Liu
 * Pennkey: liufei
 * Recitation: 218
 * */

//System.out.println(vxCurrent);
//System.out.println(fy);
//System.out.println(axCurrent);
//System.out.println(d);

public class NBody {
    public static void main(String[] args) {
        double simulationTime = Double.parseDouble(args[0]);
        double timeStep = Double.parseDouble(args[1]);
        String filename = args[2];
        System.out.println(simulationTime);
        System.out.println(timeStep);
        System.out.println(filename);
        
        In inStream = new In(filename);
        int numParticles = inStream.readInt();
        double radius = inStream.readDouble();
        double[] m = new double[numParticles];
        double[] px = new double[numParticles];
        double[] py = new double[numParticles];
        double[] vx = new double[numParticles];
        double[] vy = new double[numParticles];
        String[] img = new String[numParticles];
        
        for (int i = 0; i < numParticles; i++) {
            m[i] = inStream.readDouble();
            px[i] = inStream.readDouble();
            py[i] = inStream.readDouble();
            vx[i] = inStream.readDouble();
            vy[i] = inStream.readDouble();
            img[i] = inStream.readString();
        }
        
        PennDraw.setXscale(-radius, radius);
        PennDraw.setYscale(-radius, radius);
        PennDraw.picture(0.0, 0.0, "starfield.jpg");
        
        PennDraw.enableAnimation(30);
        
        double axCurrent = 0;
        double ayCurrent = 0;
        
        //time loop
        for (double j = 0; j < simulationTime; j = j + timeStep) {
            
            PennDraw.picture(0.0, 0.0, "starfield.jpg");
            //outer loop
            for (int i = 0; i < numParticles; i++) {
                
                //acceleration loop inner
                for (int l = 0; l < numParticles; l++) {
                    
                    if (l == i) {
                        continue;
                    }
                    
                    double G = 6.67e-11;
                    double dx = px[l] - px[i];
                    double dy = py[l] - py[i];
                    double d = Math.sqrt((dx * dx) + (dy * dy));
                    double fy = (((G * m[l]) / (d * d)) * m[i]) * (dy / d);
                    double fx = (((G * m[l]) / (d * d)) * m[i]) * (dx / d);
                    axCurrent += fx / m[i];
                    ayCurrent += fy / m[i];
                }
                
                vx[i] = vx[i] + axCurrent * timeStep;
                vy[i] = vy[i] + ayCurrent * timeStep;
                
                px[i] = px[i] + vx[i] * timeStep;
                py[i] = py[i] + vy[i] * timeStep;
                
                px[3] = 0;
                py[3] = 0;
                
                axCurrent = 0;
                ayCurrent = 0;
                
                PennDraw.picture(px[i], py[i], img[i]);
                
            }
            
            PennDraw.advance();
            
        }
        
        System.out.printf("%d\n", numParticles);
        System.out.printf("%.2e\n", radius);
        for (int i = 0; i < numParticles; i++) {
            System.out.printf("%12.5e %12.5e %12.5e %12.5e %12.5e %12s\n",
                              m[i], px[i], py[i], vx[i], vy[i], img[i]);
        }
    }
}