package gamelevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class BlocksDefinitionReader {
    /**
     * fromReader.
     *
     * @param reader reader
     * @return BlocksFromSymbolsFactory
     */
    public static BlocksFromSymbolsFactory fromReader(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        String[] stringOfLineArray;
        String strLine;
        HashMap<String, String> mapDefault = new HashMap<>();
        HashMap<String, Integer> mapSpace = new HashMap<>();
        HashMap<String, BlockCreator> mapStrBlock = new HashMap<>();
        String key, value;
        HashMap<String, String> blocksMap;

        try {
            while ((strLine = br.readLine()) != null) {
                if (strLine.startsWith("#")) {
                    continue;
                } else if (strLine.startsWith("default")) {
                    stringOfLineArray = strLine.split(" ");
                    for (int i = 1; i < stringOfLineArray.length; i++) {
                        value = stringOfLineArray[i].split(":")[1];
                        key = stringOfLineArray[i].split(":")[0];
                        mapDefault.put(key, value);
                    }
                } else if (strLine.startsWith("sdef")) {
                    stringOfLineArray = strLine.split(" ");
                    key = stringOfLineArray[1].split(":")[1];
                    value = stringOfLineArray[2].split(":")[1];
                    int val = Integer.parseInt(value);
                    mapSpace.put(key, val);
                } else if (strLine.startsWith("bdef")) {
                    blocksMap = new HashMap<>();
                    stringOfLineArray = strLine.split(" ");
                    //blocksMap.putAll(blocksMap);
                    //blocksMap.putAll(mapDefault);
                    for (int i = 1; i < stringOfLineArray.length; i++) {
                        value = stringOfLineArray[i].split(":")[1];
                        key = stringOfLineArray[i].split(":")[0];
                        blocksMap.put(key, value);
                    }

                    if (!blocksMap.containsKey("hit_points")) {
                        String defaultu = mapDefault.get("hit_points");
                        blocksMap.put("hit_points", defaultu);
                    }
                    if (!blocksMap.containsKey("symbol")) {
                        String defaultu = mapDefault.get("symbol");
                        blocksMap.put("symbol", defaultu);
                    }
                    if (!blocksMap.containsKey("height")) {
                        String defaultu = mapDefault.get("height");
                        blocksMap.put("height", defaultu);
                    }
                    if (!blocksMap.containsKey("width")) {
                        String defaultu = mapDefault.get("width");
                        blocksMap.put("width", defaultu);
                    }
                    String symbol = blocksMap.get("symbol");
                    HashMap<Integer, ColorsParser> mapColor = new HashMap<>();

                    for (int j = 1; j <= Integer.parseInt(blocksMap.get("hit_points")); j++) {
                        if (blocksMap.containsKey("fill")) {
                            if (blocksMap.get("fill").startsWith("color")) {
                                mapColor.put(j, new ColorsParser(ColorsParser.colorFromString(blocksMap.get("fill"))));
                            } else {
                                mapColor.put(j, new ColorsParser(ColorsParser.imageFromString(blocksMap.get("fill"))));
                            }
                        }

                        if (blocksMap.containsKey("fill-" + j)) {
                            if (blocksMap.get("fill-" + j).startsWith("color")) {
                                mapColor.put(j, new ColorsParser(ColorsParser.colorFromString(blocksMap.get("fill-"
                                        + j))));
                            } else {
                                mapColor.put(j, new ColorsParser(ColorsParser.imageFromString(blocksMap.get("fill-"
                                        + j))));
                            }
                        }
                    }
                    if (!blocksMap.containsKey("fill")) {
                        for (int j = 1; j <= Integer.parseInt(blocksMap.get("hit_points")); j++) {
                            if (!blocksMap.containsKey("fill-" + j)) {
                                return null;
                            }
                        }
                    }

                    BlockCreate blockCreate = new BlockCreate();
                    blockCreate.setHitPoints(blocksMap.get("hit_points"));
                    blockCreate.setHeight(blocksMap.get("height"));
                    blockCreate.setWidth(blocksMap.get("width"));
                    blockCreate.setFill(mapColor);
                    if (blocksMap.containsKey("stroke")) {
                        blockCreate.setStroke(blocksMap.get("stroke"));
                    }

                    if (!blocksMap.containsKey("stroke")) {
                        String defaultu = mapDefault.get("stroke");
                        blocksMap.put("stroke", defaultu);
                    }
                    if (!blocksMap.containsKey("width")) {
                        String defaultu = mapDefault.get("width");
                        blocksMap.put("width", defaultu);
                    }
                    if (!blocksMap.containsKey("height")) {
                        String defaultu = mapDefault.get("height");
                        blocksMap.put("height", defaultu);
                    }
                    if (!blocksMap.containsKey("symbol")) {
                        String defaultu = mapDefault.get("symbol");
                        blocksMap.put("symbol", defaultu);
                    }
                    mapStrBlock.put(symbol, blockCreate);
                }
            }
        } catch (IOException exception) {
            throw new RuntimeException("Exception in the process of splitting the line!");
        }
        return new BlocksFromSymbolsFactory(mapSpace, mapStrBlock);
    }
}

