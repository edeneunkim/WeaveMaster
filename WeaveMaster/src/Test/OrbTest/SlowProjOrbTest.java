package OrbTest;

import model.Orb.SlowProjOrb;
import model.Projectile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlowProjOrbTest {
    private Projectile p;
    private SlowProjOrb spOrb;
    public static int PROJ_DIAMETER = 10;
    public static final int ORB_DIAMETER = 10;
    public static int PROJ_SPEED = 2;

    @BeforeEach
    public void runBefore() {
        p = new Projectile(0, 0, PROJ_DIAMETER, PROJ_DIAMETER);
        spOrb = new SlowProjOrb(12, 12, ORB_DIAMETER, ORB_DIAMETER);
    }

    @Test
    public void testAction() {
        p.changeSpeed(4);
        spOrb.action(p);
        assertEquals(4, p.getXSpeed());
        assertEquals(4, p.getYSpeed());
    }

    @Test
    public void testActionMinimum() {
        spOrb.action(p);
        assertEquals(1, p.getXSpeed());
        assertEquals(1, p.getYSpeed());
    }
}
