package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class KeyPressStoppableAnimation implements Animation {
    private boolean isAlreadyPressed;
    private boolean stop;
    private KeyboardSensor keyboard;
    private String keyStr;
    private Animation animations;
    private boolean nextPressIgnore;

    /**
     * KeyPressStoppableAnimation.
     *
     * @param sensor    sensor
     * @param key       key
     * @param animation animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.isAlreadyPressed = true;
        this.stop = false;
        this.keyboard = sensor;
        this.keyStr = key;
        this.animations = animation;
        this.nextPressIgnore = false;
    }

    /**
     * doOneFrame.
     *
     * @param drawSurface drawSurface
     * @param dt          dt
     */
    public void doOneFrame(DrawSurface drawSurface, double dt) {
        if (this.isAlreadyPressed) {
            this.nextPressIgnore = this.keyboard.isPressed(this.keyStr);
            this.isAlreadyPressed = false;
        }
        this.animations.doOneFrame(drawSurface, dt);
        if (this.keyboard.isPressed(this.keyStr)) {
            if (!this.nextPressIgnore) {
                this.stop = true;
            }
        } else {
            // if the key is not pressed
            this.nextPressIgnore = false;
        }
    }

    /**
     * shouldStop.
     *
     * @return stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
