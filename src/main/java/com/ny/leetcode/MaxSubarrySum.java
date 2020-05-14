package com.ny.leetcode;

public class MaxSubarrySum {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int absMax = Integer.MIN_VALUE;
        int maxPossibleSumAtPosition = nums[0];
        for(int i=1; i<nums.length; i++) {
            maxPossibleSumAtPosition = Math.max(maxPossibleSumAtPosition+nums[i], nums[i]);
            absMax = Math.max(absMax, maxPossibleSumAtPosition);
        }
        return absMax;
    }

}
