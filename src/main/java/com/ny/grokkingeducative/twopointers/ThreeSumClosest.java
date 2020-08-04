package com.ny.grokkingeducative.twopointers;

import java.util.Arrays;

/*
https://leetcode.com/problems/3sum/
 */
public class ThreeSumClosest {
    public static void main(String[] args) {

        System.out.println(threeSumClosest(
                new int[]{-1, 2, 1, -4}, 1
        ));

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = target;
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int find = target - num;

            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int x = nums[lo];
                int y = nums[hi];

            }


        }
        return closest;
    }

    public int threeSumClosest_Official(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE, n = nums.length;
        Arrays.sort(nums);
        //if minDiff==0 then we have a triplet with sum==target which is the closest possible
        for (int i = 0; i < n && minDiff != 0; ++i) {
            int num = nums[i]; //first of the triplet
            int lo = i + 1, hi = n - 1; //for binary search
            while (lo < hi) {
                int sum = num + nums[lo] + nums[hi];
                //can't use Math.min here
                if (Math.abs(target - sum) < Math.abs(minDiff)) {
                    minDiff = target - sum;
                }
                if (sum < target) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return target - minDiff;
    }
}
