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

    private static void printResults(long multiplier1, long multiplier2, long maxPalindrome) {
        System.out.println("the largest palindrome product of two prime five-digit numbers is: "
                + maxPalindrome);
        System.out.println("prime-multiplier1: " + multiplier1);
        System.out.println("prime-multiplier2: " + multiplier2);
    }

    public static void main(String[] args) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 10000; i <= 99999; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        long maxPalindrome = 0;
        long multiplier1 = 0;
        long multiplier2 = 0;

        for (int i = 0; i < primeNumbers.size(); i++) {
            for (int j = 0; j < primeNumbers.size(); j++) {
                long prime1 = primeNumbers.get(i);
                long prime2 = primeNumbers.get(j);

                long palindromeCandidate = prime1 * prime2;

                if (isPalindrome(palindromeCandidate) && palindromeCandidate > maxPalindrome) {
                    maxPalindrome = palindromeCandidate;
                    multiplier1 = prime1;
                    multiplier2 = prime2;

                }
            }
        }
        printResults(multiplier1, multiplier2, maxPalindrome);
    }
}
