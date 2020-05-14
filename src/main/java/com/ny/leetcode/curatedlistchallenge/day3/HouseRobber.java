package com.ny.leetcode.curatedlistchallenge.day2;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));
    }

    public static int rob(int[] nums) {

        if(nums == null) return 0;
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 3) return Math.max(nums[1], nums[0] + nums[2]);

        int[] sums = new int[n];
        sums[0] = nums[0];
        sums[1] = nums[1];
        sums[2] = nums[0] + nums[2];
        for(int i=3; i<n; i++) {
            sums[i] = nums[i] + Math.max(sums[i-2], sums[i-3]);
        }
        return Math.max(sums[n-1], sums[n-2]);
    }

}
