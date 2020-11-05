package game;


import animation.AnimationRunner;
import animation.KeyPressStoppableAnimation;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import gamelevels.CreateLevels;
import gamelevels.LevelInformation;
import gamelevels.LevelSpecificationReader;
import menu.LevelForSet;
import menu.LevelsForSubMenu;
import menu.Menu;
import menu.MenuAnimation;
import menu.Task;
import score.HighScoresAnimation;
import score.HighScoresTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class of the main that makes the game.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class Ass6Game {
    private boolean running;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    /**
     * The main that makes the game.
     *
     * @param args arguments
     */
    public static void main(final String[] args) {
        final GUI gui = new GUI("ARKANOID", WIDTH, HEIGHT);
        final KeyboardSensor keyboard = gui.getKeyboardSensor();
        final AnimationRunner animation = new AnimationRunner(gui, 60);
        final File highScoresFile = new File("highscores");
        final GameFlow gameFlow = new GameFlow(animation, keyboard, gui, highScoresFile);
        final Menu<Task<Void>> taskMenuAnimation = new MenuAnimation<>(animation, "ARKANOID", keyboard);
        List<LevelInformation> levels = new ArrayList<>();
        final LevelSpecificationReader levelSpecification = new LevelSpecificationReader();
        CreateLevels lI = new CreateLevels(levelSpecification);
        BufferedReader reader = null;
        final Menu<Task<Void>> subMenu = new MenuAnimation<>(animation, "subMenu", keyboard);
        final List<LevelInformation> newList = levels;
        Task<Void> startGame = new Task<Void>() {
            public Void run() {
                List<LevelForSet> levelFromSet;
                String run;
                if (args.length == 0) {
                    run = "level_sets.txt";
                } else {
                    run = args[0];
                }
                levelFromSet = LevelsForSubMenu.fromReader(new InputStreamReader(
                        ClassLoader.getSystemClassLoader().getResourceAsStream(run)));
                List<Task<Void>> listOfTasks = new ArrayList<>();
                for (int i = 0; i < levelFromSet.size(); i++) {
                    final String path = levelFromSet.get(i).getPath();
                    Task<Void> task = new Task<Void>() {
                        public Void run() {
                            try {
                                InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
                                Reader reader = new InputStreamReader(is);
                                List<LevelInformation> levels = LevelSpecificationReader.fromReader(reader);
                                gameFlow.runLevels(levels);
                                reader.close();
                            } catch (Exception exception) {
                                new RuntimeException("Exception in reading the levels!");
                            }
                            return null;
                        }
                    };
                    listOfTasks.add(task);
                    subMenu.addSelection(levelFromSet.get(i).getKey(), levelFromSet.get(i).getName(),
                            listOfTasks.get(i));
                }
                return null;
            }
        };

        Task<Void> highSco = new Task<Void>() {
            private String strKey;

            public Void run() {
                HighScoresTable highScoreTab;
                try {
                    if (highScoresFile.exists()) {
                        highScoreTab = HighScoresTable.loadFromFile(highScoresFile);
                    } else {
                        highScoreTab = new HighScoresTable(10);
                        highScoreTab.save(highScoresFile);
                    }
                } catch (Exception exception) {
                    highScoreTab = new HighScoresTable(10);
                }
                final HighScoresTable highScoresTa = highScoreTab;
                animation.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(),
                        KeyboardSensor.SPACE_KEY, new HighScoresAnimation(highScoresTa, strKey)));
                return null;
            }
        };
        Task<Void> quitTheGame = new Task<Void>() {
            public Void run() {
                gui.close();
                System.exit(0);
                return null;
            }
        };

        startGame.run();
        //the selections
        taskMenuAnimation.addSubMenu("s", "(s) Start Game", subMenu);
        taskMenuAnimation.addSelection("h", "(h) High Score", highSco);
        taskMenuAnimation.addSelection("q", "(q) Quit", quitTheGame);


        while (true) {
            animation.run(taskMenuAnimation);
            //the user's key selection
            Task<Void> task = taskMenuAnimation.getStatus();
            task.run();
        }
    }
}


