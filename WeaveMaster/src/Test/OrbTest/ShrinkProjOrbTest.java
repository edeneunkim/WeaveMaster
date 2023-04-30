package OrbTest;

import model.Orb.ShrinkProjOrb;
import model.Projectile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShrinkProjOrbTest {
    private Projectile p;
    private ShrinkProjOrb spOrb;
    public static int PROJ_DIAMETER = 10;
    public static final int ORB_DIAMETER = 10;

    @BeforeEach
    public void runBefore() {
        p = new Projectile(0, 0, PROJ_DIAMETER, PROJ_DIAMETER);
        spOrb = new ShrinkProjOrb(12, 12, ORB_DIAMETER, ORB_DIAMETER);
    }

    @Test
    public void testAction() {
        spOrb.action(p);
        assertEquals(PROJ_DIAMETER - 5, p.width);
        assertEquals(PROJ_DIAMETER - 5, p.height);
    }
}
