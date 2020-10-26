/*
Name:       Anders Gilliland
Project:    GS04-03 processName
Purpose:    Write a method that accepts a scanner for the console as a parameter and prompts teh user to enter
                a full name as a string String. Output in reverse order
 */

import java.util.*;

public class processNameClass {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Input a first and last name, follow with enter:");
        System.out.println(processName(console));
    }

    public static String processName (Scanner input) {
        String first;
        String last;
        first = input.next();
        last = input.next();
        return last + ", " + first;
    }
}
