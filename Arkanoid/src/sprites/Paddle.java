package sprites;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.GameLevel;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;

/**
 * This class creates the paddle.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Color color;
    private Block paddle;
    private int paddleSpeed;

    /**
     * @param paddleUpperLeft paddleUpperLeft
     * @param width           width
     * @param height          height
     * @param keyboard        keyboard
     * @param color           color
     * @param speed           speed
     */
    public Paddle(Point paddleUpperLeft, int width, int height, KeyboardSensor keyboard, Color color, int speed) {
        Rectangle rectanglePaddle = new Rectangle(paddleUpperLeft, width, height);
        this.paddle = new Block(rectanglePaddle, color);
        this.paddleSpeed = speed;
        this.color = color;
        this.keyboard = keyboard;
    }

    /**
     * Makes the paddle move left.
     *
     * @param dt dt
     */
    public void moveLeft(double dt) {
        if (this.getUpperLeft().getX() > 20) {
            Point newUpperLeft = new Point(this.getUpperLeft().getX() - this.paddleSpeed * dt,
                    this.getUpperLeft().getY());
            getCollisionRectangle().setUpperLeft(newUpperLeft);
        }
    }

    /**
     * Makes the paddle move right.
     *
     * @param dt dt
     */
    public void moveRight(double dt) {
        if (this.getUpperLeft().getX() < 780 - this.getWidth()) {
            Point newUpperLeft = new Point(this.getUpperLeft().getX() + this.paddleSpeed * dt,
                    this.getUpperLeft().getY());
            this.getCollisionRectangle().setUpperLeft(newUpperLeft);
        }
    }

    /**
     * Makes the keyboard recognize the left and right on the keyboard.
     *
     * @param dt dt
     */
    public void timePassed(double dt) {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft(dt);
        } else if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight(dt);
        }
    }

    /**
     * Draws the paddle.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        double width = this.getCollisionRectangle().getWidth();
        double height = this.getCollisionRectangle().getHeight();
        d.fillRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY(), (int) width, (int) height);
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY(), (int) width, (int) height);
    }

    /**
     * Returns the collission rectangle.
     *
     * @return collission rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }

    /**
     * When the ball hits the paddle, it will change direction (angle) according to the place the ball collided the
     * paddle.
     *
     * @param hitter          hitter
     * @param collisionPoint  collisionPoint
     * @param currentVelocity currentVelocity
     * @return the velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        Velocity velocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());

        /*
         * When the ball hits the paddle, it will change direction (angle) according to the place the ball collided
         * the paddle.
         */
        for (int i = 1; i < 6; i++) {
            if ((collisionPoint.getX() >= (this.getUpperLeft().getX() + (this.getWidth() / 5) * (i - 1)))
                    && (collisionPoint.getX() < (this.getUpperLeft().getX() + (this.getWidth() / 5) * (i)))) {
                velocity = Velocity.fromAngleAndSpeed(300 + (i - 1) * 30, speed);
            }
        }
        return velocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * Returns the upper left point of the rectangle.
     *
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return getCollisionRectangle().getUpperLeft();
    }

    /**
     * Gets height.
     *
     * @return the rectangle's height
     */
    public double getHeight() {
        return getCollisionRectangle().getHeight();
    }

    /**
     * Gets width.
     *
     * @return the rectangle's width
     */
    public double getWidth() {
        return getCollisionRectangle().getWidth();
    }
}