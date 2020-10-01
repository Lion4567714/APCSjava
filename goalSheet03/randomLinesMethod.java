/*
Name:       Anders Gilliland
Project:    GS03-04 Random Lines
Purpose:    Write a method that prints random strings of letters
Note:       97  - a
            122 - z
 */

import java.util.Random;

public class randomLinesMethod {
    public static void main (String[] args) {
        randomLines((int)(Math.random() * (10 - 5 + 1) + 5)); //random number of lines between 5 and 10
    }

    public static void randomLines(int lines) {
        Random random = new Random();
        int characters;

        for (int i = 0; i < lines; i++) {   //for each line
            characters = random.nextInt(81);    //find a random number of characters to print on the line

            for (int j = 0; j < characters; j++) {  //for each character
                System.out.printf("%c", (int)(Math.random() * (122 - 97 + 1) + 97));
            }

            System.out.println("");
        }
    }
}
