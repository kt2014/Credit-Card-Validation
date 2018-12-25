# Credit-Card-Validation
A simple program to test if a credit card number is valid.

To be a valid credit card it must be:

1) Between 13 and 16 characters.
2) Start with:
  4 for Visa cards
  5 for Master cards
  37 for AMEX cards
  6 for Discover cards
  
Double every second digit from right to left. If doubling of a digit results in a
two-digit number, add up the two digits to get a single-digit number (like for 12:1+2, 18=1+8).

Now add all single-digit numbers.

Add all digits in the odd places from right to left in the card number.

Sum the results from even placed and odd placed number results.

If the result is divisible by 10, the card number is valid; otherwise, it is invalid.
