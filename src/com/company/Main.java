package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    // Get the sum of every second digit from right the left, if it
    // results in a two-digit number, add up the to digits
    public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);

        return sum;
    }

    // Return the sum of digits in odd position in number from right to left
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }

    // Return this number if it is a single digit, otherwise,
    // return the sum of the two digits
    public static int getDigit(int number)
    {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }

    // A method to return the numbers of digits
    public static int getSize(long digit)
    {
        String num = digit + "";
        return num.length();
    }
}
