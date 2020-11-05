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
public class LoseScreen implements Animation {
    private Counter scoreCounter;
    private boolean stop;
    private KeyboardSensor keyboard;

    /**
     * LoseScreen.
     *
     * @param counter        counter
     * @param keyboardSensor keyboardSensor
     */
    public LoseScreen(Counter counter, KeyboardSensor keyboardSensor) {
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
        d.setColor(new Color(28, 165, 127));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.WHITE);
        d.drawText(170, 160, "You Lost!", 90);
        d.drawText(100, d.getHeight() / 2, "Game Over. Your score is " + this.scoreCounter.getValue(), 40);
        d.setColor(new Color(131, 34, 117));
        d.drawText(220, 500, "Press space to continue", 30);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * ShouldStop.
     *
     * @return boolean stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
