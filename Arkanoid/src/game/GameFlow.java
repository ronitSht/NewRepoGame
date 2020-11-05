package game;

import animation.AnimationRunner;
import animation.KeyPressStoppableAnimation;
import animation.LoseScreen;
import animation.WinScreen;
import ass.Counter;
import biuoop.DialogManager;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import gamelevels.LevelInformation;
import score.HighScoresAnimation;
import score.HighScoresTable;
import score.ScoreInfo;
import sprites.SpriteCollection;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class GameFlow {
    private GUI gui;
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter scoreCounter;
    private Counter livesCounter;
    private SpriteCollection spriteCollection;
    private HighScoresTable highScoresTable;
    private File highscores;
    private String strKey;

    /**
     * GameFlow.
     *
     * @param ar      AnimationRunner
     * @param ks      KeyboardSensor
     * @param gui     GUI
     * @param newFile newFile
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui, File newFile) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.spriteCollection = new SpriteCollection();
        this.scoreCounter = new Counter(0);
        this.livesCounter = new Counter(0);
        this.livesCounter.increase(7);
        this.gui = gui;
        this.highscores = newFile;
        this.highScoresTable = HighScoresTable.loadFromFile(this.highscores);
        this.highScoresTable = new HighScoresTable(10);
    }

    /**
     * Runs the Levels.
     *
     * @param levels levelsInformation
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(this.spriteCollection, levelInfo, this.scoreCounter, this.livesCounter,
                    this.animationRunner, this.keyboardSensor, this.gui);

            level.initialize();

            // level has more blocks and player has more lives
            //while ((this.livesCounter.getValue() > 0) && (levelInfo.blocks().size() > 0)) {
            level.playOneTurn();

            // }
            if (this.livesCounter.getValue() == 0) {
                if (this.highScoresTable.getRank(this.scoreCounter.getValue()) < this.highScoresTable.size()) {
                    DialogManager dialog = gui.getDialogManager();
                    String name = dialog.showQuestionDialog("Name", "What is your name?", "");
                    this.highScoresTable.add(new ScoreInfo(name, this.scoreCounter.getValue()));
                }
                this.animationRunner.run(new LoseScreen(this.scoreCounter, this.keyboardSensor));
                break;
            }
        }

        if (this.livesCounter.getValue() != 0) {
            if (this.highScoresTable.getRank(this.scoreCounter.getValue()) < this.highScoresTable.size()) {
                DialogManager dialog = gui.getDialogManager();
                String name = dialog.showQuestionDialog("Name", "What is your name?", "");
                this.highScoresTable.add(new ScoreInfo(name, this.scoreCounter.getValue()));
            }
            this.animationRunner.run(new WinScreen(this.scoreCounter, this.keyboardSensor));
        }

        try {
            this.highScoresTable.save(this.highscores);

        } catch (IOException exception) {
            System.err.println("There is a problem in saving!");
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                new HighScoresAnimation(this.highScoresTable, strKey)));
        //adds the lives again to the next game and nullify
        this.scoreCounter = new Counter(0);
        this.livesCounter = new Counter(0);
        this.livesCounter.increase(7);
    }
}
