package sprites;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class SpriteForLevel2 implements Sprite {

    /**
     * Draw On.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        //the setting
        d.setColor(new Color(5, 100, 200));
        d.fillRectangle(0, 0, 800, 600);

        //the lines
        for (int i = 0; i < 700; i++) {
            d.setColor(new Color(255, 225, 225));
            d.drawLine(150, 150, 0 + i, 300);
        }
        for (int i = 1; i <= 100; ++i) {
            d.setColor(new Color(255, 167, 46));
            d.drawLine(150, 150, (775 - 25) / 100 * i, 300);
        }

        //the circles
        d.setColor(new Color(245, 255, 125));
        d.fillCircle(150, 150, 80);
        d.setColor(new Color(255, 225, 225));
        d.fillCircle(150, 150, 75);
        d.setColor(new Color(255, 235, 37));
        d.fillCircle(150, 150, 70);
    }

    /**
     * Time Passed.
     * @param dt dt
     */
    public void timePassed(double dt) {

    }
}