import static org.junit.Assert.*;
import org.junit.*;

public class BodyTest {
    Body test1;
    Body test2;
    @Before
    public void setup() {
        test1 = new Body(5.9740e+24, 1.4960e+11,  0.0000e+00, 
                         0.0000e+00, 2.9800e+04, "earth.gif");
        test2 = new Body(1.9890e+30, 0.0000e+00, 0.0000e+00,
                         0.0000e+00, 0.0000e+00, "sun.gif");
    }
    
    @Test
    public void testBody() {
        assertEquals(5.9740e+24, test1.m, 10e+22);
        assertEquals(1.4960e+11, test1.px, 10e+9);
        assertEquals(0.0000e+00, test1.py, 0.0);
        assertEquals(0.0000e+00, test1.vx, 0.0);
        assertEquals(2.9800e+04, test1.vy, 10e+2);
        assertEquals("earth.gif", test1.img);
    }
    
    @Test
    public void testDistanceToX() {
        assertEquals(-1.4960e+11, test1.distanceToX(test2), 10e+9);
        assertEquals(5.9740e+24, test1.m, 10e+22);
        assertEquals(1.4960e+11, test1.px, 10e+9);
        assertEquals(0.0000e+00, test1.py, 0.0);
        assertEquals(0.0000e+00, test1.vx, 0.0);
        assertEquals(2.9800e+04, test1.vy, 10e+2);
    }
    
    @Test
    public void testDistanceToY() {
        assertEquals(0.0, test1.distanceToY(test2), 0.0);
        assertEquals(5.9740e+24, test1.m, 10e+22);
        assertEquals(1.4960e+11, test1.px, 10e+9);
        assertEquals(0.0000e+00, test1.py, 0.0);
        assertEquals(0.0000e+00, test1.vx, 0.0);
        assertEquals(2.9800e+04, test1.vy, 10e+2);
    }
    
    @Test
    public void testDistance() {
        assertEquals(-1.4960e+11, test1.distanceToX(test2), 10e+9);
        assertEquals(5.9740e+24, test1.m, 10e+22);
        assertEquals(1.4960e+11, test1.px, 10e+9);
        assertEquals(0.0000e+00, test1.py, 0.0);
        assertEquals(0.0000e+00, test1.vx, 0.0);
        assertEquals(2.9800e+04, test1.vy, 10e+2);
    }
    
    @Test
    public void testForce() {
        assertEquals(3.541e+22, test1.force(test2), 10e+20);
        assertEquals(5.9740e+24, test1.m, 10e+22);
        assertEquals(1.4960e+11, test1.px, 10e+9);
        assertEquals(0.0000e+00, test1.py, 0.0);
        assertEquals(0.0000e+00, test1.vx, 0.0);
        assertEquals(2.9800e+04, test1.vy, 10e+2);
    }
    
    @Test
    public void testForceX() {
        assertEquals(-3.541e+22, test1.forceX(test2), 10e+20);
        assertEquals(5.9740e+24, test1.m, 10e+22);
        assertEquals(1.4960e+11, test1.px, 10e+9);
        assertEquals(0.0000e+00, test1.py, 0.0);
        assertEquals(0.0000e+00, test1.vx, 0.0);
        assertEquals(2.9800e+04, test1.vy, 10e+2);
    }
    
    @Test
    public void testForceY() {
        assertEquals(0, test1.forceY(test2), 10e+20);
        assertEquals(5.9740e+24, test1.m, 10e+22);
        assertEquals(1.4960e+11, test1.px, 10e+9);
        assertEquals(0.0000e+00, test1.py, 0.0);
        assertEquals(0.0000e+00, test1.vx, 0.0);
        assertEquals(2.9800e+04, test1.vy, 10e+2);
    }
    
    @Test
    public void testMove() {
        test1.move(3.0);
        assertEquals(1.496e+11, test1.px, 10e+9);
        assertEquals(8.940e+4, test1.py, 10e+2);
        assertEquals(5.9740e+24, test1.m, 10e+22);
        assertEquals(0.0000e+00, test1.vx, 0.0);
        assertEquals(2.9800e+04, test1.vy, 10e+2);
    }
    
    @Test
    public void testGetAffectedBy() {
        test1.getAffectedBy(test2, 2.0);
        assertEquals(-0.011, test1.vx, 0.001);
        assertEquals(2.980e+04, test1.vy, 10e+2);
        assertEquals(5.9740e+24, test1.m, 10e+22);
        assertEquals(1.4960e+11, test1.px, 10e+9);
        assertEquals(0.0000e+00, test1.py, 0.0);
    }
}





