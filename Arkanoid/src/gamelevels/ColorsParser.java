package gamelevels;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Ronit Shternfeld
 * @version 24 April 2018
 */
public class ColorsParser {
    private Color color;
    private Image image;
    private boolean isImage = false;

    /**
     * ColorsParser.
     *
     * @param col col
     */
    public ColorsParser(Color col) {
        this.color = col;
    }

    /**
     * ColorsParser.
     *
     * @param im image
     */
    public ColorsParser(Image im) {
        this.image = im;
        this.isImage = true;
    }

    /**
     * colorFromString.
     *
     * @param s string
     * @return color
     */
    public static java.awt.Color colorFromString(String s) {
        String[] strOfColor = s.split("[(|)]");
        if ("cyan".equals(strOfColor[1])) {
            return Color.CYAN;
        }
        if ("orange".equals(strOfColor[1])) {
            return Color.ORANGE;
        }
        if ("pink".equals(strOfColor[1])) {
            return Color.PINK;
        }
        if ("gray".equals(strOfColor[1])) {
            return Color.GRAY;
        }
        if ("lightGray".equals(strOfColor[1])) {
            return Color.LIGHT_GRAY;
        }
        if ("black".equals(strOfColor[1])) {
            return Color.BLACK;
        }
        if ("red".equals(strOfColor[1])) {
            return Color.RED;
        }
        if ("blue".equals(strOfColor[1])) {
            return Color.BLUE;
        }
        if ("green".equals(strOfColor[1])) {
            return Color.GREEN;
        }
        if ("yellow".equals(strOfColor[1])) {
            return Color.YELLOW;
        }
        if ("white".equals(strOfColor[1])) {
            return Color.WHITE;
        }

        if ("RGB".equals(strOfColor[1]) || "rgb".equals(strOfColor[1])) {
            String[] colorsStr = strOfColor[2].split(",");
            return new Color(Integer.parseInt(colorsStr[0]), Integer.parseInt(colorsStr[1]),
                    Integer.parseInt(colorsStr[2]));
        }
        return null;
    }

    /**
     * imageFromString.
     *
     * @param s string
     * @return image
     */
    public static Image imageFromString(String s) {
        String[] strOfImage = s.split("[(|)]");
        Image image = null;
        try {
            image = ImageIO.read(ClassLoader.getSystemClassLoader().getResourceAsStream(strOfImage[1]));
        } catch (IOException exception) {
            System.out.println("Exception in reading the image!");
        }
        return image;
    }

    /**
     * getImage.
     *
     * @return image
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * getColor.
     *
     * @return color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * isImage.
     *
     * @return isImage
     */
    public boolean isImage() {
        return this.isImage;
    }

    /**
     * getColorParser.
     *
     * @return Color
     */
    public Color getColorParser() {
        return this.getColor();
    }
}

