package model.Orb;

import model.Projectile;

import java.awt.*;

/**
 * SpeedProjOrb is a type of Orb that increases the current projectiles' speed when MainCharacter touches the orb
 */
public class SpeedProjOrb extends Orb {

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets SpeedProjOrb dimensions
     * @param x  x position of orb
     * @param y  y position of orb
     * @param width  width of orb
     * @param height  height of orb
     */
    public SpeedProjOrb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * MODIFIES: this
     * EFFECTS: increases obj (Projectile) speed
     * @param obj  Projectile object whose speed is to be increased
     */
    @Override
    public void action(Rectangle obj) {
        ((Projectile) obj).changeSpeed(2);
    }
}
