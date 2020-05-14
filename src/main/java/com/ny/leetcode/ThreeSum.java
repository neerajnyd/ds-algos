package com.ny.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * The solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution(nums);
        System.out.println(result);
        /* [    [-1,-1,2] ,  [-1,0,1]]  */
    }

    private static List<List<Integer>> solution(int[] N) {
        Arrays.sort(N);

        final List<List<Integer>> R = new ArrayList<>();
        for (int i = 0; i < N.length - 2; i++) {
            if (i != 0 && N[i] == N[i - 1]) {
                continue;
            }
            int sum = 0 - N[i], lo = i + 1, hi = N.length - 1;
            while (lo < hi) {
                if (N[lo] + N[hi] > sum) {
                    hi--;
                } else if (N[lo] + N[hi] < sum) {
                    lo++;
                } else {
                    R.add(Arrays.asList(N[i], N[hi], N[lo]));
                    while (lo < hi && N[lo] == N[lo + 1]) lo++;
                    while (lo < hi && N[hi] == N[hi - 1]) hi--;
                    lo++;
                    hi--;
                }
            }
        }
        return R;

    }
}
