import java.util.ArrayList;

/**
 * <b>Selection Sort GS12-03</b>
 * Write a modified "dual" version of the selection sort algorithm that selects both the largest and
 * smallest elements on each pass and moves each of them to the appropriate end of the array.
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-3-13
 */
public class SelectionSort {
    public static void main (String[] args) {
        // Create new ArrayList of random integers to be sorted
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(5);
        ints.add(4);
        ints.add(10);
        ints.add(10);
        ints.add(1);
        ints.add(2);
        ints.add(8);
        ints.add(1);
        ints.add(9);
        ints.add(6);
        ints.add(3);

        // Sort the array
        doubleSort(ints);

        // Print the array
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * Double Selection Sort algorithm that sorts both the minimum and maximum elements in an
     * ArrayList in the same pass
     * @param ints ArrayList of integers to be sorted
     * @return Sorted ArrayList of integers
     */
    public static ArrayList<Integer> doubleSort (ArrayList<Integer> ints) {
        // The number of times the outer loop should run for
        int n = (int)Math.ceil((double)ints.size() / 2);

        // For loop that runs half as many times as there are elements in ints (rounded up for odd
        // sizes)
        for (int i = 0; i < n; i++) {
            // Set the initial values and indices for min/max
            int min = ints.get(i);
            int max = ints.get(i);
            int mini = i;
            int maxi = i;

            // Scan every unsorted element in ints for a new min/max
            for (int j = i; j < ints.size() - i; j++) {
                int e = ints.get(j);
                if (e < min) {
                    min = e;
                    mini = j;
                } else if (e > max) {
                    max = e;
                    maxi = j;
                }
            }

            // Move the minimum number to the front of the unsorted array
            ints.add(i, min);
            ints.remove(mini + 1);

            // If the loop isn't on its last run and the array size isn't odd, move the maximum
            // number to the back of the unsorted array
            if (i != n || n % 2 != 1) {
                ints.add(ints.size() - i, max);

                // This may cause problems that I haven't found yet, but storing the index of the
                // maximum and using that to remove it causes problems. Based on the location of the
                // minimum, when it is relocated it could shift the location of the max. This makes
                // tracking the location of the maximum more difficult, so instead of trying to keep
                // track of it, this will search for the first instance of the max and delete that
                // instead.
                maxi = ints.indexOf(max);
                ints.remove(maxi);
            }
        }

        return ints;
    }
}

