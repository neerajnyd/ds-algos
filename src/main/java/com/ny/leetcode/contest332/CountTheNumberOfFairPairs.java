package com.ny.leetcode.contest332;

import java.util.Arrays;

public class CountTheNumberOfFairPairs {

    public static void main(String[] args) {
        int[] nums = {1,7,9,2,5};
        int lower = 11, upper = 11;
        System.out.println(countFairPairs(nums, lower, upper));

    }

    private static long countFairPairs(int[] nums, int lower, int upper) {
        int len = nums.length;
        long result = 0;
        if (len < 2) return result;

        Arrays.sort(nums);

        int p1 = 0, p2 = p1+1;

        while (p2 < len && nums[p1] < lower) {
            int sum = nums[p1] + nums[p2];

            if (sum < lower) {
                p2++;
            } else if (sum > upper) {
                p1++;
                p2 = p1+1;
            } else {
                result++;
                p2++;
            }
        }

        return result;

    }


}
