package gamelevels;

import geometry.Point;
import sprites.Block;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class BlockCreate implements BlockCreator {
    private String symbol;
    private int height;
    private int width;
    private int hitPoints;
    private Color color;
    private Image image;
    private ColorsParser colorsParser;
    private int fillK;
    private int numOfHits;
    private HashMap<Integer, ColorsParser> hashMap;

    /**
     * @param str  str
     * @param hei  hei
     * @param wid  wid
     * @param hit  hit
     * @param col  col
     * @param im   im
     * @param hash hash
     */
    public BlockCreate(String str, int hei, int wid, int hit, Color col, Image im,
                       HashMap<Integer, ColorsParser> hash) {
        this.symbol = str;
        this.height = hei;
        this.width = wid;
        this.hitPoints = hit;
        this.color = col;
        this.image = im;
        this.hashMap = hash;
    }

    /**
     * BlockCreate.
     */
    public BlockCreate() {

    }

    /**
     * Create a block at the specified location.
     *
     * @param xpos xpos
     * @param ypos ypos
     * @return Block
     */
    public Block create(int xpos, int ypos) {
       // if (this.hashMap.get(this.numOfHits).getImage() != null){
        if (this.hashMap != null) {
            //Block block = new Block(new geometry.Rectangle(new Point(xpos, ypos), this.width, this.height),
            // this.image);
            Block block = new Block(new geometry.Rectangle(new Point(xpos, ypos), this.width, this.height), hashMap,
                    hitPoints);
            return block;
        } else {
            // Block block = new Block(new geometry.Rectangle(new Point(xpos, ypos), this.width, this.height),
            // this.color);
            Block block = new Block(new geometry.Rectangle(new Point(xpos, ypos), this.width, this.height), this.color,
                    hashMap, hitPoints);
            return block;
        }
    }

    /**
     * setHeight.
     *
     * @param hei hei
     */
    public void setHeight(String hei) {
        this.height = Integer.parseInt(hei);
    }

    /**
     * setWidth.
     *
     * @param wid wid
     */
    public void setWidth(String wid) {
        this.width = Integer.parseInt(wid);
    }

    /**
     * setHitPoints.
     *
     * @param hitPo hitPo
     */
    public void setHitPoints(String hitPo) {
        this.hitPoints = Integer.parseInt(hitPo);
    }

    /**
     * setFill.
     *
     * @param fill fill
     */
    public void setFill(HashMap<Integer, ColorsParser> fill) {
        this.hashMap = fill;
    }

    /**
     * setStroke.
     *
     * @param stro stro
     */
    public void setStroke(String stro) {
        this.color = ColorsParser.colorFromString(stro);
    }
}
