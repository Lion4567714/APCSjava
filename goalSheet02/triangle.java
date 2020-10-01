/*
Name:       Anders Gilliland
Project:    GS02-05 Triangle
Purpose:    With given triangle side lengths, output the angles of the triangle
 */

import java.util.*;

public class triangle {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the lengths for three sides of a triangle (press enter after each number)(a, b, c):\t");

        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();

        System.out.printf("\nAngle a: %.4f\u00B0", Math.toDegrees(Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c))));
        System.out.printf("\nAngle b: %.4f\u00B0", Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c))));
        System.out.printf("\nAngle c: %.4f\u00B0\n", Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b))));
    }
}
