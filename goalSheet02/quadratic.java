/*
Name:       Anders Gilliland
Project:    GS02 Quadratic
Purpose:    Receive coefficients from user and output "zeros" from the resulting quadratic equation
 */

import java.util.*;

public class quadratic {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033[3max^2 + bx + c\033[0m");
        System.out.println("Input coefficients for a, b, and c (press enter after each number):\t");

        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();

        System.out.printf("\n%.3fx^2 + %.3fx + %.3f", a, b, c);

        double x1 = (-b + Math.sqrt((b * b) - 4 * a * c)) / 2 * a;
        double x2 = (-b - Math.sqrt((b * b) - 4 * a * c)) / 2 * a;

        System.out.printf("\nx = %f, x = %f\n", x1, x2);
    }
}