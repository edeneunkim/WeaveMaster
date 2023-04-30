package model.Orb;

import model.Projectile;

import java.awt.*;

/**
 * SlowProjOrb is a type of Orb that slows the current projectiles' speed when MainCharacter touches the orb
 */
public class SlowProjOrb extends Orb {

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets SlowProjOrb dimensions
     * @param x  x position of orb
     * @param y  y position of orb
     * @param width  width of orb
     * @param height  height of orb
     */
    public SlowProjOrb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * REQUIRES: obj speed >= 1 after decrease
     * MODIFIES: obj
     * EFFECTS: decreases obj (Projectile) speed
     * @param obj  Projectile object whose speed is to be decreased
     */
    @Override
    public void action(Rectangle obj) {
        Projectile p = (Projectile) obj;
        if (p.getXSpeed() > 3 && p.getYSpeed() > 3) {
            p.changeSpeed(-2);
        } else {
            p.setX(1);
            p.setY(1);
        }
    }
}
