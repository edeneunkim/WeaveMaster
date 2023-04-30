package model.Orb;

import java.awt.*;

/**
 * GrowProjOrb is a type of Orb that increases the current projectiles' size when MainCharacter touches the orb
 */
public class GrowProjOrb extends Orb {

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets GrowProjOrb dimensions
     * @param x  x position of orb
     * @param y  y position of orb
     * @param width  width of orb
     * @param height  height of orb
     */
    public GrowProjOrb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * MODIFIES: obj
     * EFFECTS: increases obj (Projectile) width and height
     * @param obj  Projectile object whose size is to be increased
     */
    @Override
    public void action(Rectangle obj) {
        obj.width += 5;
        obj.height += 5;
    }
}
