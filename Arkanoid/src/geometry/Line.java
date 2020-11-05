package geometry;

import java.util.List;

/**
 * This class creates the line and it's length, middle point and intersection points between the lines.
 *
 * @author Ronit Shternfeld
 * @version 30 Mars 2018
 */
public class Line {
    private Point start;
    private Point end;
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    /**
     * The function initializes the start point and the end point.
     *
     * @param start start of line
     * @param end   end of line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The function initializes the start point and the end point.
     *
     * @param x1 x parameter of start of line
     * @param y1 y parameter of start of line
     * @param x2 x parameter of end of line
     * @param y2 y parameter of start of line
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Return the length of the line.
     *
     * @return the length of the line
     */
    public double length() {
        double xDistance = this.x1 - this.x2;
        double yDistance = this.y1 - this.y2;
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return the middle point of the line
     */
    public Point middle() {
        double xMiddle = (this.start.getX() + this.end.getX()) / 2;
        double yMiddle = (this.start.getY() + this.end.getY()) / 2;
        return new Point(xMiddle, yMiddle);
    }

    /**
     * Returns the start point of the line.
     *
     * @return this.start
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return this.end
     */
    public Point end() {
        return this.end;
    }

    /**
     * The function checks the case that the line is a point, if the point is in the limits of the other line,
     * it returns the intersection point, otherwise it returns null.
     *
     * @param other other line
     * @return if the point is in the limits of the other line, it returns the intersection point, otherwise
     * it returns null.
     */
    public Point lineIsPoint(Line other) {
        if ((other.start.getX() == other.end.getX()) && (other.start.getY() == other.end.getY())) {
            if ((other.start.getX() <= Math.max(this.start.getX(), this.end.getX()))
                    && (other.start.getX() >= Math.min(this.start.getX(), this.end.getX()))
                    && (other.start.getY() <= Math.max(this.start.getY(), this.end.getY()))
                    && (other.start.getY() >= Math.min(this.start.getY(), this.end.getY()))) {
                return new Point(other.start.getX(), other.start.getY());
            }
        }
        if ((this.start.getX() == this.end.getX()) && (this.start.getY() == this.end.getY())) {
            if ((this.start.getX() <= Math.max(other.start.getX(), other.end.getX()))
                    && (this.start.getX() >= Math.min(other.start.getX(), other.end.getX()))
                    && (this.start.getY() <= Math.max(other.start.getY(), other.end.getY()))
                    && (this.start.getY() >= Math.min(other.start.getY(), other.end.getY()))) {
                return new Point(this.start.getX(), this.start.getY());
            }
        }
        return null;
    }

    /**
     * Calculates the intersection point between lines in different cases - vertical lines, not vertical lines,
     * and if the lines are parallel so the slopes are equal it returns null.
     *
     * @param other line
     * @return the intersection point between lines
     */
    public Point intersectionPoint(Line other) {
        double slopeThis = 0, slopeOther = 0;
        double bValue = 0, bValueOther = 0;
        double xIntersection = 0, yIntersection = 0;

        if (lineIsPoint(other) != null) {
            return lineIsPoint(other);
        }

        /*
         * Calculates the values of the two lines slopes and the 'b' value of an equation (y=ax+b).
         */
        if (this.end.getX() != this.start.getX()) {
            slopeThis = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            bValue = (slopeThis * (-this.start.getX())) + this.start.getY();
        }
        if (other.end.getX() != other.start.getX()) {
            slopeOther = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
            bValueOther = (slopeOther * (-other.start.getX())) + other.start.getY();
        }

        /* If the slopes are equal, the lines are parallel and are not intersecting. */
        if ((slopeThis == slopeOther) && ((this.end.getX() != this.start.getX()) && (other.end.getX()
                != other.start.getX()))) {
            return null;
        }

        if ((this.start.getX() == this.end.getX()) && (other.start.getY() == other.start.getY())) {
            if ((this.start.getX() <= Math.max(other.start.getX(), other.end.getX()))
                    && (this.start.getX() >= Math.min(other.start.getX(), other.end.getX()))
                    && (other.start.getY() <= Math.max(this.start.getY(), this.end.getY()))
                    && (other.start.getY() >= Math.min(this.start.getY(), this.end.getY()))) {
                return new Point(this.start.getX(), other.start.getY());
            }
        }
        if ((other.start.getX() == other.end.getX()) && (this.start.getY() == this.start.getY())) {
            if ((other.start.getX() <= Math.max(this.start.getX(), this.end.getX()))
                    && (other.start.getX() >= Math.min(this.start.getX(), this.end.getX()))
                    && (this.start.getY() <= Math.max(other.start.getY(), other.end.getY()))
                    && (this.start.getY() >= Math.min(other.start.getY(), other.end.getY()))) {
                return new Point(other.start.getX(), this.start.getY());
            }
        }

        /*
         * If one line is vertical, we know that the X value is joint to the two lines, and we only
         * need to find the Y value.
         */
        if (this.start.getX() == this.end.getX()) {
            xIntersection = this.start.getX();
            yIntersection = (slopeOther * xIntersection) + bValueOther;
            if ((this.start.getX() <= Math.max(other.start.getX(), other.end.getX()))
                    && (this.start.getX() >= Math.min(other.start.getX(), other.end.getX()))
                    && (yIntersection <= Math.max(this.start.getY(), this.end.getY()))
                    && (yIntersection >= Math.min(this.start.getY(), this.end.getY()))) {
                return new Point(xIntersection, yIntersection);
            } else {
                return null;
            }
        } else if (other.start.getX() == other.end.getX()) {
            xIntersection = other.start.getX();
            yIntersection = (slopeThis * xIntersection) + bValue;
            if ((xIntersection <= Math.max(this.start.getX(), this.end.getX()))
                    && (xIntersection >= Math.min(this.start.getX(), this.end.getX()))
                    && (yIntersection <= Math.max(other.start.getY(), other.end.getY()))
                    && (yIntersection >= Math.min(other.start.getY(), other.end.getY()))) {
                return new Point(xIntersection, yIntersection);
            } else {
                return null;
            }

            /*
             * If no line is vertical, we calculate the X value by comparing the two equations of the lines.
             * Then we find the Y value.
             */
        } else {
            xIntersection = (bValue - bValueOther) / (slopeOther - slopeThis);
            yIntersection = (slopeThis * xIntersection) + bValue;
            return new Point(xIntersection, yIntersection);
        }

    }

    /**
     * The function checks if one line is in the limits of the other, and if yes they can be intersecting.
     *
     * @param other the line
     * @return false if the lines are too short to be intersecting, true otherwise.
     */
    public boolean isInTheLineLimits(Line other) {
        if ((intersectionPoint(other) != null)
                && (intersectionPoint(other).getX() <= Math.max(this.start.getX(), this.end.getX()))
                && (intersectionPoint(other).getX() >= Math.min(this.start.getX(), this.end.getX()))
                && (intersectionPoint(other).getY() <= Math.max(this.start.getY(), this.end.getY()))
                && (intersectionPoint(other).getY() >= Math.min(this.start.getY(), this.end.getY()))
                && (intersectionPoint(other).getX() <= Math.max(other.start.getX(), other.end.getX()))
                && (intersectionPoint(other).getX() >= Math.min(other.start.getX(), other.end.getX()))
                && (intersectionPoint(other).getY() <= Math.max(other.start.getY(), other.end.getY()))
                && (intersectionPoint(other).getY() >= Math.min(other.start.getY(), other.end.getY()))) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the point is on the line.
     *
     * @param otherPoint point
     * @param other      other line
     * @return true if the ball on the line, else return false
     */
    public boolean isPointOnTheLine(Point otherPoint, Line other) {
        if ((this != null)
                && (otherPoint.getX() <= Math.max(this.start.getX(), this.end.getX()))
                && (otherPoint.getX() >= Math.min(this.start.getX(), this.end.getX()))
                && (otherPoint.getY() <= Math.max(this.start.getY(), this.end.getY()))
                && (otherPoint.getY() >= Math.min(this.start.getY(), this.end.getY()))
                && (otherPoint.getX() <= Math.max(other.start.getX(), other.end.getX()))
                && (otherPoint.getX() >= Math.min(other.start.getX(), other.end.getX()))
                && (otherPoint.getY() <= Math.max(other.start.getY(), other.end.getY()))
                && (otherPoint.getY() >= Math.min(other.start.getY(), other.end.getY()))) {
            return true;
        }
        return false;
    }

    /**
     * The function checks if one line is vertical.
     *
     * @param other the line
     * @return true if only one line is vertical, false otherwise.
     */
    public boolean isOneLineVertical(Line other) {

        /*
         * For avoiding Runtime error when the denominator of the fraction is 0. First if - when the two lines
         * are vertical, so they do not have a joint point. Second if - when only one line is vertical, so they
         * might have a joint point. Otherwise, the lines are not vertical.
         */
        if ((this.end.getX() == this.start.getX()) && (other.end.getX() == other.start.getX())) {
            return false;
        } else if ((this.end.getX() == this.start.getX()) || (other.end.getX() == other.start.getX())) {
            return true;
        }
        return false;
    }

    /**
     * The function returns true if the lines intersect, false otherwise.
     *
     * @param other the other line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if ((isInTheLineLimits(other)) && (intersectionPoint(other) != null)) {
            return true;
        }
        return false;
    }

    /**
     * Returns the intersection point if the lines intersect, and null otherwise.
     *
     * @param other the line
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {

        if (isIntersecting(other)) {
            return intersectionPoint(other);
        }
        return null;
    }

    /**
     * The function returns true if the lines are equal, false otherwise.
     *
     * @param other the line
     * @return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {

        /*
         *One option is to compare between the "starts" and the "ends". The
         *other option is to compare between one "start" and one "end" because
         *it can be possible that the lines are opposite. If the lines are
         *equal, it returns true, else - it returns false.
         */
        if (((this.start == other.start) && (this.end == other.end)) || ((this.start == other.end)
                && (this.end == other.start))) {
            return true;
        }
        return false;
    }

    /**
     * If this line does not intersect with the rectangle, return null. Otherwise, return the closest intersection
     * point to the start of the line.
     *
     * @param rect rectangle
     * @return intersection point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        double distance = 0;
        int indexOfClosestPoint = 0;
        List<Point> intersectionPointsList = rect.intersectionPoints(this);
        if (intersectionPointsList.size() == 0) {
            return null;
        }
        double minDistance = this.start.distance(intersectionPointsList.get(0));

        /*
         * Runs through the distances between the start point of the line and the intersection points of the line with
         * the rectangle and finds which distance is smaller and finds the closest point to the start point.
         */
        for (int i = 1; i < intersectionPointsList.size(); i++) {
            if (minDistance < this.start.distance(intersectionPointsList.get(i))) {
                distance = this.start.distance(intersectionPointsList.get(i));
            }
            if (distance < minDistance) {
                minDistance = distance;
                indexOfClosestPoint = i;
            }
        }
        return intersectionPointsList.get(indexOfClosestPoint);
    }
}
