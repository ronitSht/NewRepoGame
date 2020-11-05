package game;

import geometry.Line;
import geometry.Point;
import sprites.Collidable;
import sprites.CollisionInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates the game environment.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class GameEnvironment {
    private List<Collidable> collidableList;

    /**
     * Initializes the collidableList.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<>();
    }

    /**
     * Add the given collidable to the environment.
     *
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }

    /**
     * Assume an object moving from line.start() to line.end(). If this object will not collide with any of the
     * collidables in this collection, return null. Else, return the information about the closest collision that is
     * going to occur.
     *
     * @param trajectory trajectory
     * @return CollisionInfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        int indexOfList = 0;
        List<Point> checkListPoints = new ArrayList<>();
        List<Collidable> checkListCollidables = new ArrayList<>();

        /*
         * if the collidable list is empty, it returns null.
         */
        if (this.collidableList.size() == 0) {
            return null;
        }

        /*
         * Runs through the collidables list and adds to the list of points the closest collision point with
         * each rectangle.
         */
        for (int i = 0; i < this.collidableList.size(); i++) {
            Collidable c = this.collidableList.get(i);
            Point collisionPointOther = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (collisionPointOther != null) {
                checkListPoints.add(collisionPointOther);
                checkListCollidables.add(this.collidableList.get(i));
            }
        }

        /*
         * Checks if the distance between the trajectory line and the collision point of the object is smaller,
         * and if yes the closest point is kept.
         */
        if (checkListPoints.size() != 0) {
            Point closestCollisionPoint2 = checkListPoints.get(0);
            for (int i = 0; i < checkListPoints.size(); i++) {
                Point collisionPointOther2 = checkListPoints.get(i);
                if (trajectory.start().distance(closestCollisionPoint2)
                        >= trajectory.start().distance(collisionPointOther2)) {
                    closestCollisionPoint2 = collisionPointOther2;
                }
            }

            /*
             * keeps the index of the closest object and then returns the closest object.
             */
            indexOfList = checkListPoints.indexOf(closestCollisionPoint2);
            return new CollisionInfo(closestCollisionPoint2, checkListCollidables.get(indexOfList));
        }
        return null;
    }

    /**
     * Collidable.
     *
     * @param c Collidable
     */
    public void removeCollidable(Collidable c) {
        this.collidableList.remove(c);
    }
}