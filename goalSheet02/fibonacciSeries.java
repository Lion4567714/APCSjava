/*
Name:       Anders Gilliland
Project:    GS02 Fibonacci Series
Purpose:    Find a specific number in the fibonacci series using a for loop and not recursion
Note:       The book calls for a "for" loop, but the goal sheet calls for "nested loops". I found no need to nest loops and only used one "for" loop
                Does this work for the goal sheet?
 */

import java.util.*;

public class fibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhich place of the fibonacci series do you want? (int):\t");
        int place = scanner.nextInt();

        int olderFibNum = 0;
        int oldFibNum = 0;
        int FibNum = 1;
        for (int i = 0; i < place; i++) {
            if (i == place - 1)
                System.out.print(" (" + FibNum + ")\n\n");
            else
                System.out.print(" " + FibNum);

            olderFibNum = oldFibNum;
            oldFibNum = FibNum;
            FibNum = olderFibNum + oldFibNum;
        }
    }
}
