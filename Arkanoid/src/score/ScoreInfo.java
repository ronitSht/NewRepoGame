package score;

import java.io.Serializable;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class ScoreInfo implements Serializable {
    private String userName;
    private int scores;

    /**
     * ScoreInfo.
     *
     * @param name  name
     * @param score score
     */
    public ScoreInfo(String name, int score) {
        this.userName = name;
        this.scores = score;
    }

    /**
     * getName.
     *
     * @return userName
     */
    public String getName() {
        return this.userName;
    }

    /**
     * getScore.
     *
     * @return scores
     */
    public int getScore() {
        return this.scores;
    }
}
