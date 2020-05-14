package com.ny.leetcode;

public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        if(nums.length==0) return -1;
        int rightSum = 0;
        for (int x : nums) rightSum += x;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
