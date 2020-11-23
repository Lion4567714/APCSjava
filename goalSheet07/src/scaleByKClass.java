//  Name:       Anders Gilliland
//  Project:    GS07-01 scaleByK (half)
//  Purpose:    Write a method that takes an ArrayList of integers as a parameter and replaces
//              every integer of K value with K copies of itself. Remove zeros and negatives.

import java.util.Scanner;
import java.util.ArrayList;

public class scaleByKClass {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        //  Get input as a string array and parse into the integer arrayList
        System.out.println("Input a series of numbers separated by spaces and ended with enter:");
        String[] inputArr = scanner.nextLine().split(" ");
        for (String s : inputArr) {
            list.add(Integer.parseInt(s));
        }

        list = scaleByK(list);

        //  Output the arrayList
        for (int i : list) {
            System.out.print(i);
        }
        System.out.println();
    }

    //  Method for returning an integer list with each number K repeated K times. Removes zeroes
    //  and negatives.
    //
    //  Parameters: Integer ArrayList for copying
    public static ArrayList scaleByK (ArrayList<Integer> list) {
        //  New arrayList that will be returned at the end of the method
        ArrayList<Integer> endList = new ArrayList<Integer>();

        //  Foreach loop used so each element can be accessed in each iteration of the loop
        //  For each element in the list...
        for (int k : list) {
            //  Add K number of elements of value K to the return array
            for (int i = 0; i < k; i++) {
                //  Add element to the array
                endList.add(k);
            }
        }

        //  Return modified arrayList
        return endList;
    }
}
