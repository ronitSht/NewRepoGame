package sprites;

import biuoop.DrawSurface;
import game.GameEnvironment;
import game.GameLevel;
import geometry.Line;
import geometry.Point;

import java.awt.Color;

/**
 * This class creates the ball and it's abilities.
 *
 * @author Ronit Shternfeld
 * @version 30 Mars 2018
 */
public class Ball implements Sprite {

    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * The constructor initializes the center point of the ball, it's radius and it's color.
     *
     * @param center the center of the ball
     * @param r      the radius of the ball
     * @param color  the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
    }

    /**
     * Returns the x value of the center.
     *
     * @return the x value of the center
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Returns the y value of the center.
     *
     * @return the y value of the center
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Returns the radius size.
     *
     * @return the radius
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Returns the color of the ball.
     *
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Initializes the game environment.
     *
     * @param gameEnviron gameEnvironment
     */
    public void setGameEnvironment(GameEnvironment gameEnviron) {
        this.gameEnvironment = gameEnviron;
    }

    /**
     * Draws the ball on the given DrawSurface.
     *
     * @param surface the surface that will be drawn on
     */
    public void drawOn(DrawSurface surface) {
        this.color = this.getColor();
        surface.setColor(color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * Initializes the velocity of the ball.
     *
     * @param v velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets the velocity of the ball.
     *
     * @param dx the progress in the x
     * @param dy the progress in the y
     * @return velocity
     */
    public Velocity setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
        return velocity;
    }

    /**
     * Returns the velocity of the ball.
     *
     * @return the velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * In each time that the ball progresses it checks if it passes through the limits of the frame from each
     * direction, and if it reaches to the limits, it changes direction.
     *
     * @param dt dt
     */
    public void moveOneStep(double dt) {
        Line trajectory = new Line(this.center, new Point(this.center.getX() + 2 * this.velocity.getDx() * dt,
                this.center.getY() + 2 * this.velocity.getDy() * dt));
        CollisionInfo collisionInGame = this.gameEnvironment.getClosestCollision(trajectory);
        //no collision with object
        if (collisionInGame == null) {
            this.center = this.getVelocity().applyToPoint(this.center, dt);
        } else {
            // if there is a hit, it will use the hit method and change direction
            this.velocity = collisionInGame.collisionObject().hit(this, collisionInGame.collisionPoint(), velocity);
            this.center = this.getVelocity().applyToPoint(this.center, dt);
        }
    }

    /**
     * Notify the sprite that time has passed.
     *
     * @param dt dt
     */
    public void timePassed(double dt) {
        this.moveOneStep(dt);
    }

    /**
     * Adds the ball to the game.
     *
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove From Game.
     *
     * @param g GameLevel
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}