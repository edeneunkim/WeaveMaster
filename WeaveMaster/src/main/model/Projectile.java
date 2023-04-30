package model;

import java.awt.*;
import java.util.*;

/**
 * Projectile is a projectile that the user needs to avoid touching with their MainCharacter
 */
public class Projectile extends Rectangle {
    public static int PROJ_SPEED = 2;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    private int xSpeed;
    private int ySpeed;
    private Random random;

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets Projectile dimensions
     * @param x  x position of Projectile
     * @param y  y position of Projectile
     * @param width  width of Projectile
     * @param height  height of Projectile
     */
    public Projectile(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();
        xDirection();
        yDirection();
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets horizontal direction that Projectile will face towards
     */
    public void xDirection() {
        int randX = random.nextInt(3);
        if (randX == 0) { // 0: no horizontal movement
            xSpeed = randX;
        }
        if (randX == 1 || x == 0) { // 1: moves rightwards
            xSpeed = PROJ_SPEED;
            if (x == 0) {
                return;
            }
        }
        if (randX == 2 || x == WIDTH - 10) { // 2: moves leftwards
            xSpeed = -PROJ_SPEED;
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets vertical direction that Projectile will face towards
     */
    public void yDirection() {
        int randY = random.nextInt(3);
        if (randY == 0) { // 0: no vertical movement
            ySpeed = randY;
        }
        if (randY == 1 || y == 0) { // 1: moves downwards
            ySpeed = PROJ_SPEED;
            if (y == 0) {
                return;
            }
        }
        if (randY == 2 || y == HEIGHT - 10) { // 2: moves upwards
            ySpeed = -PROJ_SPEED;
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: moves Projectile object based on its x and y speed values
     */
    public void move() {
        if (xSpeed == 0 && ySpeed == 0) { // no movement at all, so reset x and y directions
            xDirection();
            yDirection();
        }
        x += xSpeed;
        y += ySpeed;
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets Projectile object to move opposite to its current horizontal direction
     */
    public void changeXDirection() {
        xSpeed *= -1;
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets Projectile object to move opposite to its current vertical direction
     */
    public void changeYDirection() {
        ySpeed *= -1;
    }

    /**
     * MODIFIES: this
     * EFFECTS: changes the horizontal and vertical speed by factor
     * @param factor  the factor that the speed will change by
     */
    public void changeSpeed(int factor) {
        xSpeed += factor;
        ySpeed += factor;
    }

    /**
     * EFFECTS: gets horizontal speed
     * @return value of horizontal speed
     */
    public int getXSpeed() {
        return xSpeed;
    }

    /**
     * EFFECTS: gets vertical speed
     * @return value of vertical speed
     */
    public int getYSpeed() {
        return ySpeed;
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets xSpeed to speed
     * @param speed  the speed xSpeed is set to
     */
    public void setX(int speed) {
        xSpeed = speed;
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets ySpeed to speed
     * @param speed  the speed ySpeed is set to
     */
    public void setY(int speed) {
        ySpeed = speed;
    }

    /**
     * EFFECTS: draws Projectile onto the application
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }

    /**
     * EFFECTS: changes Projectile color to black
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void changeColor(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, width, height);
    }
}
