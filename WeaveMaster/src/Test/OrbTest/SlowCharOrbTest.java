package OrbTest;

import model.MainCharacter;
import model.Orb.SlowCharOrb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlowCharOrbTest {
    private MainCharacter mc;
    private SlowCharOrb scOrb;
    public static int CHAR_DIAMETER = 15;
    public static final int ORB_DIAMETER = 10;
    public static int SPEED = 3;

    @BeforeEach
    public void runBefore() {
        mc = new MainCharacter(0, 0, CHAR_DIAMETER, CHAR_DIAMETER);
        scOrb = new SlowCharOrb(12, 12, ORB_DIAMETER, ORB_DIAMETER);
    }

    @Test
    public void testAction() {
        MainCharacter.SPEED = 10;
        mc.setX(10);
        mc.setY(10);
        scOrb.action(mc);
        assertEquals(8, MainCharacter.SPEED);
    }

    @Test
    public void testActionMinimum() {
        scOrb.action(mc);
        assertEquals(1, mc.getXSpeed());
        assertEquals(1, mc.getYSpeed());
    }
}
