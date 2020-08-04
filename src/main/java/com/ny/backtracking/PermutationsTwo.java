package com.ny.backtracking;

import java.util.*;

/*
https://leetcode.com/problems/permutations-ii/
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    Input: [1,1,2]
    Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
 */
public class PermutationsTwo {

    public static void main(String[] args) {
        System.out.println(permute(
                new int[]{1, 1, 2}
        ));
    }

    private static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(permutations, tempList, nums, used);
        return permutations;
    }

    private static void backtrack(List<List<Integer>> permutations, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            permutations.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //if num used already continue
            if (used[i]) continue;
            //we can use a number only if its duplicate was also used earlier
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(permutations, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }

    }

}
