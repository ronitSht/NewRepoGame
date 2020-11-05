package animation;

import biuoop.DrawSurface;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public interface Animation {
    /**
     * Do one frame.
     *
     * @param d  DrawSurface
     * @param dt dt
     */
    void doOneFrame(DrawSurface d, double dt);

    /**
     * Stops.
     *
     * @return the running
     */
    boolean shouldStop();
}
