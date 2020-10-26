/*
Name:       Anders Gilliland
Project:    GS04-01 padString
Purpose:    Write a method accepting two parameters: a String and an integer representing a length of spaces to pad
 */

import java.util.*;

public class padStringClass {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string the desired length of string (to be padded with spaces), followed by enter:");
        String inputString = scanner.nextLine();
        int inputInt = scanner.nextInt();
        System.out.println("[" + padString(inputString, inputInt) + "]");
    }

    public static String padString (String string, int length) {
        while (string.length() < length) {
            string += " ";
        }
        return string;
    }
}
