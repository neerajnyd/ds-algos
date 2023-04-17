package com.ny.leetcode.contest334;

import java.util.Arrays;

public class LeftRightSumDifferences {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(leftRigthDifference(new int[]{10, 4, 8, 3})));
        System.out.println(Arrays.toString(leftRigthDifference(new int[]{1})));

    }

    public static int[] leftRigthDifference(int[] nums) {

        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i < n; i++) {
            sum1 += nums[i - 1];
            leftSum[i] = sum1;
        }

        for (int i = n - 2; i >= 0; i--) {
            sum2 += nums[i + 1];
            rightSum[i] = sum2;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {

            result[i] = Math.abs(leftSum[i] - rightSum[i]);

        }
        return result;
    }

}
