import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

/**
 * <b>Dictionary Unorganizer</b>
 * Simple scrambling program for testing the mergesort program. Reads from a dictionary of about
 * 370,000 words and scrambles them as many times as the user desires.
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-12-5
 */
public class DictionaryUnorganizer {
    public static void main (String[] args) throws IOException {
        // Read the sorted dictionary into a string array
        File input = new File("src\\dictionarySortedLength.txt");
        List<String> list = Files.readAllLines(input.toPath());
        String[] arr = list.toArray(new String[list.size()]);

        Scanner console = new Scanner(System.in);
        System.out.println("How many scrambles do you want?");
        arr = unsort(arr, console.nextInt());

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

    /**
     * <i>Unsort</i>
     * "Unsorts" a sorted array to be re-sorted later by swapping two strings in the array one at a
     * time. The number of swaps is determined by parameter n.
     * @param arr Sorted array to be scrambled
     * @param n Number of scrambles
     * @return Scrambled string array
     */
    public static String[] unsort (String[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int a = (int)(Math.random() * arr.length);
            int b = (int)(Math.random() * arr.length);
            String temp = arr[a];

            arr[a] = arr[b];
            arr[b] = temp;
        }

        return arr;
    }
}
