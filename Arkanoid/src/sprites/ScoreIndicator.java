package sprites;

import ass.Counter;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter;

    /**
     * Creates the ScoreIndicator.
     *
     * @param counter counter
     */
    public ScoreIndicator(Counter counter) {
        this.scoreCounter = counter;
    }

    /**
     * Draw On.
     *
     * @param drawSurface drawSurface
     */
    @Override
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLACK);
        drawSurface.drawText(350, 17, "Score: " + this.scoreCounter.getValue(), 18);
    }

    /**
     * The time passes.
     *
     * @param dt dt
     */
    public void timePassed(double dt) {

    }
}
