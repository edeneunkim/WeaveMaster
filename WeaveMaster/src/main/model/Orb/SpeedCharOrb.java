package model.Orb;

import model.MainCharacter;

import java.awt.*;

/**
 * SpeedCharOrb is a type of Orb that increases the MainCharacter's speed when it touches the orb
 */
public class SpeedCharOrb extends Orb {

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets SpeedCharOrb dimensions
     * @param x  x position of orb
     * @param y  y position of orb
     * @param width  width of orb
     * @param height  height of orb
     */
    public SpeedCharOrb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * MODIFIES: obj
     * EFFECTS: increases obj (MainCharacter) speed
     * @param obj  MainCharacter object whose speed is to be increased
     */
    @Override
    public void action(Rectangle obj) {
        ((MainCharacter) obj).changeSpeed(2);
    }
}
