package gamelevels;

import sprites.Block;

import java.util.HashMap;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class BlocksFromSymbolsFactory {
    private HashMap<String, Integer> spacerWidths;
    private HashMap<String, BlockCreator> blockCreators;

    /**
     * BlocksFromSymbolsFactory.
     *
     * @param space  space
     * @param blocks blocks
     */
    public BlocksFromSymbolsFactory(HashMap<String, Integer> space, HashMap<String, BlockCreator> blocks) {
        this.blockCreators = blocks;
        this.spacerWidths = space;
    }

    /**
     * returns true if 's' is a valid space symbol.
     *
     * @param s s
     * @return boolean
     */
    public boolean isSpaceSymbol(String s) {
        return this.spacerWidths.containsKey(s);
    }

    /**
     * returns true if 's' is a valid block symbol.
     *
     * @param s s
     * @return boolean
     */
    public boolean isBlockSymbol(String s) {
        return this.blockCreators.containsKey(s);
    }

    /**
     * Return a block according to the definitions associated with symbol s. The block will be located at position
     * (xpos, ypos).
     *
     * @param s    s
     * @param xpos xpos
     * @param ypos ypos
     * @return Block
     */
    public Block getBlock(String s, int xpos, int ypos) {
        return this.blockCreators.get(s).create(xpos, ypos);
    }

    /**
     * Returns the width in pixels associated with the given spacer-symbol.
     *
     * @param s s
     * @return int spacerWidths
     */
    public int getSpaceWidth(String s) {
        return this.spacerWidths.get(s);
    }
}
