package sprites;

import ass.HitListener;
import ass.HitNotifier;
import biuoop.DrawSurface;
import game.GameLevel;
import gamelevels.ColorsParser;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class creates the block.
 *
 * @author Ronit Shternfeld
 * @version 30 Mars 2018
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;
    private Image img;
    private int numOfHits;
    private int numOfHitsDownBlock;
    private List<HitListener> hitListeners = new ArrayList<>();
    private HashMap<Integer, ColorsParser> hashColor;
    private ColorsParser colOrIm;


    /**
     * Creates the block.
     *
     * @param rectangle rectangle
     * @param color     color
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }

    /**
     * Block.
     *
     * @param rectangle rectangle
     * @param image     image
     */
    public Block(Rectangle rectangle, Image image) {
        this.rectangle = rectangle;
        this.img = image;
    }

    /**
     * Block.
     *
     * @param rectangle rectangle
     * @param color     color
     * @param hashCol   hashCol
     * @param numOfHit  numOfHit
     */
    public Block(Rectangle rectangle, Color color, HashMap<Integer, ColorsParser> hashCol, int numOfHit) {
        this.rectangle = rectangle;
        this.color = color;
        this.numOfHits = numOfHit;
        this.hashColor = hashCol;
    }

    /**
     * Block.
     *
     * @param rectangle rectangle
     * @param hashCol   hashCol
     * @param numOfHit  numOfHit
     */
    public Block(Rectangle rectangle, HashMap<Integer, ColorsParser> hashCol, int numOfHit) {
        this.rectangle = rectangle;
        this.numOfHits = numOfHit;
        this.hashColor = hashCol;
    }

    /**
     * Return the "collision shape" of the object.
     *
     * @return this.rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param hitter          hitter
     * @param collisionPoint  collisionPoint
     * @param currentVelocity currentVelocity
     * @return the new velocity if a hit had happened.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line[] linesArray = this.rectangle.linesArray();
        // makes the blocks to be removed
        this.numOfHits--;
        this.notifyHit(hitter);
        // each time the ball hits the block the counter decreases until it becomes X


        /*
         * checks if the collision point is on the rectangle's line, and if yes the ball changes velocity.
         */
        if (collisionPoint != null) {
            if (linesArray[0].isPointOnTheLine(collisionPoint, linesArray[0])) {
                return new Velocity((-1) * (currentVelocity.getDx()), currentVelocity.getDy());
            }
            if (linesArray[1].isPointOnTheLine(collisionPoint, linesArray[1])) {
                return new Velocity((-1) * (currentVelocity.getDx()), currentVelocity.getDy());
            }
            if (linesArray[2].isPointOnTheLine(collisionPoint, linesArray[2])) {
                return new Velocity((currentVelocity.getDx()), ((-1) * currentVelocity.getDy()));
            }
            if (linesArray[3].isPointOnTheLine(collisionPoint, linesArray[3])) {
                return new Velocity((currentVelocity.getDx()), ((-1) * currentVelocity.getDy()));
            }
        }
        return currentVelocity;
    }

    /**
     * Draws the rectangles and fills them in colors.
     *
     * @param surface surface
     */
    @Override
    public void drawOn(DrawSurface surface) {
        Point upperLeft = this.getCollisionRectangle().getUpperLeft();
        double width = this.getCollisionRectangle().getWidth();
        double height = this.getCollisionRectangle().getHeight();
        if (hashColor == null) {
            surface.setColor(Color.gray);
            surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
            return;
        }
        /*
         * draws the rectangles
         */
        //if ((this.color == null) && (this.img == null)) {
        //    surface.setColor(color.black);
        //    surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
        //}
        //ColorsParser colorsParser = new ColorsParser(color);
        if (this.numOfHits >= 0) {
            if (hashColor.get(this.numOfHits).getColor() != null) {
                surface.setColor(hashColor.get(numOfHits).getColor());
                surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
                surface.setColor(Color.BLACK);
                surface.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
            } else {
                surface.drawImage((int) upperLeft.getX(), (int) upperLeft.getY(),
                        hashColor.get(this.numOfHits).getImage());
                surface.setColor(Color.BLACK);
                surface.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
            }
        }
    }
    /**
     * Notify the sprite that time has passed.
     *
     * @param dt dt
     */
    public void timePassed(double dt) {
        return;
    }

    /**
     * Adds to game.
     *
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Initializes the numOfHits argument.
     *
     * @param numHits number of hits
     */
    public void setNumOfHits(int numHits) {
        this.numOfHits = numHits;
    }

    /**
     * GetHitPoints.
     *
     * @return numOfHits
     */
    public int getHitPoints() {
        return this.numOfHits;
    }

    /**
     * GetHitPointsDownBlock.
     *
     * @return numOfHitsDownBlock
     */
    public int getHitPointsDownBlock() {
        return this.numOfHitsDownBlock;
    }

    /**
     * Remove From Game.
     *
     * @param game game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * Notify Hit.
     *
     * @param hitter hitter
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Add Hit Listener.
     *
     * @param hl hl
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * RemoveHitListener.
     *
     * @param hl hl
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}