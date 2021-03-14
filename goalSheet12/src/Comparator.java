import java.util.ArrayList;

/**
 * <b>Comparator GS12-02</b>
 * Compares Point objects by their distance from the origin (0, 0). Points that are closer to the
 * origin are considered to come before those which are further from the origin
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-3-10
 */
public class Comparator {
    public static void main (String[] args) {
        // Create new ArrayList of points, and add points through the compiler
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(10, 8));
        points.add(new Point(2, 2));
        points.add(new Point(1, 1));
        points.add(new Point(-1, -1));
        points.add(new Point(5, 6));
        points.add(new Point(3, 3));
        points.add(new Point(-2, 3));
        points.add(new Point(2, 1));
        points.add(new Point(6, 5));
        points.add(new Point(6, -12));

        // Call the sorting function
        points = sort(points);

        // Print the sorted ArrayList of points to the console
        for (Point p : points) {
            System.out.println(p.toString() + " distance: " + p.distanceFromOrigin());
        }
    }

    /**
     * Sorting function that swaps around an ArrayList of points in ascending order of distance
     * from the origin
     * @param points ArrayList of points to be sorted
     * @return Sorted ArrayList of points, organized by distance from origin (ascending)
     */
    public static ArrayList<Point> sort (ArrayList<Point> points) {

        // Put each points' distance from the origin into an array so distanceFromOrigin() doesn't
        // need to be called twice for every comparison
        double[] distance = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            distance[i] = points.get(i).distanceFromOrigin();
        }

        // For each point in ArrayList points ...
        for (int k = 0; k < distance.length - 1; k++) {

            double min = distance[k];
            int index = k;

            // For each remaining (unsorted) element in the ArrayList ...
            for (int l = k; l < distance.length; l++) {
                // If the distance from the origin is less than the current min, replace it
                // If the distances are equal, compare by x values
                if (distance[l] < min) {
                    min = distance[l];
                    index = l;
                } else if (distance[l] == min && points.get(l).getX() < points.get(index).getX()) {
                    min = distance[l];
                    index = l;
                }
            }

            // Move the smallest distance unsorted point to the front of the unsorted points, and
            // remove the point from the unsorted part of the list
            points.add(k, points.get(index));
            points.remove(index + 1);

            // Save the distance that will be sorted
            double d = distance[index];
            // Move the corresponding distances in the array for the next sorting round
            for (int m = index; m > k; m--) {
                distance[m] = distance[m - 1];
            }
            distance[k] = d;
        }

        // Return the sorted ArrayList
        return points;
    }
}
