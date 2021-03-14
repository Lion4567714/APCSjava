import java.util.*;
import java.io.*;

/**
 * Write code to read a dictionary from a file, then prompt the user for two words and tell the user
 * how many words in the dictionary fall between those words. Use (implement) the binary search
 * algorithm.
 *
 * @author Anders Gilliland
 * @version 0.1
 * @since 2021-3-9
 */
public class BinarySearch {
    public static void main (String[] args) throws IOException {
        // Set up the dictionary into a set, line by line
        Set<String> dictionary = new HashSet<String>();
        Scanner file = new Scanner(new File("dictionary.txt"));
        while (file.hasNext()) {
            dictionary.add(file.nextLine());
        }

        // Receive and store user input for the word bounds
        Scanner console = new Scanner(System.in);
        System.out.print("\nEnter the first word...   ");
        String word1 = console.next();
        System.out.print("\nEnter the second word...   ");
        String word2 = console.next();

        //int word1Index = search(word1, dictionary, 0, dictionary.size());
    }

    /**
     * Search function that looks for the placement of a given word in a dictionary and returns the
     * index of said word.
     *
     * @param input Given word to search for
     * @param dictionary Dictionary to search within
     * @param left Left bound for the search, default input 0
     * @param right Right bound for the search, default input dictionary size
     * @param i Index of the letter to be looking for in the dictionary
     * @return The index of the input in the dictionary
     */
    //public static int search (String input, Set<String> dictionary, int left, int right, int i) {

        //int mid = (left + right) / 2;
        //if ()
    //}
}
