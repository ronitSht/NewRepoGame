package ass;

import sprites.Ball;
import sprites.Block;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class PrintingHitListener implements HitListener {
    /**
     * Prints.
     *
     * @param beingHit beingHit
     * @param hitter   hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block with " + beingHit.getHitPoints() + " points was hit.");
    }
}
