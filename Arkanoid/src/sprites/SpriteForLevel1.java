package sprites;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class SpriteForLevel1 implements Sprite {

    /**
     * Draw On.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        //the setting
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 600);

        //the circles
        d.setColor(new Color(34, 39, 255));
        d.fillCircle(400, 165, 100);
        d.setColor(Color.BLACK);
        d.fillCircle(400, 165, 75);
        d.setColor(new Color(34, 39, 255));
        d.fillCircle(400, 165, 50);
        //the lines
        d.drawLine(400, 182, 400, 302);
        d.drawLine(420, 162, 540, 162);
        d.drawLine(380, 162, 260, 162);
        d.drawLine(400, 142, 400, 22);
    }

    /**
     * Time Passed.
     * @param dt dt
     */
    public void timePassed(double dt) {

    }
}
