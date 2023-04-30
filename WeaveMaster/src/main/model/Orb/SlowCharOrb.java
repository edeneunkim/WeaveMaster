package model.Orb;

import model.MainCharacter;

import java.awt.*;

/**
 * SlowCharOrb is a type of Orb that slows the MainCharacter's speed when MainCharacter touches the orb
 */
public class SlowCharOrb extends Orb {

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets SlowCharOrb dimensions
     * @param x  x position of orb
     * @param y  y position of orb
     * @param width  width of orb
     * @param height  height of orb
     */
    public SlowCharOrb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * REQUIRES: obj speed >= 1 after decrease
     * MODIFIES: obj
     * EFFECTS: decreases obj (MainCharacter) speed
     * @param obj  MainCharacter object whose speed is to be decreased
     */
    @Override
    public void action(Rectangle obj) {
        MainCharacter c = (MainCharacter) obj;
        if (c.getXSpeed() > 3 && c.getYSpeed() > 3) {
            c.changeSpeed(-2);
        } else {
            c.setX(1);
            c.setY(1);
        }
    }
}
