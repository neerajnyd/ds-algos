package com.ny.leetcode.curatedlistchallenge.day7;

/*
https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        if (nums.length == 1) return nums[0];

        int maxAtPos = nums[0];
        int gMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxAtPos = Math.max(nums[i], nums[i] + maxAtPos);
            gMax = Math.max(gMax, maxAtPos);
        }
        return gMax;
    }

    public static void main(String[] args) {
        System.out.println(
                maxSubArray(
                        new int[] {
                                -2,1,-3,4,-1,2,1,-5,4
                        }
                )
        );
    }
}
