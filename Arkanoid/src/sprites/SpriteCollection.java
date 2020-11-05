package sprites;


import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates the SpriteCollection.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class SpriteCollection {
    private List<Sprite> spriteList = new ArrayList<>();

    /**
     * Adds the sprites to the list.
     *
     * @param s sprites
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * Call timePassed() on all sprites.
     *
     * @param dt dt
     */
    public void notifyAllTimePassed(double dt) {
        if (this.spriteList != null) {
            for (int i = 0; i < this.spriteList.size(); i++) {
                this.spriteList.get(i).timePassed(dt);
            }
        }
    }

    /**
     * Call drawOn(d) on all sprites.
     *
     * @param d surface
     */
    public void drawAllOn(DrawSurface d) {
        if (this.spriteList != null) {
            for (int i = 0; i < this.spriteList.size(); i++) {
                this.spriteList.get(i).drawOn(d);
            }
        }
    }

    /**
     * Remove Sprite.
     *
     * @param s spriteList
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }
}