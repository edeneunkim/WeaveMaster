package ui;

import model.MainCharacter;
import model.Orb.*;
import model.Points;
import model.Projectile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the panel of the graphical user interface of WeaveMaster application
 */
public class Panel extends JPanel implements Runnable {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    public static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
    public static int CHAR_DIAMETER = 15;
    public static int PROJ_DIAMETER = 10;
    public static final int ORB_DIAMETER = 10;
    public static int MAX_PROJECTILES = 50;
    private Thread gameThread;
    private Random random;
    private MainCharacter c;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Orb> orbs;
    private Points points;
    private int currProjectiles = 3;
    private int currOrbs = 0;
    private int counter = 0;
    private static final String OVER = "Game Over!";
    private static final String REPLAY = "Press Space to replay";
    private boolean isOver = false;

    /**
     * Creates the panel that the game will be displayed on and sets the character, projectiles, and orb that will
     * appear in the game
     */
    public Panel() {
        projectiles = new ArrayList<>();
        orbs = new ArrayList<>();
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new ActionListener());
        setPreferredSize(SCREEN_SIZE);
        setUp();
    }

    /**
     * Sets up the game
     */
    public void setUp() {
        c = new MainCharacter((WIDTH / 2) - (CHAR_DIAMETER / 2), (HEIGHT / 2) - (CHAR_DIAMETER / 2), CHAR_DIAMETER,
                CHAR_DIAMETER);
        points = new Points(WIDTH, HEIGHT, 0);
        this.projectiles.clear();
        this.orbs.clear();
        currProjectiles = 3;
        currOrbs = 0;
        counter = 0;
        isOver = false;
        addProjectiles();
        addOrbs();
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Draws the game components (MainCharacter, Projectile, Orb) onto the panel
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        draw(g);
    }

    /**
     * Helper function for the paint function
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void draw(Graphics g) {
        c.draw(g);
        for (Projectile p : this.projectiles) {
            p.draw(g);
        }
        for (Orb o : this.orbs) {
            o.draw(g);
        }
        points.draw(g);
        if (isOver) {
            gameOver(g);
        }
    }

    /**
     * Performs action based on user key input
     */
    public class ActionListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            c.keyPressed(e);
            if (isOver && e.getKeyCode() == KeyEvent.VK_SPACE) {
                setUp();
            }
        }
        public void keyReleased(KeyEvent e) {
            c.keyReleased(e);
        }
    }

    /**
     * Runs the application and checks and updates the game state every cycle
     */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkWallCollisionChar();
                checkWallCollisionProj();
                checkOrbTouch();
                checkHit();
                updateState();
                repaint();
                delta--;
            }
        }
    }

    /**
     * Creates a Projectile object spawned at a random location moving towards a random direction
     * @return Projectile object to be added into the game
     */
    public Projectile createProjectile() {
        random = new Random();
        int x = random.nextInt(WIDTH - PROJ_DIAMETER);
        int y = random.nextInt(HEIGHT - PROJ_DIAMETER);
        int xOrY = random.nextInt(2); // 0 = x, 1 = y
        int upOrDown = random.nextInt(2); // 0 = up, 1 = down
        int leftOrRight = random.nextInt(2); // 0 = left, 1 = right
        Projectile proj;
        if (xOrY == 0) {
            if (leftOrRight == 0) {
                proj = new Projectile(0, y, PROJ_DIAMETER, PROJ_DIAMETER);
            } else {
                proj = new Projectile(WIDTH - PROJ_DIAMETER, y, PROJ_DIAMETER, PROJ_DIAMETER);
            }
        } else {
            if (upOrDown == 0) {
                proj = new Projectile(x, 0, PROJ_DIAMETER, PROJ_DIAMETER);
            } else {
                proj = new Projectile(x, HEIGHT - PROJ_DIAMETER, PROJ_DIAMETER, PROJ_DIAMETER);
            }
        }
        return proj;
    }

    /**
     * Adds a projectile into the game
     */
    public void addProjectiles() {
        int i = 0;
        while (i < currProjectiles) {
            projectiles.add(createProjectile());
            i++;
        }
    }

    /**
     * Creates an Orb object of a random orb type spawned at a random location
     * @return Orb object to be added into the game
     */
    public Orb createOrb() {
        random = new Random();
        int orbType = random.nextInt(8);
        int x = random.nextInt(WIDTH - ORB_DIAMETER);
        int y = random.nextInt(HEIGHT - ORB_DIAMETER);
        Orb orb = null;
        switch (orbType) {
            case 0:
                orb = new GrowCharOrb(x, y, ORB_DIAMETER, ORB_DIAMETER);
                break;
            case 1:
                orb = new ShrinkCharOrb(x, y, ORB_DIAMETER, ORB_DIAMETER);
                break;
            case 2:
                orb = new GrowProjOrb(x, y, ORB_DIAMETER, ORB_DIAMETER);
                break;
            case 3:
                orb = new ShrinkProjOrb(x, y, ORB_DIAMETER, ORB_DIAMETER);
                break;
            case 4:
                orb = new SpeedCharOrb(x, y, ORB_DIAMETER, ORB_DIAMETER);
                break;
            case 5:
                orb = new SlowCharOrb(x, y, ORB_DIAMETER, ORB_DIAMETER);
                break;
            case 6:
                orb = new SpeedProjOrb(x, y, ORB_DIAMETER, ORB_DIAMETER);
                break;
            case 7:
                orb = new SlowProjOrb(x, y, ORB_DIAMETER, ORB_DIAMETER);
                break;
        }
        return orb;
    }

    /**
     * Adds an orb into the game
     */
    public void addOrbs() {
        int i = 0;
        while (i < currOrbs) {
            this.orbs.add(createOrb());
            i++;
        }
    }

    /**
     * Removes an orb that is currently in the game based on how long they have been on the board without
     * being touched by MainCharacter
     */
    public void orbsToRemove() {
        ArrayList<Orb> removeOrb = new ArrayList<>();
        for (Orb o : this.orbs) {
            if (o.getTime() >= 349) {
                removeOrb.add(o);
            } else {
                o.incTime();
            }
        }
        if (removeOrb.size() != 0) {
            for (Orb o : removeOrb) {
                this.orbs.remove(o);
            }
        }
    }

    /**
     * Moves MainCharacter and all Projectiles
     */
    public void move() {
        c.yMove();
        c.xMove();
        for (Projectile p : this.projectiles) {
            p.move();
        }
    }

    /**
     * Checks if MainCharacter is within the board boundaries; if at the boundaries, ensures the character stays
     * within the boundaries
     */
    public void checkWallCollisionChar() {
        if (c.y <= 0) {
            c.y = 0;
        }
        if (c.y >= HEIGHT - c.height) {
            c.y = HEIGHT - c.height;
        }
        if (c.x <= 0) {
            c.x = 0;
        }
        if (c.x >= WIDTH - c.width) {
            c.x = WIDTH - c.width;
        }
    }

    /**
     * Checks if all projectiles are within the board boundaries; if a projectile touches the wall, bounces the
     * projectile towards the opposite direction
     */
    public void checkWallCollisionProj() {
        for (Projectile p : this.projectiles) {
            if (p.y <= 0 || p.y >= HEIGHT - PROJ_DIAMETER) {
                p.changeYDirection();
            }
            if (p.x <= 0 || p.x >= WIDTH - PROJ_DIAMETER) {
                p.changeXDirection();
            }
        }
    }

    /**
     * Checks if MainCharacter touched an orb; if so, activates the orb's effect onto the character or current
     * projectiles and removes the orb from the game
     */
    public void checkOrbTouch() {
        ArrayList<Orb> toRemove = new ArrayList<>();
        for (Orb o : this.orbs) {
            if (o.intersects(c)) {
                if (o.getClass() == GrowCharOrb.class || o.getClass() == ShrinkProjOrb.class ||
                        o.getClass() == SpeedCharOrb.class || o.getClass() == SlowCharOrb.class) {
                    o.action(c);
                } else {
                    for (Projectile p : this.projectiles) {
                        o.action(p);
                    }
                }
                toRemove.add(o);
                this.points.addPointsOrbTouch();
            }
        }

        for (Orb o : toRemove) {
           this.orbs.remove(o);
        }
    }

    /**
     * Checks if MainCharacter is touched by any projectile; if so, the game ends
     */
    public void checkHit() {
        for (Projectile p : this.projectiles) {
            if (p.intersects(c)) {
                isOver = true;
            }
        }
    }

    /**
     * Updates the game every certain number of cycles by adding projectiles and orbs or removing orbs
     */
    public void updateState() {
        if (currProjectiles < MAX_PROJECTILES) {
            if (counter % 251 == 0 && counter != 0) {
                this.projectiles.add(createProjectile());
                currProjectiles++;
            }
        }
        if (counter % 577 == 0 && counter != 0) {
            this.orbs.add(createOrb());
            currOrbs++;
        }

        if (counter % 13 == 0) {
            this.points.addPoints();
        }
        orbsToRemove();
        counter++;
    }

    /**
     * Ends the program and prints out the game over message
     * @param g  Graphics object
     */
    private void gameOver(Graphics g) {
        g.setFont(new Font("Courier-Plain", Font.PLAIN, 20));
        FontMetrics fm = g.getFontMetrics();
        c.changeColor(g);
        for (Projectile p : this.projectiles) {
            p.changeColor(g);
        }
        for (Orb o : this.orbs) {
            o.changeColor(g);
        }
        g.setColor(new Color( 255, 255, 255));
        centreString(OVER, g, fm, HEIGHT / 2);
        centreString("Points: " + this.points.getPoints(), g, fm, HEIGHT / 2 + 20);
        centreString(REPLAY, g, fm, HEIGHT / 2 + 40);
        gameThread.stop();
    }

    /**
     * Helper function for gameOver that centres string
     * @param str  string to be centred
     * @param g  Graphics object
     * @param fm  font parameters of string
     * @param yPos  y position of string
     */
    private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
        int width = fm.stringWidth(str);
        g.drawString(str, (WIDTH - width) / 2, yPos);
    }

}
