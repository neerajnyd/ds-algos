package com.ny.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumbers {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    private static int squareSumOfDigit(int n) {
        int sum = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            sum += lastDigit * lastDigit;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        int fast = n, slow = n;
        do {
            slow = squareSumOfDigit(slow);
            fast = squareSumOfDigit(fast);
            fast = squareSumOfDigit(fast);
            if (fast == 1) return true;
        } while (fast != slow);
        return false;
    }

    public boolean isHappy2(int n) {
        Set<Integer> encountered = new HashSet<>();
        while (!encountered.contains(n)) {
            encountered.add(n);
            n = squareSumOfDigit(n);
        }
        return (n==1);
    }

}
