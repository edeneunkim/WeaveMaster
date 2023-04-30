package OrbTest;

import model.MainCharacter;
import model.Orb.GrowCharOrb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrowCharOrbTest {
    private MainCharacter mc;
    private GrowCharOrb gcOrb;
    public static int CHAR_DIAMETER = 15;
    public static final int ORB_DIAMETER = 10;

    @BeforeEach
    public void runBefore() {
        mc = new MainCharacter(0, 0, CHAR_DIAMETER, CHAR_DIAMETER);
        gcOrb = new GrowCharOrb(12, 12, ORB_DIAMETER, ORB_DIAMETER);
    }

    @Test
    public void testAction() {
        gcOrb.action(mc);
        assertEquals(CHAR_DIAMETER + 5, mc.width);
        assertEquals(CHAR_DIAMETER + 5, mc.height);
    }
}
