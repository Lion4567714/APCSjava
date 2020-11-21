/*
Name:       Anders Gilliland
Project:    GS05-01 OutputSquares
Purpose:    Use a two-dimensional array to write a game of Tic-Tac-Toe that represents the board
 */

import java.util.*;

public class outputSquares {
    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);
        char[][] board = boardMaker(new char[3][3]);
        int x, y;
        int hasWon = 0;
        boolean xTurn = true;    //true = 'X's turn, false = 'O's turn
        boolean valid;

        while (hasWon == 0) {
            System.out.println("Tic-Tac-Toe");
            if (xTurn) {
                System.out.println("It is Xs Turn");
            } else {
                System.out.println("It is Os Turn");
            }

            valid = false;
            while (!valid) {
                System.out.println("Enter the coordinates for your move (i.e. middle is 2, 2) each followed by enter:");
                x = console.nextInt() - 1;
                y = console.nextInt() - 1;

                if (x < 0 || x > 2 || y < 0 || y > 2) {
                    System.out.println("That is not a valid position, please try again.");
                    valid = false;
                } else if (board[x][y] == ' ') {
                    valid = true;
                    if (xTurn) {
                        board[x][y] = 'X';
                        xTurn = false;
                    } else {
                        board[x][y] = 'O';
                        xTurn = true;
                    }
                } else {
                    System.out.println("That square is already taken, please try again.");
                    valid = false;
                }
            }

            boardDisplay(board);
            hasWon = boardCheck(board);
        }

        if (hasWon == 1) {
            System.out.println("You Won, Congratulation Xs!");
        } else if (hasWon == 2) {
            System.out.println("You Won, Congratulations Os!");
        } else {
            System.out.println("It's a Draw!");
        }
    }

    public static char[][] boardMaker (char[][] input) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                input[i][j] = ' ';
            }
        }
        return input;
    }

    public static void boardDisplay (char[][] input) {
        System.out.println("\n " + input[0][0] + " | " + input[1][0] + " | " + input[2][0]);
        System.out.println("---+---+---");
        System.out.println(" " + input[0][1] + " | " + input[1][1] + " | " + input[2][1]);
        System.out.println("---+---+---");
        System.out.println(" " + input[0][2] + " | " + input[1][2] + " | " + input[2][2] + "\n");
    }

    //How to make a messy and inefficient method 101
    public static int boardCheck (char[][] input) {
        if (input[0][0] != ' ' && input[0][0] == input[1][0] && input[1][0] == input [2][0]) {
            //3 across top
            if (input[0][0] == 'X') {
                return 1;
            } else {
                return 2;
            }
        } else if (input[0][1] != ' ' && input[0][1] == input[1][1] && input[1][1] == input[2][1]) {
            //3 across middle
            if (input[0][1] == 'X') {
                return 1;
            } else {
                return 2;
            }
        } else if (input[0][2] != ' ' && input[0][2] == input[1][2] && input[1][2] == input[2][2]) {
            //3 across bottom
            if (input[0][2] == 'X') {
                return 1;
            } else {
                return 2;
            }
        } else if (input[0][0] != ' ' && input[0][0] == input[0][1] && input[0][1] == input[0][2]) {
            //3 down left
            if (input[0][0] == 'X') {
                return 1;
            } else {
                return 2;
            }
        } else if (input[1][0] != ' ' && input[1][0] == input[1][1] && input[1][1] == input[1][2]) {
            //3 down middle
            if (input[1][0] == 'X') {
                return 1;
            } else {
                return 2;
            }
        } else if (input[2][0] != ' ' && input[2][0] == input[2][1] && input[2][1] == input[2][2]) {
            //3 down right
            if (input[2][0] == 'X') {
                return 1;
            } else {
                return 2;
            }
        } else if (input[0][0] != ' ' && input[0][0] == input[1][1] && input[1][1] == input[2][2]) {
            //3 diagonal from top left
            if (input[0][0] == 'X') {
                return 1;
            } else {
                return 2;
            }
        } else if (input[0][2] != ' ' && input[0][2] == input[1][1] && input[1][1] == input[2][0]) {
            //3 diagonal from bottom left
            if (input[0][2] == 'X') {
                return 1;
            } else {
                return 2;
            }
        }

        if (input[0][0] != ' ' && input[0][1] != ' ' && input[0][2] != ' ' &&
                input[1][0] != ' ' && input[1][1] != ' ' && input[1][2] != ' ' &&
                input[2][0] != ' ' && input[2][1] != ' ' && input[2][2] != ' ') {
            //All squares a filled
            return 3;
        } else {
            //Game is not finished
            return 0;
        }
    }
}
