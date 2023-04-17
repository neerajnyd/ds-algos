package com.ny.leetcode.lc75;

public class FindPivotIndex {

    public static void main(String[] args) {

        int[] nums = {-1, -1, -1, -1, -1, 0};
        System.out.println(pivotIndex(nums));

    }

    private static int pivotIndex(int[] nums) {

        int sum = 0;
        for (int n : nums) sum += n;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {

            int rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) return i;

            leftSum += nums[i];

        }
        return -1;
    }

}
