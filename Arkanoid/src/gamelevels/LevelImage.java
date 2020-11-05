package gamelevels;

import biuoop.DrawSurface;

import java.awt.Color;
import java.awt.Image;

import sprites.Sprite;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class LevelImage implements Sprite {
    private Color color;
    private Image imageOfLevel;

    /**
     * LevelImage.
     *
     * @param color color
     */
    public LevelImage(Color color) {
        this.color = color;
    }

    /**
     * LevelImage.
     *
     * @param image imageOfLevel
     */
    public LevelImage(Image image) {
        this.imageOfLevel = image;
    }

    /**
     * drawOn.
     *
     * @param drawSurface drawSurface
     */
    public void drawOn(DrawSurface drawSurface) {
        if (this.imageOfLevel != null) {
            drawSurface.drawImage(0, 0, this.imageOfLevel);
        } else if (this.color != null) {
            drawSurface.setColor(this.color);
            drawSurface.fillRectangle(0, 0, 800, 600);
        }
    }

    /**
     * timePassed.
     *
     * @param dt dt
     */
    public void timePassed(double dt) {

    }
}
