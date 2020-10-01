/*
Name:       Anders Gilliland
Project:    GS02-01 Output Squares
Purpose:    Output squares from 1 to a given number without using multiplication
 */

import java.util.*;

public class outputSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many squares do you want?\t");
        int squares = scanner.nextInt();

        int i;
        int output = 1;
        int addition = 3;
        System.out.print("1 ");
        for (i = 0; i < squares - 1; i++) {
            System.out.print(output + addition + " ");
            output += addition;
            addition += 2;
        }
    }
}
