package com.ny.leetcode.curatedlistchallenge.day6;

/*
https://leetcode.com/problems/sum-of-two-integers/
 */
public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {

        if(a==0) return b;
        if(b==0) return a;

        while(b!=0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(7, 5));
        System.out.println(getSum(-2, 3));
    }
}
