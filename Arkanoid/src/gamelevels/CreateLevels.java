package gamelevels;

import sprites.Block;
import sprites.Sprite;
import sprites.Velocity;

import java.util.ArrayList;
import java.util.List;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class CreateLevels implements LevelInformation {
    private int numBlocks;
    private List<Block> blocks;
    private Sprite background;
    private ColorsParser setting;
    private String levelName;
    private List<Velocity> velocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String path;
    private LevelSpecificationReader levelSpecification;
    private List<LevelInformation> levelInformationList = new ArrayList<>();

    /**
     * CreateLevels.
     *
     * @param levSpec levSpec
     */
    public CreateLevels(LevelSpecificationReader levSpec) {
        this.levelSpecification = levSpec;
    }

    /**
     * CreateLevels.
     */
    public CreateLevels() {
    }

    /**
     * CreateLevels.
     *
     * @param levSpec            levSpec
     * @param numBlock           numBlock
     * @param bloc               bloc
     * @param levelNam           levelNam
     * @param velocit            velocit
     * @param levelInformationLi levelInformationLi
     * @param backg              backg
     */
    public CreateLevels(LevelSpecificationReader levSpec, int numBlock, List<Block> bloc, String levelNam,
                        List<Velocity> velocit, List<LevelInformation> levelInformationLi, Sprite backg) {
        this.levelSpecification = levSpec;
        this.numBlocks = numBlock;
        this.background = backg;
        this.levelName = levelNam;
        this.velocities = velocit;
        this.blocks = bloc;
        this.levelInformationList = levelInformationLi;
    }

    /**
     * getLevelInformationList.
     *
     * @return levelInformationList
     */
    public List<LevelInformation> getLevelInformationList() {
        //CreateLevels lI = new CreateLevels(this.levelSpecification);
        //this.levelInformationList.add(lI);
        return this.levelInformationList;
    }

    /**
     * setBlocks.
     *
     * @param list list
     */
    public void setBlocks(List<Block> list) {
        this.blocks = list;
    }

    /**
     * setBackground.
     *
     * @param backg backg
     */
    public void setBackground(Sprite backg) {
        this.background = backg;
    }

    /**
     * setBackground.
     *
     * @param colorParser colorParser
     */
    public void setBackground(ColorsParser colorParser) {
        this.setting = colorParser;
    }

    /**
     * numberOfBalls.
     *
     * @return velocities
     */
    public int numberOfBalls() {
        return this.velocities.size();
    }

    /**
     * initialBallVelocities.
     *
     * @return velocities
     */
    public List<Velocity> initialBallVelocities() {
        return this.velocities;
    }

    /**
     * paddleSpeed.
     *
     * @return paddleSpeed
     */
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     * paddleWidth.
     *
     * @return paddleWidth
     */
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /**
     * levelName.
     *
     * @return levelName
     */
    public String levelName() {
        return this.levelName;
    }

    /**
     * getBackground.
     *
     * @return background
     */
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * blocks.
     *
     * @return blocks
     */
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * numBlocks.
     *
     * @return numBlocks
     */
    public int numberOfBlocksToRemove() {
        return this.numBlocks;
    }

    /**
     * levelName.
     *
     * @param str levelName
     */
    public void setLevelName(String str) {
        this.levelName = str;
    }

    /**
     * setVelocities.
     *
     * @param list list
     */
    public void setVelocities(List list) {
        this.velocities = list;
    }

    /**
     * setPaddleSpeed.
     *
     * @param speed paddleSpeed
     */
    public void setPaddleSpeed(int speed) {
        this.paddleSpeed = speed;
    }

    /**
     * setPaddleWidth.
     *
     * @param width width
     */
    public void setPaddleWidth(int width) {
        this.paddleWidth = width;
    }

    /**
     * setNumBlocks.
     *
     * @param block block
     */
    public void setNumBlocks(int block) {
        this.numBlocks = block;
    }

    /**
     * getPath.
     *
     * @return path
     */
    public String getPath() {
        return this.path;
    }
}
