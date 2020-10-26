/*
Name:       Anders Gilliland
Project:    GS04-02 printReverse
Purpose:    Write a method that accepts a String as a parameter and prints it back in opposite order
 */

import java.util.*;

public class printReverseClass {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string to be reversed, followed by enter:");
        String stringInput = scanner.nextLine();
        System.out.println(printReverse(stringInput));
    }

    public static String printReverse (String input) {
        char[] output = new char[input.length()];
        int i = 0;
        int j = input.length() - 1;
        while (i < input.length()) {
            output[i] = input.charAt(j);
            i++;
            j--;
        }
        String stringOutput = String.valueOf(output);
        return stringOutput;
    }
}
