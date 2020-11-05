package sprites;

import ass.Counter;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This class creates the collision information.
 *
 * @author Ronit Shternfeld
 * @version 30 Mars 2018
 */
public class LivesIndicator implements Sprite {

    /**
     * Creates the LivesIndicator.
     *
     * @param counter counter
     */
    private Counter livesCounter;

    /**
     * LivesIndicator.
     *
     * @param counter counter
     */
    public LivesIndicator(Counter counter) {
        this.livesCounter = counter;
    }

    /**
     * Draw On.
     *
     * @param drawSurface drawSurface
     */
    @Override
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLACK);
        drawSurface.drawText(100, 17, "Lives: " + this.livesCounter.getValue(), 18);
    }

    /**
     * The time passes.
     *
     * @param dt dt
     */
    public void timePassed(double dt) {

    }
}

