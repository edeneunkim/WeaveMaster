package model;

import java.awt.event.KeyEvent;
import java.awt.*;

/**
 * MainCharacter is the character that the user controls using arrow or wasd keys
 */
public class MainCharacter extends Rectangle {
    public static int SPEED = 3;
    private int xSpeed;
    private int ySpeed;

    /**
     * REQUIRES: 0 <= x <= WIDTH (600); 0 <= y <= HEIGHT (500); width > 0; height > 0
     * EFFECTS: sets MainCharacter dimensions
     * @param x  x position of MainCharacter
     * @param y  y position of MainCharacter
     * @param width  width of MainCharacter
     * @param height  height of MainCharacter
     */
    public MainCharacter(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets speed and then moves in a direction based on key pressed
     * @param e  KeyEvent of key pressed
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            setY(-SPEED);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            setY(SPEED);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            setX(-SPEED);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            setX(SPEED);
        }

        if (xSpeed != 0 && ySpeed != 0) {
            xSpeed *= 0.7071; // diagonal speed using Pythagorean's Theorem
            ySpeed *= 0.7071;
        }
        yMove();
        xMove();
    }

    /**
     * MODIFIES: this
     * EFFECTS: stops MainCharacter movement
     * @param e  KeyEvent of key released
     */
    public void keyReleased(KeyEvent e) {
        setY(0);
        setX(0);
        yMove();
        xMove();
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets xSpeed to speed
     * @param speed the speed xSpeed is set to
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
     * MODIFIES: this
     * EFFECTS: moves x position
     */
    public void xMove() {
        x += xSpeed;
    }

    /**
     * MODIFIES: this
     * EFFECTS: moves y position
     */
    public void yMove() {
        y += ySpeed;
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
     * EFFECTS: changes speed by factor
     * @param factor  the factor that the speed will be increased/decreased by
     */
    public void changeSpeed(int factor) {
        SPEED += factor;
    }

    /**
     * EFFECTS: draws MainCharacter onto the application
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }

    /**
     * EFFECTS: changes MainCharacter color to black
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void changeColor(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, width, height);
    }
}
