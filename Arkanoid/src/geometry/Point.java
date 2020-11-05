package geometry;

/**
 * This class creates the point.
 *
 * @author Ronit Shternfeld
 * @version 30 Mars 2018
 */
public class Point {
    private double x;
    private double y;

    /**
     * The constructor initializes the points.
     *
     * @param x the x value of the point
     * @param y the y value of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The function returns the distance of this point to the other point.
     *
     * @param other the other point
     * @return the distance between the two points
     */
    public double distance(Point other) {
        double xDistance = this.getX() - other.getX();
        double yDistance = this.getY() - other.getY();
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    /**
     * Return true if the points are equal, false otherwise.
     *
     * @param other the other point
     * @return true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        if ((this.x == other.getX()) && (this.y == other.getY())) {
            return true;
        }
        return false;
    }

    /**
     * Returns the x value of the point.
     *
     * @return the x value of the point
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y value of the point.
     *
     * @return the y value of the point
     */
    public double getY() {
        return y;
    }
}