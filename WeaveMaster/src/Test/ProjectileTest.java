import model.Projectile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectileTest {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    public static int PROJ_DIAMETER = 10;
    private Projectile p;
    private int x;
    private int y;

    @BeforeEach
    public void runBefore() {
        x = 0;
        y = 0;
        p = new Projectile(x, y, PROJ_DIAMETER, PROJ_DIAMETER);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, p.x);
        assertEquals(0, p.y);
        assertEquals(10, p.width);
        assertEquals(10, p.height);
    }

    @Test
    public void testXDirectionLeft() {
        p.xDirection();
        assertEquals(2, p.getXSpeed()); // since x = 0
    }

    @Test
    public void testXDirectionRight() {
        p.x = WIDTH - PROJ_DIAMETER;
        p.xDirection();
        assertEquals(-2, p.getXSpeed()); // since x = WIDTH - PROJ_DIAMETER
    }

    @Test
    public void testYDirectionUp() {
        p.yDirection();
        assertEquals(2, p.getYSpeed()); // since y = 0
    }

    @Test
    public void testYDirectionDown() {
        p.y = HEIGHT - PROJ_DIAMETER;
        p.yDirection();
        assertEquals(-2, p.getYSpeed());
    }

    @Test
    public void testMoveZero() {
        p.move();
        assertEquals(x + 2, p.x); // since x = 0
        assertEquals(y + 2, p.y); // since y = 0
    }

    @Test
    public void testMove() {
        p.x = 5;
        p.y = 5;
        p.move();
        assertTrue(p.x != 5 && p.y != 5); // make sure that at least x or y has changed
    }

    @Test
    public void testChangeXDirectionPositive() {
        p.changeXDirection();
        assertEquals(-2, p.getXSpeed());
    }

    @Test
    public void testChangeXDirectionNegative() {
        p.changeXDirection();
        p.changeXDirection();
        assertEquals(2, p.getXSpeed());
    }

    @Test
    public void testChangeYDirectionPositive() {
        p.changeYDirection();
        assertEquals(-2, p.getYSpeed());
    }

    @Test
    public void testChangeYDirectionNegative() {
        p.changeYDirection();
        p.changeYDirection();
        assertEquals(2, p.getYSpeed());
    }

    @Test
    public void testChangeSpeedPositive() {
        p.changeSpeed(10);
        assertEquals(12, p.getXSpeed());
        assertEquals(12, p.getYSpeed());
    }

    @Test
    public void testChangeSpeedNegative() {
        p.changeSpeed(-10);
        assertEquals(-8, p.getXSpeed());
        assertEquals(-8, p.getYSpeed());
    }

    @Test
    public void testChangeSpeedZero() {
        p.changeSpeed(0);
        assertEquals(2, p.getXSpeed());
        assertEquals(2, p.getYSpeed());
    }

    @Test
    public void testSetXNegative() {
        p.setX(-5);
        assertEquals(-5, p.getXSpeed());
    }

    @Test
    public void testSetXPositive() {
        p.setX(5);
        assertEquals(5, p.getXSpeed());
    }

    @Test
    public void testSetXZero() {
        p.setX(0);
        assertEquals(0, p.getXSpeed());
    }

    @Test
    public void testSetYNegative() {
        p.setY(-5);
        assertEquals(-5, p.getYSpeed());
    }

    @Test
    public void testSetYPositive() {
        p.setY(5);
        assertEquals(5, p.getYSpeed());
    }

    @Test
    public void testSetYZero() {
        p.setY(0);
        assertEquals(0, p.getYSpeed());
    }
}
