/**
 * <b>(More Efficient Recursive) Fibonacci GS11-05</b>
 * Write a new version of the method that is still recursive and has the same header but is more
 * efficient. Do this by creating a helper method that accepts additional parameters, such as
 * previous Fibonacci numbers, that you can carry through and modify during each recursive call.
 *
 * @author Anders Gilliland
 * @version 1.0
 * @since 2021-3-30
 **/
public class betterFibonacci {
    public static void main (String[] args) {

    }

    public static int fibonacci (int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
