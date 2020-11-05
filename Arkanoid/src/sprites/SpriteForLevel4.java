package sprites;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class SpriteForLevel4 implements Sprite {

    /**
     * Draw On.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        //the setting
        d.setColor(new Color(5, 100, 200));
        d.fillRectangle(0, 0, 800, 600);

        // a cloud
        d.setColor(Color.white);
        for (int i = 0; i < 9; ++i) {
            d.drawLine(605 + i * 10, 540, 580 + i * 10, 600);
        }
        d.fillCircle(600, 520, 23);
        d.fillCircle(620, 560, 27);
        d.fillCircle(640, 530, 29);
        d.fillCircle(660, 550, 22);
        d.fillCircle(680, 540, 32);

        // a cloud
        d.setColor(Color.WHITE);
        for (int i = 0; i < 9; ++i) {
            d.drawLine(105 + i * 10, 420, 80 + i * 10, 600);
        }
        d.fillCircle(100, 420, 23);
        d.fillCircle(120, 440, 27);
        d.fillCircle(140, 410, 29);
        d.fillCircle(160, 440, 22);
        d.fillCircle(180, 420, 32);
    }

    /**
     * Time Passed.
     * @param dt dt
     */
    public void timePassed(double dt) {

    }
}