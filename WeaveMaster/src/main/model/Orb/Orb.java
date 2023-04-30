package model.Orb;

import java.awt.*;
import java.util.*;

/**
 * Orb class representing orb object that MainCharacter can interact with
 * to affect the game state, including increasing character size, projectile size,
 * character speed, and projectile speed and increases the user's points
 */
public abstract class Orb extends Rectangle {
    protected Random random;
    protected int timeAlive = 0; // counter used to determine when orb disappears if not interacted with

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets GrowCharOrb dimensions
     * @param x  x position of orb
     * @param y  y position of orb
     * @param width  width of orb
     * @param height  height of orb
     */
    public Orb(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();
    }

    /**
     * EFFECTS: draws the orb onto the application
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, width, height);
    }

    /**
     * EFFECTS: changes Orb color to black
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void changeColor(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, width, height);
    }

    /**
     * EFFECTS: returns the time counter
     * @return value of timeAlive counter
     */
    public int getTime() {
        return timeAlive;
    }

    /**
     * MODIFIES: this
     * EFFECTS: increments the timeAlive counter by 1
     */
    public void incTime() {
        timeAlive++;
    }

    // The action that the orb causes when touched by MainCharacter
    public abstract void action(Rectangle obj);
}
