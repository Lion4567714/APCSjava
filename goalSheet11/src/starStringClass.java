//
//  Name:       Anders Gilliland
//  Project:    GS11-01 starString
//  Purpose:    Write a recursive method that accepts an integer as a parameter and prints to the
//              console a string of asterisks that is 2^n long

import java.util.Scanner;

public class starStringClass {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many stars would you like? (# = 2^input) Integers only!");
        starString(scanner.nextInt(), -1, "");
    }

    //  Recursive method that outputs 2^n asterisks to the console
    //  Parameters: n = power of asterisks
    //              i = current iteration of method, initially -1 to keep in line with the power
    //              s = asterisk string to be outputted
    public static void starString (int n, int i, String s) {

        //  If this the is the first iteration or the user wants a power of 0, set the initial value
        if (n == 0) {
            System.out.println("*");
            return;
        } else if (i == -1) {
            s = "*";

            //  Move on to the next iteration
            i++;
            starString(n, i, s);

            //  Credit goes to Zach Conway for helping me find out my this method repeated itself
            //  twice. In attempt to keep the recursion while skipping the string concatenation
            //  later, I included line 33. What I didn't realize was that once the method finishes
            //  its work, it then goes back to this point and does it all over again which means I
            //  needed a return here. Thanks Zach!
            return;
        }

        //  Increase the number of stars to the next power and add one to the iteration count
        s = s + s;
        i++;

        //  If the iterating is done, print the string and stop the recursion. If not, continue.
        if (i == n) {
            System.out.println(s);
        } else {
            starString(n, i, s);
        }
    }
}
