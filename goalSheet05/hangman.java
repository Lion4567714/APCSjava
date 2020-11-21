/*
Name:       Anders Gilliland
Project:    GS05-02 Hangman
Purpose:    Write a game of hangman using arrays. Allow the user to guess letters and represent
                which letters have been guessed in an array.
 */

import java.util.*;

public class hangman {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);
        char[] guessedArr = new char[26];
        int triesLeft = 6;
        int guesses = 0;
        boolean hasWon = false;

        //Game Setup
        System.out.print("Input a word or phrase to be guessed without punctuation...    ");
        String ans = console.nextLine();
        boolean[] boolArr = new boolean[ans.length()];
        System.out.print("\n\n\n\n\n\n\n\n\n\n"); //Spacing to prevent giving away the answer
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n\n\n\n\n\n\n\n\n");

        //While the game hasn't been won yet, begin the turn
        while (!hasWon) {
            //Allow the user to guess a letter, adding it to the guessed letter array
            System.out.print("Guess a letter... ");
            char guess = console.next().charAt(0);
            guessedArr[guesses] = Character.toUpperCase(guess);
            guesses++;

            //Set up a counting variable, a check if the guess is right/used, and preemptively
            //declare that the game is won so that if no problems are found the game is won
            int j = 0;
            boolean isUsed = false;
            hasWon = true;

            //For each character in the answer...
            for (boolean b : boolArr) {
                if (boolArr[j]) {
                    //Character has already been revealed
                    System.out.print(ans.charAt(j));
                } else if (Character.toLowerCase(ans.charAt(j)) == Character.toLowerCase(guess)) {
                    //Character is used, print it out, and mark it as used
                    System.out.print(ans.charAt(j));
                    boolArr[j] = true;
                    isUsed = true;
                } else if (ans.charAt(j) == ' ') {
                    //Character is a space
                    System.out.print(" ");
                } else {
                    //Character is not the guess, and the game is not finished
                    System.out.print("_");
                    hasWon = false;
                }
                j++;
            }
            System.out.print("\n\n");

            //If the user didn't reveal any new characters, take away a life
            if (!isUsed) {
                triesLeft--;
            }

            //Display the current state of the game and all guessed characters
            hangmanDisplay(triesLeft);
            System.out.print("\nGuessed characters: ");
            int i = 0;
            while (true) {
                if (guessedArr[i] != '\u0000') {
                    System.out.print(guessedArr[i] + " ");
                } else {
                    break;
                }
                i++;
            }
            System.out.print("\n\n\n");

            //Check if the game has been won or if the user is out of guesses
            if (hasWon) {
                System.out.println("\n\nCongratulations, you've won! The phrase was:\n" + ans);
                break;
            } else if (triesLeft == 0) {
                System.out.println("\n\nYou ran out of guesses! The correct phrase was:\n" + ans);
                break;
            }
        }
    }

    public static void hangmanDisplay (int guessLeft) {
        System.out.println("   /----\\");
        if (guessLeft == 6) {
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
        } else if (guessLeft == 5) {
            System.out.println("   |    O");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
        } else if (guessLeft == 4) {
            System.out.println("   |    O");
            System.out.println("   |    |");
            System.out.println("   |    |");
            System.out.println("   |");
        } else if (guessLeft == 3) {
            System.out.println("   |    O");
            System.out.println("   |   /|");
            System.out.println("   |    |");
            System.out.println("   |");
        } else if (guessLeft == 2) {
            System.out.println("   |    O");
            System.out.println("   |   /|\\");
            System.out.println("   |    |");
            System.out.println("   |");
        } else if (guessLeft == 1) {
            System.out.println("   |    O");
            System.out.println("   |   /|\\");
            System.out.println("   |    |");
            System.out.println("   |   /");
        } else {
            System.out.println("   |    O");
            System.out.println("   |   /|\\");
            System.out.println("   |    |");
            System.out.println("   |   / \\");
        }
        System.out.println("   |");
        System.out.println("__/|\\__");
    }
}