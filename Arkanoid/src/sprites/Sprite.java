package sprites;

import biuoop.DrawSurface;

/**
 * This class creates the Spreite interface.
 *
 * @author Ronit Shternfeld
 * @version 23 April 2018
 */
public interface Sprite {

    /**
     * Draw the sprite to the screen.
     *
     * @param d DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * Notify the sprite that time has passed.
     * @param dt dt
     */
    void timePassed(double dt);
}