import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;

/**
 * <b>Levenshtein Distance GS14-01</b>
 * Find the edit (Levenshtein) distance between words. Read words from a sorted dictionary file.
 * Compute a map from every word to its immediate neighbors (the words that have an edit distance of
 * 1 from it). You can walk the map to find paths from one word to another, and can use a linked
 * list of words to visit neighbors.
 *
 * @author Anders Gilliland
 * @version 0.2
 * @since 2021-5-25
 */
public class levenshtein {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new File("src\\dictionarySortedLength.txt"));
        String[] dict = new String[370099];

        for (int i = 0; i < dict.length; i++) {
            dict[i] = scanner.next();
        }

        searchAllNeighbors(dict);
    }

    /**
     * <i>Search All Neighbors Function</i>
     * Searches the entire dictionary using the oneEdit function for every 1-edit neighbor. Outputs
     * progress to the console and results to a text file for review.
     * @param dict Used dictionary
     * @return HashMap of dictionary words with attached HashSets of neighbors
     * @throws IOException
     */
    public static HashMap<String, HashSet<String>> searchAllNeighbors (String[] dict)
            throws IOException{
        // Search through the dictionary to find the indices where the number of characters change
        // This is used in the oneEdit function to minimize its area of search
        int[] lenIdx = new int[32];
        for (int i = 1; i < dict.length; i++) {
            if (dict[i].length() > dict[i - 1].length()) {
                lenIdx[dict[i].length() - 1] = i;
            }
        }

        // If there are no words of a certain length, use the previous index found
        for (int i = 1; i < lenIdx.length; i++) {
            if (lenIdx[i] == 0) {
                lenIdx[i] = lenIdx[i - 1];
            }
        }

        // Set up the output file for review
        File output = new File("src\\levenshteinOutput.txt");
        output.delete();
        output.createNewFile();
        FileWriter writer = new FileWriter(output);

        HashMap<String, HashSet<String>> allNeighbors = new HashMap<String, HashSet<String>>();
        int i = 0;  // Word index to display progress to the console
        for (String s : dict) {
            i++;

            // Find the appropriate indices oneEdit should search through
            int min = s.length() - 1;
            int max = min + 2;
            if (min < 1) {
                min = 1;
            } else if (max > 32) {
                max = 32;
            }

            // Find neighbors and record results
            HashSet<String> set = oneEdit(s, dict, lenIdx[min - 1], lenIdx[max - 1]);
            writer.write(s + ": " + set + "\n");
            System.out.println(i + " / 370099");
            allNeighbors.put(s, set);
        }

        writer.close();
        return allNeighbors;
    }

    /**
     * <i>One Edit Function</i>
     * Searches the dictionary for appropriate 1-edit neighbors
     * @param s1 Word to find neighbors for
     * @param dict Dictionary to search through
     * @param min Lower bound of search
     * @param max Upper bound of search
     * @return HashSet of neighbors
     */
    public static HashSet<String> oneEdit (String s1, String[] dict, int min, int max) {
        HashSet<String> neighbors = new HashSet<String>();

        for (int i = min; i < max; i++) {
            String s2 = dict[i];
            if (s1.equals(s2)) {
                continue;   // Word is the same, i.e. not a neighbor
            }

            int lenDiff = Math.abs(s1.length() - s2.length());
            if (lenDiff > 1) {
                continue;   // Word is more than 1 length away, cannot be a 1-edit neighbor
            }

            // Find the shorter word to prevent an out of bounds index in the loop
            int shortLen = s2.length();
            if (s1.length() < s2.length()) {
                shortLen = s1.length();
            }

            // Search through both words to find edits
            int edits = 0;
            for (int j = 0; j < shortLen; j++) {
                if (s2.charAt(j) != s1.charAt(j)) {
                    edits++;
                }

                if (edits > 1) {
                    break;
                }
            }

            if (edits > 1 || edits == 1 && lenDiff == 1 &&
                    !s1.substring(0, shortLen).equals(s2.substring(0, shortLen))) {
                continue;   // Word is more than one edit away, or is one edit and one length away
            }

            neighbors.add(s2);
        }

        return neighbors;
    }
}