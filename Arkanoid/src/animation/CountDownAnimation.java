package animation;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import sprites.SpriteCollection;

import java.awt.Color;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class CountDownAnimation implements Animation {
    private boolean running;
    private double numberOfSeconds;
    private int startCountFrom;
    private SpriteCollection screen;
    private double timeMillis;
    private Sleeper sleeper = new Sleeper();
    private int count;

    /**
     * CountDownAnimation.
     *
     * @param numOfSeconds numOfSeconds
     * @param countFrom    countFrom
     * @param gameScreen   gameScreen
     */
    public CountDownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numberOfSeconds = numOfSeconds;
        this.startCountFrom = countFrom;
        this.screen = gameScreen;
        this.running = false;
        this.timeMillis = System.currentTimeMillis();
        this.count = countFrom;
    }

    /**
     * DoOneFrame.
     *
     * @param d  DrawSurface
     * @param dt dt
     */
    public void doOneFrame(DrawSurface d, double dt) {
        //the drawing
        this.screen.drawAllOn(d);
        //d.setColor(new Color(255, 86, 175));
        //d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        // the countdown numbers
        d.drawText(380, 420, Integer.toString(startCountFrom), 100);
        d.setColor(Color.white);
        d.drawText(380, 420, Integer.toString(startCountFrom), 100);
        long secondsToSleeper = (long) (numberOfSeconds * 1000 / count);
        //decreases the counter
        this.startCountFrom--;
        if (this.startCountFrom != 3) {
            sleeper.sleepFor(secondsToSleeper);
        }
    }

    /**
     * should Stop.
     *
     * @return true if startCountFrom smaller than 0, elsewise false.
     */
    public boolean shouldStop() {
        if (this.startCountFrom < 0) {
            return true;
        }
        return false;
    }
}
