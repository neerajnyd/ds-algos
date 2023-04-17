package com.ny.leetcode;

public class MaximumSubarray {

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int sum = nums[0];
        int maxSum = nums[0];

        for (int num : nums) {
            int currSum = Math.max(num, num + sum);
            sum = currSum;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;

    }

}
