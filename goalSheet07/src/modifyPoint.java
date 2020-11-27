//  Name:       Anders Gilliland
//  Project:    GS07-03 Modify Point Class
//  Purpose:    Modify the point class from chapter 8 so that it defines a natural ordering by
//              ordering by implementing the Comparable interface. Compare the points by
//              y-major order and break ties by comparing x-coordinate values.

import java.util.ArrayList;

public class modifyPoint {
    public static void main (String[] args) {
        //  Get arrayLists for sorting the x and y coordinates to be put into the point list
        System.out.println("Input the x-coordinates for points:");
        ArrayList<Integer> xList = scaleByKClass.getArrayList();
        System.out.println("Input the y-coordinates for points:");
        ArrayList<Integer> yList = scaleByKClass.getArrayList();
        ArrayList<Point> points = toPointList(xList, yList);

        points = sortPointList(points);

        System.out.println("\nPoints:");
        for (Point p : points) {
            System.out.println(p.toString());
        }
    }

    //  Method for converting two lists of coordinates to one list of points
    public static ArrayList<Point> toPointList (ArrayList<Integer> x, ArrayList<Integer> y) {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            points.add(new Point(x.get(i), y.get(i)));
        }
        return points;
    }

    //  Sort a list of points by y-coordinates, least to greatest
    public static ArrayList<Point> sortPointList (ArrayList<Point> points) {
        Point thisP;
        Point lastP = points.get(0);

        for (int i = 1; i < points.size(); i++) {
            thisP = points.get(i);

            //  Compare this iteration and last iteration's y-coordinate
            //  If this = last, then put the one with lesser x-coordinate first
            //  If this < last, then swap their places so the lesser is first
            //  If this > last, then change nothing
            if (thisP.compareTo(lastP) == 0 && thisP.getX() < lastP.getX()
                    || thisP.compareTo(lastP) == -1) {
                points.add(i - 1, thisP);
                points.remove(i + 1);
                i = 0;
                lastP = points.get(0);
            } else {
                lastP = thisP;
            }
        }

        return points;
    }
}
