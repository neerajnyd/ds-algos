package com.ny.leetcode.curated.array;

public class MaxSubarrayProduct {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] A) {
        int max = A[0], min = A[0], result = A[0];

        for (int i = 1; i < A.length; i++) {
            int num = A[i];
            int c1 = max * num;
            int c2 = min * num;

            max = Math.max(Math.max(num, c1), c2);
            min = Math.min(Math.min(num, c1), c2);

            result = Math.max(result, max);
        }
        return result;

    }
}
