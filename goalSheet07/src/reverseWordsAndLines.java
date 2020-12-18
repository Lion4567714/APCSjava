//  Name:       Anders Gilliland
//  Project:    GS07-05 Reverse Words and Lines
//  Purpose:    Write a program to reverse the lines of a file and also to reverse the order of the
//              words in each line of the file. Use arrayLists to help. (BJP Ch 10 Proj 2)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class reverseWordsAndLines {
    public static void main (String[] args)
            throws FileNotFoundException {
        File file = new File("C:\\Users\\Anders Gilliland\\Documents\\GitHub\\apcsJava" +
                "\\goalSheet07\\src\\file.txt");
        reverse(file);
    }

    //  Method for reversing both the lines and words of a file using ArrayLists
    //  Output is printed out to the console rather than to a file because I don't want to overwrite
    //  the original file and I'm lazy :)
    public static void reverse (File file)
            throws FileNotFoundException {
        //  Scanner to read the contents of the given file
        Scanner fileScan = new Scanner(file);
        fileScan.useDelimiter("\\n");

        //  ArrayList with each line of the file as an element
        ArrayList<String> lines = new ArrayList<String>();

        //  Populate the lines ArrayList
        while (fileScan.hasNextLine()) {
            lines.add(fileScan.nextLine());
        }

        //  For each line in the ArrayList...
        //  Run through each line in reverse order (last line first, and so on)
        for (int i = lines.size() - 1; i >= 0; i--) {
            //  Scanner to read this line (for delimiting)
            Scanner lineScan = new Scanner(lines.get(i));
            lineScan.useDelimiter(" ");

            //  ArrayList with each word in the line
            ArrayList<String> words = new ArrayList<String>();

            //  Populate the words ArrayList
            while (lineScan.hasNext()) {
                words.add(lineScan.next());
            }

            //  For each word in the ArrayList...
            //  Run through each word in reverse order (last word first, and so on)
            for (int j = words.size() - 1; j >= 0; j--) {
                //  Print the word to the console
                System.out.print(words.get(j) + " ");
            }

            //  Newline spacing
            System.out.println();
        }
    }
}
