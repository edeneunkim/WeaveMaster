package model.Orb;

import java.awt.*;

/**
 * ShrinkCharOrb is a type of Orb that shrinks the MainCharacter's size when MainCharacter touches the orb
 */
public class ShrinkCharOrb extends Orb {

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets ShrinkCharOrb dimensions
     * @param x  x position of orb
     * @param y  y position of orb
     * @param width  width of orb
     * @param height  height of orb
     */
    public ShrinkCharOrb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * MODIFIES: obj
     * EFFECTS: decreases obj (MainCharacter) width and height
     * @param obj  MainCharacter object whose size is to be decreased
     */
    @Override
    public void action(Rectangle obj) {
        obj.width -= 5;
        obj.height -= 5;
    }
}
