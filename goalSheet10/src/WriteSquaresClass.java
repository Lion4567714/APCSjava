//
//  Name:       Anders Gilliland
//  Project:    GS10-02 Write Squares
//  Purpose:    Write a recursive method that accepts an integer parameter n and prints the first n
//                  squares separated by commas, with the odds squares in descending order followed
//                  by the even squares in ascending order.
//

import java.util.Scanner;

public class WriteSquaresClass {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("How many squares would you like?");
        int n = console.nextInt();

        writeSquares(n, n, false);
    }

    //  Parameters: n = number of squares, i = current square (default i = n), hasRecurred = false
    //      if the function has not recurred once already
    //  Recursive method that outputs n number of squares separated by commas
    //  Odd squares outputted in descending order, then even squares in ascending order
    public static void writeSquares(int n, int i, boolean hasRecurred) {

        //  If the first square is even, change the current square to the next odd square
        if (n % 2 == 0 && !hasRecurred) {
            i = n - 1;
        }

        //  Print out the current square, with comma if it's not the last
        //  If the printed square is not the last, then call this function again to continue
        if (n - i < 2 && hasRecurred) {
            System.out.println(Math.pow(i, 2) + ", ");

            //  Change the current square for the next iteration
            if (i == 1) {
                //  If the current square is 1, the next square will be 4
                i = 2;
            } else if (i % 2 == 1) {
                //  If the current square is odd but wasn't 1, subtract 2 to get the next odd number
                i = i - 2;
            } else {
                //  If the current square is even, add 2 to get the next even number
                i = i + 2;
            }

            hasRecurred = true;
            writeSquares(n, i, hasRecurred);
        } else {
            System.out.println(Math.pow(i, 2));
        }
    }
}