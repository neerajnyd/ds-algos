package com.ny.leetcode;

public class MaximumSubarray {

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int maxSumAtLastPos = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currSum = Math.max(nums[i], nums[i] + maxSumAtLastPos);
            maxSumAtLastPos = currSum;
            globalMax = Math.max(globalMax, currSum);
        }
        return globalMax;

    }

}
