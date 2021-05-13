import java.util.Scanner;

/**
 * <b>Fibonacci (Recursive) GS10-01</b>
 * Write a recursive method that takes an integer argument n and gives the nth number in the
 * Fibonacci series. The method that tests the recursive method (may use a loop) should display the
 * series up through the nth number.
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-5-11
 */
public class Fibonacci {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("How many numbers from the Fibonacci series do you want?");
        testFibonacci(console.nextInt());
    }

    public static void testFibonacci (int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(recursiveFibonacci(i) + " ");
        }
        System.out.println();
    }

    public static int recursiveFibonacci (int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }
}