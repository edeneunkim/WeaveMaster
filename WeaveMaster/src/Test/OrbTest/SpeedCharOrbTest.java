package OrbTest;

import model.MainCharacter;
import model.Orb.SpeedCharOrb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeedCharOrbTest {
    private MainCharacter mc;
    private SpeedCharOrb scOrb;
    public static int CHAR_DIAMETER = 15;
    public static final int ORB_DIAMETER = 10;
    public static int SPEED = 3;

    @BeforeEach
    public void runBefore() {
        mc = new MainCharacter(0, 0, CHAR_DIAMETER, CHAR_DIAMETER);
        scOrb = new SpeedCharOrb(12, 12, ORB_DIAMETER, ORB_DIAMETER);
    }

    @Test
    public void testAction() {
        scOrb.action(mc);
        assertEquals(SPEED + 2, MainCharacter.SPEED);
        assertEquals(SPEED + 2, MainCharacter.SPEED);
    }
}
