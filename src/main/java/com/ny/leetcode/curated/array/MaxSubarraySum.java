package com.ny.leetcode.curated.array;

import static java.lang.Math.max;

public class MaxSubarraySum {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(
                maxSubArray(nums)
        );
    }

    private static int maxSubArray(int[] A) {
        int max = A[0];
        int sum = A[0];

        for (int i = 1; i < A.length; i++) {
            sum = max(sum + A[i], A[i]);
            max = max(max, sum);
        }
        return max;
    }

}
