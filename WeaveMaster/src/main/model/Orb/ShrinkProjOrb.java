package model.Orb;

import java.awt.*;

/**
 * ShrinkCharOrb is a type of Orb that shrinks the current projectiles' size when MainCharacter touches the orb
 */
public class ShrinkProjOrb extends Orb {

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets ShrinkProjOrb dimensions
     * @param x  x position of orb
     * @param y  y position of orb
     * @param width  width of orb
     * @param height  height of orb
     */
    public ShrinkProjOrb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * MODIFIES: obj
     * EFFECTS: decreases obj (Projectile) width and height
     * @param obj  Projectile object whose size is to be decreased
     */
    @Override
    public void action(Rectangle obj) {
        obj.width -= 5;
        obj.height -= 5;
    }
}
