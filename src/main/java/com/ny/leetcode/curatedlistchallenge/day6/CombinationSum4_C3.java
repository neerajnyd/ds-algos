package com.ny.leetcode.curatedlistchallenge.day6;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSum4_C3 {

    public static int combinationSum4(int[] nums, int target) {
        int[] r = {0};
        helper(r, nums, target, 0, 0, 0);
        return r[0];
    }

    private static void helper(int[] R, int[] A, int target, int i, int j, int sum) {
        if(sum == target) {
            R[0]++;
            return;
        }
        if(sum > target) {
            return;
        }
        if(i == A.length) return; //all numbers have run their courses
        if(j == A.length) //current number has run its course
            helper(R, A, target, i+1, 0, 0);
        helper(R, A, target, i, i, sum+A[j]);
    }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int target = 4;

        System.out.println(combinationSum4(A, target));
    }
}
