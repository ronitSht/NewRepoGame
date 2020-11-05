package sprites;

import geometry.Point;

/**
 * This class creates the collision information.
 *
 * @author Ronit Shternfeld
 * @version 30 Mars 2018
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collideObject;

    /**
     * Initializes the CollisionInfo.
     *
     * @param collisionPoint collisionPoint
     * @param collideObject  collideObject
     */
    public CollisionInfo(Point collisionPoint, Collidable collideObject) {
        this.collisionPoint = collisionPoint;
        this.collideObject = collideObject;
    }

    /**
     * The point at which the collision occurs.
     *
     * @return collisionPoint
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * The collidable object involved in the collision.
     *
     * @return collideObject
     */
    public Collidable collisionObject() {
        return this.collideObject;
    }
}