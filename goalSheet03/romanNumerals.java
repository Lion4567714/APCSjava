/*
Name:       Anders Gilliland
Project:    GS03-03 Roman Numerals
Purpose:    Get a number from the user and output it as a roman numeral
 */

import java.util.*;

public class romanNumerals {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number to be converted into Roman numerals (then press [enter]):");
        int input = scanner.nextInt();

        System.out.println("" + numeralConversion(input));
    }

    public static String numeralConversion (int input) {
        int remainder = input;
        String output = "";

        //M - 1000
        if (remainder >= 1000) {
            output += repeatedNumerals('M', remainder / 1000);
            remainder = remainder - (remainder / 1000) * 1000;  //Remove all thousands from the remainder
        }
        if (remainder >= 900) {
            output += "CM";
            remainder -= 900;
        }

        //D - 500
        if (remainder >= 500) {
            output += "D";
            remainder -= 500;
        }
        if (remainder >= 400) {
            output += "CD";
            remainder -= 400;
        }

        //C - 100
        if (remainder >= 100) {
            output += repeatedNumerals('C', remainder / 100);
            remainder = remainder - (remainder / 100) * 100;
        }
        if (remainder >= 90) {
            output += "XC";
            remainder -= 90;
        }

        //L - 50
        if (remainder >= 50) {
            output += "L";
            remainder -= 50;
        }
        if (remainder >= 40) {
            output += "XL";
            remainder -= 40;
        }

        //X - 10
        if (remainder >= 10) {
            output += repeatedNumerals('X', remainder / 10);
            remainder = remainder - (remainder / 10) * 10;
        }
        if (remainder == 9) {
            output += "IX";
            remainder -= 9;
        }

        //V - 5
        if (remainder >= 5) {
            output += "V";
            remainder -= 5;
        }
        if (remainder == 4) {
            output += "IV";
            remainder -= 4;
        }

        //I - 1
        if (remainder >= 1)
            output += repeatedNumerals('I', remainder);

        return output;
    }

    public static String repeatedNumerals (char numeral, int repetitions) { //New method so the loop doesn't have to be retyped
        String output = "";
        for (int i = 0; i < repetitions; i++)
            output += numeral;
        return output;
    }
}