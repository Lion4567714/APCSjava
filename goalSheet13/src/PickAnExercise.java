import java.util.HashMap;

/**
 * <b>Pick An Exercise GS13-05</b>
 * <i>Building Java Programs Chapter 11 Exercise 13</i>
 * Write a method isUnique that accept a map whose keys and values are strings as a parameter and
 * returns true if no two keys map to the same value
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-3-24
 */
public class PickAnExercise {
    public static void main (String[] args) {
        HashMap<String, String> trueMap = new HashMap<String, String>();
        trueMap.put("Marty", "Stepp");
        trueMap.put("Stuart", "Reges");
        trueMap.put("Jessica", "Miller");
        trueMap.put("Amanda", "Camp");
        trueMap.put("Hal", "Perkins");

        HashMap<String, String> falseMap = new HashMap<String, String>();
        falseMap.put("Kendrick", "Perkins");
        falseMap.put("Stuart", "Reges");
        falseMap.put("Jessica", "Miller");
        falseMap.put("Bruce", "Reges");
        falseMap.put("Hal", "Perkins");

        System.out.println(isUnique(trueMap) + "  " + isUnique(falseMap));
    }

    public static boolean isUnique (HashMap<String, String> map) {
        HashMap<String, Integer> valueMap = new HashMap<String, Integer>();

        for (String s : map.values()) {
            if (valueMap.get(s) != null) {
                return false;
            }

            valueMap.put(s, 1);
        }

        return true;
    }
}
