package com.ny.leetcode.contest341;

import java.util.HashMap;
import java.util.Map;

public class MaximumDivisibilityScore {


    /**
     * The divisibility score of divisors[i] is the number of indices j such that nums[j] is divisible by divisors[i].
     *
     * @param nums     0-indexed integer array
     * @param divisors 0-indexed integer array
     * @return the integer divisors[i] with the maximum divisibility score. If there is more than one integer with the maximum score,
     * return the minimum of them.
     */
    public int maxDivScore(int[] nums, int[] divisors) {

        int[] counts = new int[divisors.length];
        int maxCount = 0;
        int minDivisor = 0;
        int minDivisor2 = divisors[0];
        for (int i = 0; i < divisors.length; i++) {
            int div = divisors[i];
            for (int num : nums) {
                if (num % div == 0) {
                    counts[i]++;
                    if(counts[i] == maxCount) {
                        minDivisor = Math.min(minDivisor, div);
                    } else if(counts[i] > maxCount) {
                        maxCount = counts[i];
                        minDivisor = div;
                    }
                }
            }
            minDivisor2 = Math.min(minDivisor2, div);
        }

        return minDivisor != 0 ? minDivisor : minDivisor2;

    }


}
