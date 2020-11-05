package gamelevels;

import sprites.Block;
import sprites.Sprite;
import sprites.Velocity;

import java.util.List;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public interface LevelInformation {

    /**
     * NumberOfBalls.
     *
     * @return numberOfBalls
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball. Note that initialBallVelocities().size() == numberOfBalls().
     *
     * @return velocityList
     */
    List<Velocity> initialBallVelocities();

    /**
     * PaddleSpeed.
     *
     * @return paddleSpeed
     */
    int paddleSpeed();

    /**
     * PaddleWidth.
     *
     * @return paddleWidth
     */
    int paddleWidth();

    /**
     * The level name will be displayed at the top of the screen.
     *
     * @return levelName
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return SpriteForLevel1
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return blockList
     */
    List<Block> blocks();

    /**
     * Number of levels that should be removed before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return blocks - the array size
     */
    int numberOfBlocksToRemove();

    /**
     * setPaddleSpeed.
     *
     * @param paddleSpeed paddleSpeed
     */
    void setPaddleSpeed(int paddleSpeed);

    /**
     * setNumBlocks.
     *
     * @param numBlocks numBlocks
     */
    void setNumBlocks(int numBlocks);

    /**
     * setBlocks.
     *
     * @param blocksList blocksList
     */
    void setBlocks(List<Block> blocksList);

    /**
     * setLevelName.
     *
     * @param string string
     */
    void setLevelName(String string);

    /**
     * setVelocities.
     *
     * @param velList velList
     */
    void setVelocities(List<Velocity> velList);

    /**
     * setBackground.
     *
     * @param background background
     */
    void setBackground(ColorsParser background);

    /**
     * setPaddleWidth.
     *
     * @param paddleWidth paddleWidth
     */
    void setPaddleWidth(int paddleWidth);

    /**
     * getPath.
     *
     * @return path
     */
    String getPath();
}
