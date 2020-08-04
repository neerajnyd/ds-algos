package com.ny.grokkingeducative.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {

        System.out.println(threeSum(
                new int[]{-1, 0, 1, 2, -1, -4, 0,1,0,1}
        ));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            /* the array is sorted, if the number is positive,
            no way there are elements up ahead that add to this number */
            if (num > 0) break;
            //we want unique triplets
            if (i > 0 && num == nums[i - 1]) continue;
            // we want to find two numbers x and y that sum to target to find the eligible triplet
            int target = -num;

            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int x = nums[lo];
                int y = nums[hi];
                int sum = x + y;
                if (sum == target) {
                    result.add(Arrays.asList(num, x, y));
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) lo++;//we want unique triplets
                    while (lo < hi && nums[hi] == nums[hi + 1]) hi++;//we want unique triplets
                } else if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }

        }
        return result;
    }
}
