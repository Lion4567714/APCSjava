import java.io.*;
import java.util.*;

/**
 * <b>Levenshtein Distance GS14-01</b>
 * Find the edit (Levenshtein) distance between words. Read words from a sorted dictionary file.
 * Compute a map from every word to its immediate neighbors (the words that have an edit distance of
 * 1 from it). You can walk the map to find paths from one word to another, and can use a linked
 * list of words to visit neighbors.
 *
 * @author Anders Gilliland
 * @version 0.4
 * @since 2021-5-27
 */
public class levenshtein {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new File("src\\dictionarySortedLength.txt"));
        String[] dict = new String[370099];
        LinkedHashMap<String, LinkedHashSet<String>> neighbors =
                new LinkedHashMap<String, LinkedHashSet<String>>();

        for (int i = 0; i < dict.length; i++) {
            dict[i] = scanner.next();
        }

        Scanner console = new Scanner(System.in);
        System.out.println("Find neighbors from [1] the dictionary (slow)" +
                " or [2] saved file (fast)?");
        switch (console.nextInt()) {
            case 1 -> neighbors = searchAllNeighbors(dict);
            case 2 -> neighbors = readFile();
        }

        System.out.println("\n\nWhich two words would you like to find a path between?");
        findPath(console.next(), console.next(), neighbors);
    }

    /**
     * <i>Search All Neighbors Function</i>
     * Searches the entire dictionary using the oneEdit function for every 1-edit neighbor. Outputs
     * progress to the console and results to a text file for review.
     * @param dict Used dictionary
     * @return LinkedHashMap of dictionary words with attached LinkedHashSets of neighbors
     * @throws IOException
     */
    public static LinkedHashMap<String, LinkedHashSet<String>> searchAllNeighbors (String[] dict)
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

        LinkedHashMap<String, LinkedHashSet<String>> allNeighbors =
                new LinkedHashMap<String, LinkedHashSet<String>>();
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
            LinkedHashSet<String> set = oneEdit(s, dict, lenIdx[min - 1], lenIdx[max - 1]);

            writer.write(s + " " + set);
            if (i != 370099) {
                writer.write("\n");
            }
            System.out.println(i + " / 370099");

            allNeighbors.put(s, set);
        }

        writer.close();
        return allNeighbors;
    }

    /**
     * <i>One Edit Function</i>
     * Searches the dictionary for appropriate 1-edit neighbors
     * ***** PROBLEM: doesn't find neighbors like "dog" and "doog" *****
     * @param s1 Word to find neighbors for
     * @param dict Dictionary to search through
     * @param min Lower bound of search
     * @param max Upper bound of search
     * @return LinkedHashSet of neighbors
     */
    public static LinkedHashSet<String> oneEdit (String s1, String[] dict, int min, int max) {
        LinkedHashSet<String> neighbors = new LinkedHashSet<String>();

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

    /**
     * <i>Read File Function</i>
     * Reads the contents of the Levenshtein output file. Used instead of the Search All Neighbors
     * Function to quicken the process of finding paths for demonstration purposes.
     * @return Complete list of neighbors
     * @throws FileNotFoundException
     */
    public static LinkedHashMap<String, LinkedHashSet<String>> readFile ()
            throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("src\\levenshteinOutput.txt"));
        scanner.useDelimiter(",");
        LinkedHashMap<String, LinkedHashSet<String>> neighbors =
                new LinkedHashMap<String, LinkedHashSet<String>>();

        while (scanner.hasNextLine()) {
            LinkedHashSet<String> value = new LinkedHashSet<String>();

            String line = scanner.nextLine();
            line = line.replaceAll("[:]|[,]|[\\[]|[]]", "");
            String[] arr = line.split("\\s");

            value.addAll(Arrays.asList(arr));

            neighbors.put(arr[0], value);
        }

        return neighbors;
    }

    public static void findPath (String s1, String s2, LinkedHashMap<String,
            LinkedHashSet<String>> n) {
        if (!n.containsKey(s1) || !n.containsKey(s2)) {
            System.out.println("Invalid Input Detected, please try again.");
            return;
        }

        ArrayList<String> defaultPath = new ArrayList<String>();
        defaultPath.add(s1);
        ArrayList<ArrayList<String>> paths = recursivePathFinder(s1, s2, n, defaultPath, 1,
                new ArrayList<>());

        if (paths.isEmpty()) {
            System.out.println("There are no valid paths between those two words.");
            return;
        }

        ArrayList<String> shortPath = paths.get(0);
        for (ArrayList<String> a : paths) {
            if (a.size() > shortPath.size()) {
                shortPath = a;
            }
        }

        System.out.println(paths.size() + " path(s) found!");
        System.out.println("Shortest path (" + shortPath.size() + " elements):");
        System.out.println(shortPath.toString() + "\n");
        for (ArrayList<String> a : paths) {
            System.out.println(a.toString());
        }
    }

    /**
     * <i>Recursive Path Finder Function</i>
     * Recursively runs through and documents every possible path s1 can have to s2.
     * Welcome to the Pit of Infinite Confusion(tm)!
     * @param s1 The string being looked at for neighbors (starts as an initial string)
     * @param s2 The end-goal string
     * @param n List of neighbors
     * @param currentPath Path between one initial word and the current iteration
     * @param depth Distance of neighbors
     * @param paths List of all discovered paths
     * @return An updated list of discovered paths
     */
    public static ArrayList<ArrayList<String>> recursivePathFinder (String s1, String s2
            , LinkedHashMap<String, LinkedHashSet<String>> n, ArrayList<String> currentPath
            , int depth, ArrayList<ArrayList<String>> paths) {
        // Run through each neighbor the current neighbor has
        for (String str : n.get(s1)) {
            if (currentPath.contains(str)) {
                continue;   // Prevents running in circles
            }

            // If a neighbor of the current string has already been checked, reset the depth
            if (currentPath.size() == depth) {
                currentPath.remove(depth - 1);
            }
            currentPath.add(str);

            // If the current neighbor has the end-goal as a neighbor, add this path to the list
            if (str.equals(s2)) {
                paths.add(currentPath);
                return paths;
            }

            // Search through the current string's neighbors for a path
            recursivePathFinder(str, s2, n, currentPath, depth + 1, paths);
        }

        // All paths at this level have been discovered, return to the previous level of depth
        return paths;
    }
}