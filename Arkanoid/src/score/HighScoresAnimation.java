package score;

import animation.Animation;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class HighScoresAnimation implements Animation {
    private HighScoresTable highScoresTable;
    private String key;
    private boolean stop;

    /**
     * HighScoresAnimation.
     *
     * @param scores scores
     * @param endKey endKey
     */
    public HighScoresAnimation(HighScoresTable scores, String endKey) {
        this.highScoresTable = scores;
        this.key = endKey;
        this.stop = false;
    }

    /**
     * doOneFrame.
     *
     * @param d  DrawSurface
     * @param dt dt
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(new Color(255, 174, 244));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new Color(255, 86, 175));
        d.drawText(90, 150, "High Score", 100);
        d.drawText(270, 200, "Player Name", 18);
        d.drawText(500, 200, "Score", 18);
        d.setColor(new Color(131, 34, 117));
        d.drawText(220, 550, "Press space to continue", 30);

        for (int i = 0; i < this.highScoresTable.getHighScores().size(); i++) {
            d.setColor(new Color(255, 86, 175));
            d.drawLine(230, 210 + i * 30, 560, 210 + i * 30);
            d.setColor(Color.black);
            d.drawText(230, 230 + i * 30, Integer.toString(i + 1), 16);
            d.drawText(270, 230 + i * 30, this.highScoresTable.getHighScores().get(i).getName(), 16);
            d.drawText(500, 230 + i * 30, Integer.toString(this.highScoresTable.getHighScores().get(i).getScore()),
                    14);
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
