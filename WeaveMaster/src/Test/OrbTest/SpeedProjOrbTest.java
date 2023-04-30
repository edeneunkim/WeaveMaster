package OrbTest;

import model.Orb.SpeedProjOrb;
import model.Projectile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeedProjOrbTest {
    private Projectile p;
    private SpeedProjOrb spOrb;
    public static int PROJ_DIAMETER = 10;
    public static final int ORB_DIAMETER = 10;
    public static int PROJ_SPEED = 2;

    @BeforeEach
    public void runBefore() {
        p = new Projectile(0, 0, PROJ_DIAMETER, PROJ_DIAMETER);
        spOrb = new SpeedProjOrb(12, 12, ORB_DIAMETER, ORB_DIAMETER);
    }

    @Test
    public void testAction() {
        spOrb.action(p);
        assertEquals(PROJ_SPEED + 2, p.getXSpeed());
        assertEquals(PROJ_SPEED + 2, p.getYSpeed());
    }
}
