package OrbTest;

import model.Orb.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrbTest {
    public static final int ORB_DIAMETER = 10;
    private Orb o1, o2, o3, o4, o5, o6, o7, o8;
    private ArrayList<Orb> orbs;

    @BeforeEach
    public void runBefore() {
        o1 = new GrowCharOrb(0, 0, ORB_DIAMETER, ORB_DIAMETER);
        o2 = new GrowProjOrb(10, 10, ORB_DIAMETER, ORB_DIAMETER);
        o3 = new ShrinkCharOrb(20, 20, ORB_DIAMETER, ORB_DIAMETER);
        o4 = new ShrinkProjOrb(30, 30, ORB_DIAMETER, ORB_DIAMETER);
        o5 = new SlowCharOrb(40, 40, ORB_DIAMETER, ORB_DIAMETER);
        o6 = new SlowProjOrb(50, 50, ORB_DIAMETER, ORB_DIAMETER);
        o7 = new SpeedCharOrb(60, 60, ORB_DIAMETER, ORB_DIAMETER);
        o8 = new SpeedProjOrb(70, 70, ORB_DIAMETER, ORB_DIAMETER);
        orbs = new ArrayList<>();
        orbs.add(o1);
        orbs.add(o2);
        orbs.add(o3);
        orbs.add(o4);
        orbs.add(o5);
        orbs.add(o6);
        orbs.add(o7);
        orbs.add(o8);
    }

    @Test
    public void testConstructor() {
        for (int i = 0; i < orbs.size(); i++) {
            assertEquals(i * 10, orbs.get(i).x);
            assertEquals(i * 10, orbs.get(i).y);
            assertEquals(ORB_DIAMETER, orbs.get(i).width);
            assertEquals(ORB_DIAMETER, orbs.get(i).height);
        }
    }

    @Test
    public void testIncTime() {
        for (Orb o : orbs) {
            o.incTime();
        }

        for (Orb o : orbs) {
            assertEquals(1, o.getTime());
        }
    }

    @Test
    public void testIncTimeMultipleTimes() {
        for (Orb o : orbs) {
            o.incTime();
            o.incTime();
            o.incTime();
        }

        for (Orb o : orbs) {
            assertEquals(3, o.getTime());
        }
    }
}
