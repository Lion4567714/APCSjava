import java.util.Scanner;

/**
 * <b>isReverse GS14-02</b>
 * Write a recursive method (isReverse) that accepts two strings as parameters and returns true if
 * the two strings contain the same sequence of characters as each other but in opposite order
 * (ignoring capitalization), and false otherwise. An empty string, as well as any one-letter
 * string, is considered to be its own reverse.
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-5-11
 */

public class isReverseClass {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Input two strings to be compared:");
        System.out.println(isReverse(console.next(), console.next(), 0));
    }

    public static boolean isReverse (String s1, String s2, int index) {
        if (s1.length() != s2.length()) {
            return false;
        } else if (s1.length() == 0) {
            return true;
        }

        if (index == s1.length()) {
            return true;
        } else {
            return (Character.toLowerCase(s1.charAt(index)) ==
                    Character.toLowerCase(s2.charAt(s2.length() - index - 1)) &&
                    isReverse(s1, s2, index + 1));
        }
    }
}
