package ass;

import sprites.Ball;
import sprites.Block;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * ScoreTrackingListener.
     *
     * @param scoreCounter scoreCounter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * HitEvent.
     *
     * @param beingHit beingHit
     * @param hitter   hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() == 0) {
            this.currentScore.increase(10);
        } else {
            this.currentScore.increase(5);
        }
    }
}
