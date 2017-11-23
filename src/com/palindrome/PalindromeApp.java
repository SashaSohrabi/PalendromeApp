package com.palindrome;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class PalindromeApp {
    private static boolean isPalindrome(long original) {
        long reversed = 0;
        long n = original;

        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed == original;
    }

    private static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(number))
                .noneMatch(i -> (number % i == 0));
    }

    public static void main(String[] args) {
        long number, prime1, prime2;
        long maxPalindrome = 0;
        long multiplier1 = 0;
        long multiplier2 = 0;
        List<Long> primeNumbersList = new ArrayList<Long>();

        for (number = 10000; number <= 99999; number++) {
            if (isPrime(number)) {
                primeNumbersList.add(number);
            }
        }

        Long[] primeNumbers = primeNumbersList.toArray(new Long[primeNumbersList.size()]);

        for (int i = 0; i < primeNumbers.length; i++) {
            for (int j = 0; j < primeNumbers.length; j++) {
                prime1 = primeNumbers[i];
                prime2 = primeNumbers[j];

                long palindromeCandidate = prime1 * prime2;

                if (isPalindrome(palindromeCandidate) && palindromeCandidate > maxPalindrome) {
                    maxPalindrome = palindromeCandidate;
                    multiplier1 = prime1;
                    multiplier2 = prime2;

                }
            }
        }

        System.out.println("the largest palindrome product of two prime five-digit numbers is: "
                + maxPalindrome);
        System.out.println("prime-multiplier1: " + multiplier1);
        System.out.println("prime-multiplier2: " + multiplier2);
    }
}