//
//  Name:       Anders Gilliland
//  Project:    GS11-02 writeNums
//  Purpose:    Write a recursive method that takes an integer n as a parameter and prints the first
//              n integers starting with 1 in sequential order to the console, separated by commas
//

import java.util.Scanner;

public class writeNumsClass {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many integers (1+) would you like printed in sequence?");
        writeNums(scanner.nextInt(), 1);
    }

    //  Recursive method that outputs integers in sequential order separated by commas
    //  Parameters: n = user integer to get to from 0
    //              i = current integer outputted
    public static void writeNums (int n, int i) {

        //  If the desired number of integers is 1, output just that and stop
        //  If the method has reached the final integer, output it without the comma
        //  Otherwise, print out the integer, comma, and iterate again
        if (n == 1) {
            System.out.println("1");
        } else if (i == n) {
            System.out.println(i);
        } else {
            System.out.print(i + ", ");
            writeNums(n, i + 1);
        }
    }
}
