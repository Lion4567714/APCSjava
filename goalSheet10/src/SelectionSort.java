import java.util.Arrays;

/**
 * <b>Selection Sort (modified) GS10-03</b>
 * Write a modified version of the selection sort algorithm that select the largest element each
 * time and moves it to the end of the array, rather than selecting the smallest element and moving
 * it to the beginning.
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-5-11
 */
public class SelectionSort {
    public static void main (String[] args) {
        int[] arr = {5, 6, 9, 0, 2, 1, 3, 7, 4, 8};

        int[] sortedArr = sort(arr);

        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] sort (int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            // Print the array at every change so you can watch it go :)
            System.out.println(Arrays.toString(arr));

            int max = arr[i];
            int maxIndex = i;

            for (int j = i; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = max;
            arr[maxIndex] = temp;
        }

        return arr;
    }
}
