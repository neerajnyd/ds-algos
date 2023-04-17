package com.ny.leetcode.contest334;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/contest/weekly-contest-334/problems/find-the-maximum-number-of-marked-indices/
 */
public class FindMaxNumberMarkedIndices {

    public static void main(String[] args) {
        System.out.println(maxNumOfMarkedIndices(new int[]{9, 2, 5, 4}));
    }

    public static int maxNumOfMarkedIndices(int[] nums) {

        Arrays.sort(nums);

        int j = 1;
        Set<Integer> marked = new HashSet<>();
        for (int i = 0; i < nums.length && j < nums.length; i++) {
            int a = nums[j];
            int b = nums[i];

            if(a * 2 <= b) {
                marked.add(i);
                marked.add(j);
            }
            j = i+2;

        }
        return marked.size();
    }

}
