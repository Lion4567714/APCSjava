/*
Name:       Anders Gilliland
Project:    GS03-02 PrintRange
Purpose:    Use a method to output all integers in a given range, increasing or decreasing
 */

import java.util.*;

public class printRangeMethod {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input two integers, each followed by [enter], to get the range of numbers between them:");

        int min = scanner.nextInt();
        int max = scanner.nextInt();

        printRange(min, max);
    }

    public static void printRange(int min, int max) {
        if (min == max)         //if min and max are same
            System.out.println("[" + min + "]");
        else if (min < max) {   //if min is less than max
            System.out.print("[");
            for (int i = min; i < max; i++) {
                System.out.print(i + ", ");
            }
            System.out.print(max + "]");
        }
        else {                  //if min is more than max
            System.out.print("[");
            for (int i = min; i > max; i--) {
                System.out.print(i + ", ");
            }
            System.out.print(max + "]");
        }
        System.out.println(""); //extra space for neatness
    }
}
