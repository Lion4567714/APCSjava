import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.io.File;
import java.util.List;

/**
 * <b>Merge Sort GS10-04</b>
 * Write a program that read a series of input lines and sorts them into alphabetical order,
 * ignoring the case of wards. The program should use the merge sort algorithm so that it
 * efficiently sorts even a large file
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-5-12
 */
public class MergeSort {
    public static void main (String[] args) throws IOException {
        // Read the sorted dictionary into a string array
        File f = new File("src\\largeFile.txt");
        List<String> list = Files.readAllLines(f.toPath());
        String[] arr = list.toArray(new String[list.size()]);

        arr = sort(arr, arr.length);

        // Reset the existing file
        File output = new File("src\\largeFile.txt");
        output.delete();
        output.createNewFile();

        FileWriter writer = new FileWriter(output);
        for (String s : arr) {
            writer.write(s + "\n");
        }
        writer.close();
    }

    public static String[] sort (String[] arr, int n) {
        if (n < 2) {
            return arr;
        }

        int mid = n / 2;
        String[] l = new String[mid];
        String[] r = new String[n - mid];

        // Write two new arrays containing the left and right ends of the inputted array
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }

        sort(l, mid);
        sort(r, n - mid);

        merge(arr, l , r, mid, n - mid);

        return arr;
    }

    public static String[] merge (String[] arr, String[] l, String[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        // Sort individual elements alphabetically
        while (i < left && j < right) {
            if (compareAlpha(l[i], r[j]) == 1) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }

        // Put the array back together
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }

        return arr;
    }

    /**
     * <i>CompareAlpha</i>
     * Compares two strings by their alphabetical order
     * @param s1 string 1
     * @param s2 string 2
     * @return 0 - the strings contain the same word
     *        -1 - s2 should come before s1
     *         1 - s1 should come before s2
     */
    public static int compareAlpha (String s1, String s2) {
        // Find the shorter word to avoid an invalid index
        String shortWord = s1;
        if (s1.length() > s2.length()) {
            shortWord = s2;
        }

        for (int i = 0; i < shortWord.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return -1;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return 1;
            }
        }

        if (s1.equals(s2)) {
            return 0;   // The words are the same
        }

        if (s1.length() < s2.length()) {
            return 1;
        } else {
            return -1;
        }
    }
}
