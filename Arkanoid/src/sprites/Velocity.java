package sprites;

import geometry.Point;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Initializes the velocity.
     *
     * @param dx position on the `x` axe
     * @param dy position on the `y` axe
     */
    public Velocity(double dx, double dy) {
        this.dx = Math.round(dx);
        this.dy = Math.round(dy);
    }

    /**
     * Returns the dx value.
     *
     * @return dx value
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Returns the dy value.
     *
     * @return dy value
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Takes a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p  a point
     * @param dt dt
     * @return the new point with the new position
     */
    public Point applyToPoint(Point p, double dt) {
        return new Point(p.getX() + dx * dt, p.getY() + dy * dt);
    }

    /**
     * Velocity of the ball in another way with angles sin and cos.
     *
     * @param angle angle
     * @param speed speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * (Math.sin(Math.toRadians(angle)));
        double dy = (-1) * speed * (Math.cos(Math.toRadians(angle)));
        return new Velocity(dx, dy);
    }
}