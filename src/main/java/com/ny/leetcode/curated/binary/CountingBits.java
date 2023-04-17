package com.ny.leetcode.curated.binary;

public class CountingBits {

    public int[] countBits(int num) {

        /*
        for even numbers (ending with 0 and num & 1 == 0)
            countBits[even] = countBits[num >> 1]
            num:      101010101010
            num >> 1: 10101010101
        for odd numbers (num & 1 == 1)
            countBits[odd] = countBits[odd - 1] + 1
            num:     101010101011 <-- the odd no has 1 more one
            num - 1: 101010101010 <-- the even number has 1 less one
         */

        int[] count = new int[num + 1];
        count[0] = 0;

        for (int i = 1; i <= num; i++) {

            if ((i & 1) == 0) { //even
                count[i] = count[i >> 1];
            } else { //odd
                count[i] = count[i - 1] + 1;
            }
        }
        return count;
    }
}
