package animation;

import ass.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class WinScreen implements Animation {
    private Counter scoreCounter;
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * @param counter        counter
     * @param keyboardSensor keyboardSensor
     */
    public WinScreen(Counter counter, KeyboardSensor keyboardSensor) {
        this.scoreCounter = counter;
        this.keyboard = keyboardSensor;
        this.stop = false;
    }

    /**
     * DoOneFrame.
     *
     * @param d DrawSurface
     * @param dt dt
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(new Color(255, 171, 52));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.red);
        d.drawText(160, 160, "You Win!", 110);
        d.drawText(170, d.getHeight() / 2, "Your score is " + this.scoreCounter.getValue(), 60);
        d.setColor(new Color(131, 34, 117));
        d.drawText(220, 500, "Press space to continue", 30);
       // d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.scoreCounter.getValue(), 40);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * ShouldStop.
     *
     * @return stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}