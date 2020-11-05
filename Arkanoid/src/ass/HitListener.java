package ass;

import sprites.Ball;
import sprites.Block;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit beingHit
     * @param hitter   hitter
     */
    void hitEvent(Block beingHit, Ball hitter);
}
