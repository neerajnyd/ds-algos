package com.ny.test;

public class ComputeAllPrimes {

    private static int sieveOfEratosthenes2(int n) {
        int size = 15_485_864;
        boolean[] prime = new boolean[size+1];
        for (int i = 0; i < size; i++) {
            prime[i] = true;
        }
        int count = 0;
        for (int i = 2; i * i <= size; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= size; j += i) {
                    prime[j] = false;
                }
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= size; i++) {
            if (prime[i]) {
                count++;
                if(count == n) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException("Ran out of space");
    }

    private static long computeNthPrime(long n) {

        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 3;
        }

        long count = 2; //2 and 3

        for (long i = 5; ; i += 2) {
            boolean prime = true;
            for (long j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.println(i);
                count++;
                if (count == n) {
                    return i;
                }
            }

        }

    }

    public static void main(String[] args) {
        int nth = 1_000_000;
        System.out.printf("%dth prime number is %d", nth, sieveOfEratosthenes2(nth));
//        sieveOfEratosthenes(1_00);
    }

    private static void sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) /* If prime[i] is not changed, then it is a prime */ {
            if (prime[i]) /* Update all multiples of i */ {
                for (int j = i * 2; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                System.out.println(i);
            }
        }
    }


}
