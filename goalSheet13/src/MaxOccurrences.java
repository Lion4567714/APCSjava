import java.util.ArrayList;
import java.util.HashMap;

/**
 * <b>Max Occurrences GS13-04</b>
 * Write a method (maxOccurrences) that accepts a list of integers as a parameter and returns the
 * number of times the most frequently occurring integer occurs in the list.
 * Use a map as auxiliary storage. If the list is empty, return 0.
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-3-24
 */
public class MaxOccurrences {
    public static void main (String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(2);
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(2);
        list.add(2);

        int mode = maxOccurrences(list);
        System.out.println("The mode of the list is " + mode);
    }

    /**
     * Finds the mode of a given arraylist of integers
     * @param list ArrayList of integers to be searched
     * @return The mode of the given ArrayList
     */
    public static int maxOccurrences (ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : list) {
            int element = map.getOrDefault(i, 0);
            element++;  // For some reason this couldn't be put into line 41, so to a new line it is
            map.put(i, element);
        }

        int mode = 0;
        for (int i : map.values()) {
            if (i > mode) {
                mode = i;
            }
        }

        return mode;
    }
}
