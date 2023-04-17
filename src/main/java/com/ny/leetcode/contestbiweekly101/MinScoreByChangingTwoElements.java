package com.ny.leetcode.contestbiweekly101;

import java.util.Arrays;

public class MinScoreByChangingTwoElements {

    public static void main(String[] args) {

        int[] input1 = {58,42,8,75,28};

        System.out.println(minimizeSum(input1));

    }

    public static int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int last = nums[n - 1];
        int third = nums[2];
        int minTwoRemoved = last - third;

        int lastThird = nums[n - 3];
        int first = nums[0];
        int maxTwoRemoved = lastThird - first;

        int secondLast = nums[n - 2];
        int second = nums[1];
        int minAndMaxRemoved = secondLast - second;
        return getMin(minTwoRemoved, maxTwoRemoved, minAndMaxRemoved);

    }

    private static int getMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
