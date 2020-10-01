/*
Name:       Anders Gilliland
Project:    GS02-03 ASCII Stair
Purpose:    Use a class constant to output an ASCII staircase with a given number of steps
 */

import java.util.*;

public class asciiStair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many stairs do you want?\t");
        int stairs = scanner.nextInt();
        int length = stairs * 3 + 1;

        String[] stringOutput = stairMaker(stairs, length);

        for (int i = 0; i < length; i++) {
            System.out.println(stringOutput[i]);
        }
    }

    public static final String[] stairMaker(int stairs, int length) {

        int j = 0;
        String[] stairString = new String[length];

        for (int i = 0; i < length; i++) {  //add spaces to each line to prevent "null" when using += later
            stairString[i] = " ";
        }

        stairString[length - 1] = " ******";
        for (int i = 0; i < stairs; i++) {    //create the bottom line
            stairString[length - 1] += "*****";
        }

        while (j < stairs) {    //create each step, three lines at a time
            for (int k = 0; k < stairs - 1 - j; k++) {    //add the beginning tabs
                stairString[j * 3] += "     ";
                stairString[j * 3 + 1] += "     ";
                stairString[j * 3 + 2] += "     ";
            }

            stairString[j * 3] += "  o  ******";  //add the stick figure
            stairString[j * 3 + 1] += " /|\\ *     ";
            stairString[j * 3 + 2] += " / \\ *     ";

            for (int k = 0; k < j; k++) {   //add the ending tabs
                stairString[j * 3] += "     ";
                stairString[j * 3 + 1] += "     ";
                stairString[j * 3 + 2] += "     ";
            }

            j++;
        }

        for (int m = 0; m <= length - 1; m++) { //add the right edge of the staircase
            stairString[m] += "*";
        }

        return stairString;
    }
}
