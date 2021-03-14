//  Point object from "Building Java Programs" textbook
//  A point object represents a pair of (x, y) coordinates

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    //  Constructs a new point at the origin
    public Point() {
        this(0, 0); //  calls Point(int, int) constructor
    }

    //  Constructs a new point with the given (x, y) location
    public Point(int x, int y) {
        setLocation(x, y);
    }

    //  Returns the x-coordinate of this point
    public int getX() {
        return x;
    }

    //  Returns the y-coordinate of this point
    public int getY() {
        return y;
    }

    //  Sets this point's (x, y) location to the given values
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //  Returns the distance between this point and (0, 0)
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    //  Returns a String representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    //  Shifts this point's location by the given amount
    public void translate(int dx, int dy) {
        setLocation(x + dx, y + dy);
    }

    @Override
    public int compareTo(Point p) {
        if (this.distanceFromOrigin() == p.distanceFromOrigin()) {
            return 0;
        } else if (this.distanceFromOrigin() > p.distanceFromOrigin()) {
            return 1;
        } else {
            return -1;
        }
    }
}
