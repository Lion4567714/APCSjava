/*
Name:       Anders Gilliland
Project:    GS05-03 Mastermind
Purpose:    White a program that plays a variation of the game Mastermind with the user. The program
                should generate a four-digit number. The user is allowed to guess until they get
                the number correct. Clues are given to the user indicating how many digits are
                correct and in the correct place.
            Also should accept test cases for extra testing.
 */

import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class mastermind {
    public static void main (String[] args)
            throws Exception {
        Scanner scanner = new Scanner(System.in);
        int menuOption = -1;

        while (menuOption != 0) {
            System.out.print("Do you want to (1) play, (2) test, or (3) exit Mastermind?    ");
            menuOption = scanner.nextInt();
            switch (menuOption) {
                case 0:
                    break;
                case 1:
                    playGame();
                    break;
                case 2:
                    testCase();
                    break;
                default:
                    System.out.println("That is not a valid input. Please try again.");
                    break;
            }
        }
        System.out.print("\n\n");
    }

    public static void playGame () {
        Scanner scanner = new Scanner(System.in);
        int guessesLeft = 10;
        int iteration = 0;
        boolean[] isUsedS = new boolean[4];
        boolean[] isUsedG = new boolean[4];
        int[] CDAL = new int[10];
        int[] CDWL = new int[10];
        boolean isFinished = false;

        //Generate a random, 4-digit number (with 1-6s) for the user to guess
        Random random = new Random();
        int[] secretArr = new int[4];
        /*for (int i : answer) {
            answer[i] = random.nextInt(6) + 1;
        }*/
        for (int i = 0; i < 4; i++) {
            secretArr[i] = random.nextInt(6) + 1;
        }

        String[] guess = new String[10];
        int[][] guessArr = new int[10][4];

        //While the user still has guesses left and hasn't won
        while (!isFinished && guessesLeft > 0) {
            //Receive a guess from the user
            System.out.print("\nGuess a 4-digit number, with digits between 1 and 6:    ");
            guess[iteration] = scanner.next();

            //Covert the guess string into an integer array for easier comparison later and
            //reset boolean arrays
            for (int i = 0; i < 4; i++) {
                guessArr[iteration][i] = Integer.parseInt(
                        String.valueOf(guess[iteration].charAt(i)));
                isUsedS[i] = false;
                isUsedG[i] = false;
            }

            //For each integer in the guess, compare it to all four answer integers for grading.
            //If any of the numbers match up and count as with an CDAL or CDWL, lock off that number
            //from being counted again with the boolean array, and continue.
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (guessArr[iteration][i] == secretArr[j] && !isUsedS[j] && !isUsedG[i] && i == j) {
                        CDAL[iteration]++;
                        isUsedS[j] = true;
                        isUsedG[i] = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (guessArr[iteration][i] == secretArr[j] && !isUsedS[j] && !isUsedG[i]) {
                        CDWL[iteration]++;
                        isUsedS[j] = true;
                        isUsedG[i] = true;
                        break;
                    }
                }
            }

            //Check if the user guessed correctly. If so, they win. If not, tell the user their
            //score so they can guess again.
            if (CDAL[iteration] == 4) {
                System.out.println("Congratulations! The answer was " + guess[iteration] + "!\n");
                break;
            } else {
                guessesLeft--;

                //Display this round's results
                System.out.println("\nYou have " + guessesLeft + " guesses left");
                System.out.println("Correct Digit and Location:       " + CDAL[iteration]);
                System.out.println("Correct Digit but Wrong Location: " + CDWL[iteration]);

                //Display each round's results
                int j = 0;
                System.out.println("\nX: Guess | R W");
                for (int i = iteration + 1; i > 0; i--) {
                    System.out.println(j + 1 + ": " + guess[j] + "  | " + CDAL[j] + " " + CDWL[j]);
                    j++;
                }

                iteration++;
            }
        }
    }

    public static void testCase ()
            throws Exception {
        File file = new File("C:\\Users\\Anders Gilliland\\Documents\\School Stuff\\" +
                "12th Grade\\AP Computer Science\\Projects\\GoalSheet05\\src\\mastermind_4x6.txt");
        Scanner scanner = new Scanner(file);
        scanner.nextLine(); //To skip over introductory example at the top
        scanner.useDelimiter(",|\\n");

        String secret, guess;
        int CDAL, CDWL;  //CDAL = Correct Digit And Location, CDWL = Wrong Location
        int aCDAL, aCDWL;   //Extra set for preserving the test case, not for counting
        int line = 0;
        int[] secretArr = new int[4];
        int[] guessArr = new int[4];
        boolean[] isUsedS = new boolean[4];
        boolean[] isUsedG = new boolean[4];
        long start, end;

        //Find the start time
        start = System.nanoTime();

        //Run through and grade each test case
        while (scanner.hasNext()) {
            secret = scanner.next();
            guess = scanner.next();
            aCDAL = scanner.nextInt();
            aCDWL = scanner.nextInt();
            CDAL = 0;
            CDWL = 0;
            line++;

            //Take the secret and guess numbers and put them into an array of integers for easier
            //grading. Also reset the boolean array for next round of grading.
            for (int i = 0; i < 4; i++) {
                secretArr[i] = Integer.parseInt(String.valueOf(secret.charAt(i)));
                guessArr[i] = Integer.parseInt(String.valueOf(guess.charAt(i)));
                isUsedS[i] = false;
                isUsedG[i] = false;
            }

            //For each integer in the guess, compare it to all four answer integers for grading.
            //If any of the numbers match up and count as with an CDAL or CDWL, lock off that number
            //from being counted again with the boolean array, and continue.
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (guessArr[i] == secretArr[j] && !isUsedS[j] && !isUsedG[i] && i == j) {
                        CDAL++;
                        isUsedS[j] = true;
                        isUsedG[i] = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (guessArr[i] == secretArr[j] && !isUsedS[j] && !isUsedG[i]) {
                        CDWL++;
                        isUsedS[j] = true;
                        isUsedG[i] = true;
                        break;
                    }
                }
            }

            //Check if the scoring was correct. If not, end the program with error message.
            if (CDAL != aCDAL || CDWL != aCDWL) {
                System.out.println("An error occurred with the scoring function at line " + line);
                System.out.println("Test Case - Secret: " + secret + "   Guess: " + guess);
                System.out.println("Graded Answer  - CDAL: " + CDAL + "   CDWL: " + CDWL);
                System.out.println("Correct Answer - CDAL: " + aCDAL + "   CDWL: " + aCDWL);
                break;
            }
        }

        //Find the end time
        end = System.nanoTime();

        //Once the testing is done, display the time it took overall and for each test case (avg)
        double totalMS = (end - start) / 1_000_000.0;
        double iterNS = (end - start) / (double) line;
        System.out.printf("\nLines graded: %,d   Elapsed time: %,.2fms   Time per case: %,.4fns\n\n"
                , line, totalMS, iterNS);
    }
}
