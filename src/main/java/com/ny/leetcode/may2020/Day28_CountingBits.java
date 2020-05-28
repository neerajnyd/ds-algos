package com.ny.leetcode.may2020;

public class Day28_CountingBits {

    public int[] countBits(int num) {
        if (num < 0)
            return new int[1];

        // allocate array incuding 0->num
        int[] countBitArray = new int[num + 1];

        // initial DP data
        countBitArray[0] = 0;

        for (int i = 1; i <= num; i++) {
            // if num is even, bit count is same as num / 2
            // if odd, bit count is same as (num / 2) + 1
            countBitArray[i] = countBitArray[i >> 1] + i % 2;
        }

        return countBitArray;

    }

    public int[] countBits2(int n) {

        int[] c = new int[n + 1];

        for (int i = 0; i <= n; i++) {

            int num = i;

            while (num != 0) {
                int x = num & 1;
                c[i] += x;
                num >>>= 1;
            }

        }
        return c;

    }
}
