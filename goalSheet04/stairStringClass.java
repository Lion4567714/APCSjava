/*
Name:       Anders Gilliland
Project:    GS04-05 stairString
Purpose:    Write a method that takes two parameters as input, a String and an integer
                (number of lines the string will be on). Divide the string into an indicated
                number of substrings so that each is placed one line below the next in the same
                horizontal location if it were on the same line
 */

import java.util.*;

public class stairStringClass {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Input a string to be converted into stairs, " +
                "and the numbers of stairs you want followed by enter:");
        String inputString = console.nextLine();
        int stairs = console.nextInt();
        stairString(inputString, stairs);
    }

    public static void stairString (String input, int stairs) {
        //  If the user wants 0 less stairs, stop the function and do not print anything.
        if (stairs <= 0) {
            return;
        }

        //  The length of each substring is determined by the number of characters needed to be
        //  printed, divided by how many stairs I need. This is the interval the subMax needs to
        //  be changed by with every loop.
        int subLength = input.length() / stairs;

        //  The endIndex for each substring. This will change within the loop.
        int subMax = subLength;

        //  The placeholder for the required padding after each stair.
        String padding = "";

        //  For each substring/stair I need, display the substring and move to the next by
        //  increasing both i and subMax, the begin and end index, by the required length.
        for (int i = 0; i < input.length(); i += subLength, subMax += subLength) {
            //  Outputs the substring.
            System.out.print("\n" + padding + input.substring(i, subMax));

            //  If the endIndex for the substring will go above the limit of the string input,
            //  it means that there is still extra stuff to print out. Add the extra stuff to
            //  the existing stair, without creating a new one, and end the loop.
            if (subMax + subLength > input.length()) {
                System.out.print(input.substring(subMax));
                break;
            }

            //  After each stair has been created, add spaces to include into the next one. The
            //  number of spaces the based on the length of each substring.
            for (int j = 0; j < subLength; j++) {
                padding += " ";
            }
        }

        //One last extra space for neatness
        System.out.println();
    }
}
