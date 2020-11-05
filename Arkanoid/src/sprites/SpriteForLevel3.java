package sprites;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class SpriteForLevel3 implements Sprite {

    /**
     * Draw On.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        //the setting
        d.setColor(new Color(31, 255, 117));
        d.fillRectangle(0, 0, 800, 600);
        //the red rectangle
        d.setColor(Color.black);
        d.fillRectangle(60, 460, 200, 180);
        d.setColor(new Color(31, 255, 117));

        // the windows
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; ++j) {
                d.fillRectangle(30 + j * 18, 460 + j * 32, 10, 25);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; ++j) {
                d.fillRectangle(75 + j * 18, 460 + j * 32, 10, 25);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; ++j) {
                d.fillRectangle(120 + j * 18, 460 + j * 32, 10, 25);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; ++j) {
                d.fillRectangle(165 + j * 18, 460 + j * 32, 10, 25);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; ++j) {
                d.fillRectangle(210 + j * 18, 460 + j * 32, 10, 25);
            }
        }

        //the upper rectangles
        d.setColor(Color.gray);
        d.fillRectangle(90, 360, 20, 40);
        d.setColor(Color.gray);
        d.fillRectangle(95, 210, 10, 150);
        d.setColor(Color.red);
        d.fillRectangle(70, 400, 60, 60);

        //the circles
        d.setColor(new Color(255, 235, 37));
        d.fillCircle(100, 210, 9);
        d.setColor(new Color(255, 34, 24));
        d.fillCircle(100, 210, 7);
        d.setColor(Color.white);
        d.fillCircle(100, 210, 3);
    }

    /**
     * Time Passed.
     * @param dt dt
     */
    public void timePassed(double dt) {

    }
}
