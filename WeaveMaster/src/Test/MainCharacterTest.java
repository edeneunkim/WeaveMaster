import model.MainCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainCharacterTest {
    public static int CHAR_DIAMETER = 15;
    private MainCharacter mc;
    private int x;
    private int y;

    @BeforeEach
    public void runBefore() {
        x = 0;
        y = 0;
        mc = new MainCharacter(x, y, CHAR_DIAMETER, CHAR_DIAMETER);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, mc.x);
        assertEquals(0, mc.y);
        assertEquals(15, mc.width);
        assertEquals(15, mc.height);
    }

    @Test
    public void testSetXPositive() {
        mc.setX(5);
        assertEquals(5, mc.getXSpeed());
    }

    @Test
    public void testSetXNegative() {
        mc.setX(-5);
        assertEquals(-5, mc.getXSpeed());
    }

    @Test
    public void testSetXZero() {
        mc.setX(0);
        assertEquals(0, mc.getXSpeed());
    }

    @Test
    public void testSetYPositive() {
        mc.setY(5);
        assertEquals(5, mc.getYSpeed());
    }

    @Test
    public void testSetYNegative() {
        mc.setY(-5);
        assertEquals(-5, mc.getYSpeed());
    }

    @Test
    public void testSetYZero() {
        mc.setY(0);
        assertEquals(0, mc.getYSpeed());
    }

    @Test
    public void testChangeSpeedPositive() {
        mc.changeSpeed(10);
        assertEquals(13, MainCharacter.SPEED);
    }

    @Test
    public void testChangeSpeedNegative() {
        MainCharacter.SPEED = 3;
        mc.changeSpeed(-10);
        assertEquals(-7, MainCharacter.SPEED);
    }

    @Test
    public void testChangeSpeedZero() {
        mc.changeSpeed(0);
        assertEquals(3, MainCharacter.SPEED);
    }
}
