package model;

import java.awt.*;

/**
 * Points is responsible for showing the amount of points the user has and increasing the number of points based
 * on the user's actions in-game
 */
public class Points extends Rectangle {
    private int points;

    /**
     * EFFECTS: sets Points dimensions
     * @param width  width of Points (width of board)
     * @param height  height of Points (height of board)
     * @param points  starting amount of points
     */
    public Points(int width, int height, int points) {
        this.width = width;
        this.height = height;
        this.points = points;
    }

    /**
     * EFFECTS: increments points
     */
    public void addPoints() {
        this.points++;
    }

    /**
     * EFFECTS: increases points by 25
     */
    public void addPointsOrbTouch() {
        this.points += 25;
    }

    /**
     * EFFECTS: returns the amount of points
     * @return the number of points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * EFFECTS: draws Points onto the application
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier-Plain", Font.PLAIN, 20));
        g.drawString(String.valueOf(this.points), 5, 20);
    }
}
