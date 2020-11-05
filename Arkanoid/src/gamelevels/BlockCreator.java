package gamelevels;

import sprites.Block;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public interface BlockCreator {

    /**
     * Create a block at the specified location.
     *
     * @param xpos xpos
     * @param ypos ypos
     * @return Block
     */
    Block create(int xpos, int ypos);
}
