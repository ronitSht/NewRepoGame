package gamelevels;

import sprites.Block;
import sprites.Velocity;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class LevelSpecificationReader {
    /**
     * createNewLevel.
     *
     * @param stringOfLineArray stringOfLineArray
     */
    public void createNewLevel(String[] stringOfLineArray) {
        CreateLevels thisLevel = new CreateLevels();
    }

    /**
     * fromReader.
     *
     * @param reader reader
     * @return list of levels
     */
    public static List<LevelInformation> fromReader(Reader reader) {
        List<LevelInformation> levelsList = new ArrayList<>();
        BufferedReader br = new BufferedReader(reader);
        String stringOfLine;
        String[] stringOfLineArray = null;
        CreateLevels thisLevel = new CreateLevels();
        LevelInformation levelInformationl = null;
        BlocksFromSymbolsFactory bfsf = null;
        int tmpX = 0, tmpY = 0;
        int startX = 0;
        int rowsHeight = 0;
        try {
            while ((stringOfLine = br.readLine()) != null) {
                stringOfLineArray = stringOfLine.split(" ");
                if (stringOfLine.startsWith("#")) {
                    continue;
                } else if (stringOfLine.length() == 0) {
                    continue;
                }
                if (stringOfLine.startsWith("END_LEVEL")) {
                    levelsList.add(thisLevel);
                    thisLevel = new CreateLevels();
                    bfsf = null;
                }

                if (stringOfLine.startsWith("background")) {
                    stringOfLineArray = stringOfLine.split(":");
                    LevelImage background;
                    Color color;
                    Image image;
                    if (stringOfLineArray[1].startsWith("color")) {
                        color = ColorsParser.colorFromString(stringOfLineArray[1]);
                        background = new LevelImage(color);
                    } else {
                        image = ColorsParser.imageFromString(stringOfLineArray[1]);
                        background = new LevelImage(image);
                    }
                    thisLevel.setBackground(background);
                } else if (stringOfLine.startsWith("ball_velocities")) {
                    stringOfLineArray = stringOfLine.split(":");
                    List<Velocity> velList = new ArrayList<>();
                    String[] velocities = stringOfLineArray[1].split(" "), velStrArray;
                    for (int i = 0; i < velocities.length; i++) {
                        velStrArray = velocities[i].split(",");
                        Velocity vel = Velocity.fromAngleAndSpeed(Double.parseDouble(velStrArray[0]),
                                Double.parseDouble(velStrArray[1]));
                        velList.add(vel);
                    }
                    thisLevel.setVelocities(velList);
                } else if (stringOfLine.startsWith("block_definitions")) {
                    BlocksFromSymbolsFactory blocksSym = bfsf;
                    stringOfLineArray = stringOfLine.split(":");
                    InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream(stringOfLineArray[1]);

                    Reader blocksReader = new InputStreamReader(input);
                    blocksSym = BlocksDefinitionReader.fromReader(blocksReader);
                    bfsf = blocksSym;
                    blocksReader.close();
                    if (blocksSym == null) {
                        return null;
                    }
                } else if (stringOfLine.startsWith("paddle_speed")) {
                    stringOfLineArray = stringOfLine.split(":");
                    thisLevel.setPaddleSpeed(Integer.parseInt(stringOfLineArray[1]));
                } else if (stringOfLine.startsWith("paddle_width")) {
                    stringOfLineArray = stringOfLine.split(":");
                    thisLevel.setPaddleWidth(Integer.parseInt(stringOfLineArray[1]));
                } else if (stringOfLine.startsWith("level_name")) {
                    stringOfLineArray = stringOfLine.split(":");
                    thisLevel.setLevelName(stringOfLineArray[1]);
                } else if (stringOfLine.startsWith("num_blocks")) {
                    stringOfLineArray = stringOfLine.split(":");
                    thisLevel.setNumBlocks(Integer.parseInt(stringOfLineArray[1]));
                } else if (stringOfLine.startsWith("blocks_start_x")) {
                    stringOfLineArray = stringOfLine.split(":");
                    tmpX = Integer.parseInt(stringOfLineArray[1]);
                    startX = tmpX;
                } else if (stringOfLine.startsWith("blocks_start_y")) {
                    stringOfLineArray = stringOfLine.split(":");
                    tmpY = Integer.parseInt(stringOfLineArray[1]);
                } else if (stringOfLine.startsWith("row_height")) {
                    stringOfLineArray = stringOfLine.split(":");
                    rowsHeight = Integer.parseInt(stringOfLineArray[1]);
                } else if (stringOfLine.startsWith("START_BLOCKS")) {
                    List<Block> blocksList = new ArrayList<>();
                    while (true) {
                        stringOfLine = br.readLine();
                        if (stringOfLine.startsWith("END_BLOCKS")) {
                            break;
                        }
                        if (stringOfLine.length() == 0) {
                            continue;
                        } else if (stringOfLine.startsWith("#")) {
                            continue;
                        } else {
                            for (int i = 0; i < stringOfLine.length(); i++) {
                                if (bfsf.isSpaceSymbol(Character.toString(stringOfLine.charAt(i)))) {
                                    tmpX = tmpX + bfsf.getSpaceWidth(Character.toString(stringOfLine.charAt(i)));
                                }
                                if (bfsf.isBlockSymbol(Character.toString(stringOfLine.charAt(i)))) {
                                    Block block = bfsf.getBlock(Character.toString(stringOfLine.charAt(i)), tmpX,
                                            tmpY);
                                    blocksList.add(block);
                                    tmpX = (int) (tmpX + block.getCollisionRectangle().getWidth());
                                }
                            }
                            tmpY += rowsHeight;
                            tmpX = startX;
                        }
                    }
                    thisLevel.setBlocks(blocksList);
                }
            }
        } catch (
                IOException exception) {
            throw new RuntimeException("Exception in the process of splitting the line!");
        } finally {
            try {
                br.close();
            } catch (IOException exc) {
                throw new RuntimeException("Exception in the process of splitting the line!");
            }
        }
        return levelsList;
    }
}