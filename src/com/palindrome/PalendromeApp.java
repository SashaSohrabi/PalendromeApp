package com.palindrome;

import java.util.stream.LongStream;

public class PalendromeApp {

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
        return number > 2
                && LongStream.rangeClosed(2, (long) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }

    public static void main(String[] args) {

        long prime1, prime2;
        long maxPalindrome = 0;
        long multiplier1 = 0;
        long multiplier2 = 0;

        for (prime1 = 10000; prime1 <= 99999; prime1++) {
            for (prime2 = 10000; prime2 <= 99999; prime2++) {

                if (isPrime(prime2) && isPrime(prime1)) {
                    long palindromeCandidate = prime1 * prime2;

                    if (isPalindrome(palindromeCandidate) && palindromeCandidate > maxPalindrome) {
                        maxPalindrome = palindromeCandidate;
                        multiplier1 = prime1;
                        multiplier2 = prime2;

                    }

                }
            }

        }

        System.out.println("the largest palindrome product of two simple five-digit numbers is: "
                + maxPalindrome);
        System.out.println("prime-multiplier1: " + multiplier1);
        System.out.println("prime-multiplier2: " + multiplier2);
    }
}
