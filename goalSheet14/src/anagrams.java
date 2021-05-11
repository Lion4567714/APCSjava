import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

/**
 * <b>Anagrams GS14-03</b>
 * Write a program that discovers all anagrams of all words listed in an input file that stores the
 * entries in a large dictionary. Write and use a comparator.
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-5-10
 */

public class anagrams {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("src\\anagramFile.txt"));

        HashMap<String, TreeMap<Character, Integer>> dict =
                new HashMap<String, TreeMap<Character, Integer>>();

        //  Store all file information in dict
        while (input.hasNextLine()) {
            String s = input.nextLine();
            TreeMap<Character, Integer> m = new TreeMap<Character, Integer>();

            for (char c : s.toCharArray()) {
                if (c != ' ') {
                    m.putIfAbsent(c, 0);
                    m.put(c, m.get(c) + 1);
                }
            }

            dict.put(s, m);
        }

        System.out.println("Anagrams:");

        //  Search for all possible anagrams
        for (String s : dict.keySet()) {
            System.out.print(s + ": ");

            for (String t : dict.keySet()) {
                if (!s.equals(t) && compare(dict.get(s), dict.get(t))) {
                    System.out.print(t + " ");
                }
            }

            System.out.println();
        }
    }

    /**
     * Compares TreeMaps of <Character, Integer>. Could be replaced with m1.equals(m2), but because
     * a comparator is required I'm doing this manually.
     * @param m1
     * @param m2
     * @return true if both TreeMaps contain identical letters and corresponding frequencies
     *              (if the words are anagrams)
     */
    public static boolean compare (TreeMap<Character, Integer> m1, TreeMap<Character, Integer> m2) {
        if (m1.keySet().size() != m2.keySet().size()) {
            return false;   // Words do not contain the same number of variants of characters
        } else {
            for (char c : m1.keySet()) {
                if (!m2.containsKey(c)) {
                    return false;   // Words do not have the same characters
                } else {
                    if (m1.get(c) != m2.get(c)) {
                        return false;   // Words do not have the same number of the same characters
                    }
                }
            }
        }

        return true;    // The word is an anagram
    }
}
