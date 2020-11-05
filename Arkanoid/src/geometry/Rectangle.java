package geometry;

import java.util.ArrayList;

/**
 * This class creates the rectangle by creating it's four lines.
 *
 * @author Ronit Shternfeld
 * @version 23 April 2018
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    private static final int NUM_OF_LINES = 4;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft upperLeft
     * @param width     width
     * @param height    height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Creates the lines of the rectangle and puts them in an array.
     *
     * @return array of the lines
     */
    public Line[] linesArray() {
        Line leftLineOfRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX(), this.upperLeft.getY() + height);
        Line rightLineOfRectangle = new Line(this.upperLeft.getX() + width, this.upperLeft.getY(),
                this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        Line upperLineOfRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + width, this.upperLeft.getY());
        Line downLineOfRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY() + height,
                this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        Line[] linesOfRectangleArray = new Line[NUM_OF_LINES];
        linesOfRectangleArray[0] = leftLineOfRectangle;
        linesOfRectangleArray[1] = rightLineOfRectangle;
        linesOfRectangleArray[2] = upperLineOfRectangle;
        linesOfRectangleArray[3] = downLineOfRectangle;
        return linesOfRectangleArray;
    }

    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     *
     * @param line line
     * @return the list of the intersection points with the rectangle.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Line leftLineOfRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX(), this.upperLeft.getY() + height);
        Line rightLineOfRectangle = new Line(this.upperLeft.getX() + width, this.upperLeft.getY(),
                this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        Line upperLineOfRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + width, this.upperLeft.getY());
        Line downLineOfRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY() + height,
                this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        ArrayList intersectionPointsList = new ArrayList<Point>();
        Line[] linesOfRectangleArray = new Line[NUM_OF_LINES];
        linesOfRectangleArray[0] = leftLineOfRectangle;
        linesOfRectangleArray[1] = rightLineOfRectangle;
        linesOfRectangleArray[2] = upperLineOfRectangle;
        linesOfRectangleArray[3] = downLineOfRectangle;
        for (int i = 0; i < linesOfRectangleArray.length; i++) {
            if (linesOfRectangleArray[i].isIntersecting(line)) {
                intersectionPointsList.add(linesOfRectangleArray[i].intersectionWith(line));
            }
        }
        return intersectionPointsList;
    }

    /**
     * Return the width and height of the rectangle.
     *
     * @return width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Return the width and height of the rectangle.
     *
     * @return height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * @param upperLeftRect upper left
     */
    public void setUpperLeft(Point upperLeftRect) {
        this.upperLeft = upperLeftRect;
    }
}