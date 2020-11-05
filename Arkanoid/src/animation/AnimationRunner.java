package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * AnimationRunner.
     *
     * @param g                g
     * @param framesPerSeconds framesPerSeconds
     */
    public AnimationRunner(GUI g, int framesPerSeconds) {
        this.gui = g;
        this.framesPerSecond = framesPerSeconds;
    }

    /**
     * Runs.
     *
     * @param animation animation
     */
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper();
        this.framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d, 1.0 / framesPerSecond);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}