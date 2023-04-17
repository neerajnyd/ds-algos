package com.ny.leetcode.curated.binary;

/*
https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {

    public static int reverseBits(int num) {
        if (num == 0) return 0;
        int result = 0;
        /*
        shift result left, so we iteratively shift digits to left
        check if last digit of num is 1 (n & 1), add to result (which would get shifted in next iteration)
        update n by shifting right (drop last digit basically)
         */

        for (int i = 0; i < 32; i++) {

            result <<= 1; //so result gets the least significant digit shifted, incrementally reversing the number
            result += num & 1;
            num = num >>> 1;

        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(reverseBits(7));
    }
}
