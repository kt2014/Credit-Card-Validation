package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the card number validator.\n\n");
        System.out.print("Please enter a card number to check if it is valid (omit spaces): ");
        long number = input.nextLong();

        System.out.println(number + " is " +
                (isValid(number) ? "a valid card number." : "an invalid card number."));
    }

    // Return true if the card number is valid. The number must have
    // between 13 and 16 digits and must start with 1) 4 for Visa,
    // 5 for Master cards, 37 for AMEX, 6 for Discover. The result must
    // be divisible by 10 for the card number to be valid.

    public static boolean isValid(long number)
    {
        return (getSize(number) >= 13 &&
                getSize(number) <= 16) &&
                (prefixMatched(number, 4) ||
                        prefixMatched(number, 5) ||
                        prefixMatched(number, 37) ||
                        prefixMatched(number, 6)) &&
                ((sumOfDoubleEvenPlace(number) +
                        sumOfOddPlace(number)) % 10 == 0);
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

    // Return true if the digit d is a prefix for number
    public static boolean prefixMatched(long number, int d)
    {
        return getPrefix(number, getSize(d)) == d;
    }

    // Return the first k number of digits
    public static long getPrefix(long number, int k)
    {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }

    // A method to return the numbers of digits
    public static int getSize(long digit)
    {
        String num = digit + "";
        return num.length();
    }
}
