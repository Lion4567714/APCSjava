//  Name:       Anders Gilliland
//  Project:    GS07-02 minToFront (half)
//  Purpose:    Write a method that takes an arrayList of integers as a parameter and moves the
//              minimum value to the front, otherwise preserving the order of the elements

import java.util.Scanner;
import java.util.ArrayList;

public class minToFrontClass {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = scaleByKClass.getArrayList();

        minToFront(list);

        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //  Method for bringing the minimum integer value in an arrayList to the front, otherwise
    //  preserving the order of the elements
    //
    //  Parameters: Integer arrayList to be modified and returned
    public static ArrayList minToFront (ArrayList<Integer> list) {
        //  Set the initial minValue to the first element of the list as a base to go off of
        int minValue = list.get(0);

        for (int i : list) {
            if (i < minValue) {
                minValue = i;
            }
        }

        list.remove(list.indexOf(minValue));

        // add() shifts all other elements in the list over give space for the new element
        list.add(0, minValue);

        return list;
    }
}
