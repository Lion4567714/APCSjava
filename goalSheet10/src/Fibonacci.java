//
//  Name:       Anders Gilliland
//  Project:    GS10-01 Fibonacci (recursive)
//  Purpose:    Write a recursive method that takes an integer argument n and gives the nth number
//                  in the Fibonacci series. It may use a loop and should display the series up
//                  through the nth number.
//

import java.util.Scanner;

public class Fibonacci {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);

        //  Give the recursiveFibonacci method a number of places to print out from user input
        System.out.println("Fibonacci Series");
        System.out.println("How many places do you want to be displayed?");
        recursiveFibonacci(0, 1, console.nextInt(), 2);
    }

    //  Takes integers for the first and second previous numbers to add together as well as the
    //  number of Fibonacci places wanted and current place printed.
    public static void recursiveFibonacci (int first, int second, int n, int i) {

        //  Check if n is 1 or 2, in which case no recursion is needed because those values are
        //  already given (0 and 1). Otherwise if this the first run, print out the first two.
        //  Returns are not required in a void method, but may be used so that the function can be
        //  stopped when appropriate.
        if (n == 1) {
            System.out.print("0 ");
            return;
        } else if (n == 2) {
            System.out.print("1 ");
            return;
        } else if (i < 2) {
            System.out.print("0 1 ");
            i = 2;
        }

        //  Save the next number Print out the next number in the series
        System.out.print(first + second + " ");

        //  Stop the recursion if this is the last place wanted
        i++;
        if (i == n) {
            return;
        }

        //  Shuffle the numbers down the line and call the recursive method
        first = second;
    }
}
