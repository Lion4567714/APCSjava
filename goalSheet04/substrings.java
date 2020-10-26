/*
Name:       Anders Gilliland
Project:    GS04-04 substrings
Purpose:    Write a method that takes a String and an integer (max length) and output the necessary substrings
                of the given length of original String on separate lines
 */

import java.util.*;

public class substrings {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Input a string to be split up into section of an inputted number. Follow input with enter:");
        String stringInput = console.nextLine();
        int intInput = console.nextInt();
        subStringMaker(stringInput, intInput);
    }

    public static void subStringMaker (String input, int maxLength) {
        int subMax = maxLength;
        for (int i = 0; i < input.length(); i += maxLength) {
            System.out.println(input.substring(i, subMax));
            if (subMax + maxLength > input.length()) {
                subMax = input.length();
            } else {
                subMax += maxLength;
            };
        }
    }
}
