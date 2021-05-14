import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * <b>Levenshtein Distance GS14-01</b>
 * Find the edit (Levenshtein) distance between words. Read words from a sorted dictionary file.
 * Compute a map from every word to its immediate neighbors (the words that have an edit distance of
 * 1 from it). You can walk the map to find paths from one word to another, and can use a linked
 * list of words to visit neighbors.
 *
 * @author Anders Gilliland
 * @version 0.1
 * @since 2021-5-13
 */
public class levenshtein {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src\\dictionarySortedLength.txt"));
        String[] dict = new String[370099];

        for (int i = 0; i < dict.length; i++) {
            dict[i] = scanner.next();
        }

        for (int i = 1; i < dict.length; i++) {
            for (int j = 0; j < dict[i].length() - dict[i - 1].length(); j++) {
                System.out.print(i + " ");
            }
        }

        /*int most = 0;
        for (String s : dict) {
            int i;
            i = oneEdit(s, dict).length;
            if (i > most) {
                most = i;
            }
        }

        System.out.println(most);*/
    }

    public static String[] oneEdit (String str, String[] dict) {
        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////

        ArrayList<String> neighbors = new ArrayList<String>();

        for (String s : dict) {
            System.out.println(s);
            // If the word is 2 characters shorter, skip
            if (s.length() < str.length() - 1) {
                continue;
            }

            // Once the loop is past the words 2 characters longer than the word, there is no point
            // in continuing to search
            if (s.length() > str.length() + 1) {
                return neighbors.toArray(new String[0]);
            }

            // Find the shorter of the two words to base the loop's iterations off of
            String shorter = s;
            if (str.length() < s.length()) {
                shorter = str;
            }

            // Compare each individual character for differences
            int edits = 0;
            for (int i = 0; i < shorter.length(); i++) {
                if (s.charAt(i) != str.charAt(i)) {
                    edits++;
                }

                if (edits > 1) {
                    break;
                }
            }

            if (edits > 1 || edits == 1 && s.length() != str.length()) {
                continue;
            }

            neighbors.add(s);
        }

        return neighbors.toArray(new String[0]);
    }
}