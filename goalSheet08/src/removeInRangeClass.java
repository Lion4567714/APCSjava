//  Name:       Anders Gilliland
//  Project:    GS08-01 removeInRange
//  Purpose:    Write a method that accepts four parameters:
//                  a LinkedList
//                  an element value
//                  a starting index
//                  an editing index
//              The method should remove all occurrences of the given element that appear in the
//              list between the starting and ending index (inc - exc). Other values outside the
//              range are not affected.

import java.text.ParseException;
import java.util.LinkedList;
import java.util.Scanner;

public class removeInRangeClass {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();


    }

    //  Requests user input for integers to put into a LinkedList
    public static void populateLinkedList(LinkedList<Integer> list) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(" ");

        System.out.println("LinkedList Filler");
        System.out.println("Input a list of integers separated by spaces; press [Enter] to finish");
        System.out.println("--------------------\n");

        scanner.nextLine();

        while (scanner.hasNext()) {
            list.add(Integer.parseInt(scanner.next()));
        }
    }

    public static LinkedList<Integer> removeInRange(LinkedList<Integer> list, int value, int start,
                                                    int end) {

    }
}