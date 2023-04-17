package com.ny.leetcode.curated.binary;

/*
https://leetcode.com/problems/sum-of-two-integers/
 */
public class NumberOfOneBits {

    private static int hammingWeight(int num) {

        int count = 0;

        while (num != 0) {
            /* AND with 1 -> '0000 0000 0000 0000 0000 0000 0000 0001'
                if 1 then count increases
             */
            int oneOrZero = num & 1;
            count += oneOrZero;
            //shift the number right
            num = num >>> 1;
        }
        return count;

    }

    public static void main(String[] args) {
        int n = 521;
        System.out.println(hammingWeight(n));
    }
}
