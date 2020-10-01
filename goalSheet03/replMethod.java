/*
Name:       Anders Gilliland
Project:    GS03-01 repl
Purpose:    Use a method to repeat inputted strings
 */

import java.util.*;

public class replMethod {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string to be repeated followed by [enter]," +
                " then input the number of times you want the string to be repeated followed by [enter]:");
        String input = scanner.nextLine();
        int repititons = scanner.nextInt();

        System.out.println("" + repl(input, repititons));
    }

    public static String repl (String input, int repititions) {
        String output = "";
        for (int i = 0; i < repititions; i++) {
            output += input;
        }
        return output;
    }
}
