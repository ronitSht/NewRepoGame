package sprites;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This class creates the collision information.
 *
 * @author Ronit Shternfeld
 * @version 30 Mars 2018
 */
public class LevelName implements Sprite {
    private String levelName;

    /**
     * LevelName.
     *
     * @param name name
     */
    public LevelName(String name) {
        this.levelName = name;
    }

    /**
     * Draw On.
     *
     * @param drawSurface drawSurface
     */
    @Override
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLACK);
        drawSurface.drawText(500, 17, "Level Name: " + levelName, 18);
    }

    /**
     * The time passes.
     *
     * @param dt dt
     */
    public void timePassed(double dt) {

    }
}