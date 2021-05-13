import java.util.Scanner;

/**
 * <b>WriteSquares GS10-02</b>
 * Write a recursive method, writeSquares, that accepts an integer parameter n and prints the first
 * n squares separated by commas, with the odd squares in descending order followed by the even
 * squares in ascending order.
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-5-13
 */
public class WriteSquaresClass {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("How many squares do you want?");
        writeSquares(console.nextInt(), 0);
        System.out.println();
    }

    /**
     * <i>writeSquares</i>
     * Recursive method that outputs n squares, odd squares descending followed by even squares
     * ascending.
     * @param n Desired number of squares
     * @param i Current iteration (for recursive purposes, default 0 upon function call)
     */
    public static void writeSquares (int n, int i) {
        if (i < n / 2 || (n % 2 == 1 && i < n / 2 + 1)) {           // Descending
            if (n % 2 == 1) {                                       // Odd
                System.out.print((int)Math.pow(n - i * 2, 2));
            } else {                                                // Even
                System.out.print((int)Math.pow(n - i * 2 - 1, 2));
            }
        } else {                                                    // Ascending
            if (n % 2 == 0) {                                       // Even
                System.out.print((int)Math.pow(i * 2 - n + 2, 2));
            } else {                                                // Odd
                System.out.print((int)Math.pow(i * 2 - n + 1, 2));
            }
        }

        if (i < n - 1) {                                            // Last iteration
            System.out.print(", ");
            writeSquares(n, i + 1);
        }
    }
}