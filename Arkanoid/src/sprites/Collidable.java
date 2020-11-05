package sprites;

import geometry.Point;
import geometry.Rectangle;

/**
 * This class creates the Collidable interface.
 *
 * @author Ronit Shternfeld
 * @version 23 April 2018
 */
public interface Collidable {

    /**
     * Return the "collision shape" of the object.
     *
     * @return getCollisionRectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param hitter          hitter
     * @param collisionPoint  collisionPoint
     * @param currentVelocity currentVelocity
     * @return the new velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}