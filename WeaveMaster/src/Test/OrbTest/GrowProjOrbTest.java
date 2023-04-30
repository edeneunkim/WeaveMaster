package OrbTest;

import model.Projectile;
import model.Orb.GrowProjOrb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrowProjOrbTest {
    private Projectile p;
    private GrowProjOrb gpOrb;
    public static int PROJ_DIAMETER = 10;
    public static final int ORB_DIAMETER = 10;

    @BeforeEach
    public void runBefore() {
        p = new Projectile(0, 0, PROJ_DIAMETER, PROJ_DIAMETER);
        gpOrb = new GrowProjOrb(12, 12, ORB_DIAMETER, ORB_DIAMETER);
    }

    @Test
    public void testAction() {
        gpOrb.action(p);
        assertEquals(PROJ_DIAMETER + 5, p.width);
        assertEquals(PROJ_DIAMETER + 5, p.height);
    }
}
