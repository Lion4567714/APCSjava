import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
import java.math.BigInteger;

/**
 * <b>Levenshtein Distance GS14-01</b>
 * Find the edit (Levenshtein) distance between words. Read words from a sorted dictionary file.
 * Compute a map from every word to its immediate neighbors (the words that have an edit distance of
 * 1 from it). You can walk the map to find paths from one word to another, and can use a linked
 * list of words to visit neighbors.
 *
 * @author Anders Gilliland
 * @version 0.1
 * @since 2021-3-24
 */
public class levenshtein {
    public static void main (String[] args)
            throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src\\dictionarySortedLength.txt"));
        String[] dictionary = new String[370099];

        int i = 0;
        while (scanner.hasNextLine()) {
            dictionary[i] = scanner.next();
        }

        BigInteger[] hashArray = hash(dictionary);

        for (BigInteger b : hashArray) {
            System.out.println(b.toString());
        }
    }

    /**
     * Hashes a string array dictionary into an array of BigIntegers
     * @param input dictionary of String[370099]
     * @return BigInteger[370099] of hashes
     */
    public static BigInteger[] hash (String[] input) {

        BigInteger[] hashCodes = new BigInteger[370099];

        for (int i = 0; i < input.length; i++) {
            String word = input[i];
            BigInteger code = new BigInteger("0");

            for (char c : word.toCharArray()) {
                code = code.multiply(new BigInteger("27"));

                // Switch expressions are from Java 12, but it is also more pleasant to look at than
                // a normal switch four times the size.
                code = switch (c) {
                    case 'a' -> code.add(new BigInteger("1"));
                    case 'b' -> code.add(new BigInteger("2"));
                    case 'c' -> code.add(new BigInteger("3"));
                    case 'd' -> code.add(new BigInteger("4"));
                    case 'e' -> code.add(new BigInteger("5"));
                    case 'f' -> code.add(new BigInteger("6"));
                    case 'g' -> code.add(new BigInteger("7"));
                    case 'h' -> code.add(new BigInteger("8"));
                    case 'i' -> code.add(new BigInteger("9"));
                    case 'j' -> code.add(new BigInteger("10"));
                    case 'k' -> code.add(new BigInteger("11"));
                    case 'l' -> code.add(new BigInteger("12"));
                    case 'm' -> code.add(new BigInteger("13"));
                    case 'n' -> code.add(new BigInteger("14"));
                    case 'o' -> code.add(new BigInteger("15"));
                    case 'p' -> code.add(new BigInteger("16"));
                    case 'q' -> code.add(new BigInteger("17"));
                    case 'r' -> code.add(new BigInteger("18"));
                    case 's' -> code.add(new BigInteger("19"));
                    case 't' -> code.add(new BigInteger("20"));
                    case 'u' -> code.add(new BigInteger("21"));
                    case 'v' -> code.add(new BigInteger("22"));
                    case 'w' -> code.add(new BigInteger("23"));
                    case 'x' -> code.add(new BigInteger("24"));
                    case 'y' -> code.add(new BigInteger("25"));
                    case 'z' -> code.add(new BigInteger("26"));
                    default -> code;
                };

                hashCodes[i] = code;
            }
        }

        return hashCodes;
    }

    public static void distance (String word1, String word2) {

    }
}

// a = 97
// b = 98
// c = 99
// ab = 979899
// if starts with a 9, will be 2 digits
// ab = 97 98
// check for 97 +- 1
//
// check for 98 +- 1

// a = 1 * 2500
// b = 2 * 50
// c = 3
// z = 26
// abc = 2603
// 2603 / 50 = 52, 2603 % 50 = 3

// a = 1 ... * 50

// Hashtable<Integer (first bit of my hash), LinkedList (the rest?)> table