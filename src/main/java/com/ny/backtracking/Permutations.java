package com.ny.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/permutations/
    Given a collection of distinct integers, return all possible permutations.

 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println(permute(
                new int[]{1, 2, 3}
        ));
    }

    private static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(permutations, tempList, nums);
        return permutations;
    }

    private static void backtrack(List<List<Integer>> permutations, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            permutations.add(new ArrayList<>(tempList));
            return;
        }
        for (int num : nums) {
            if (tempList.contains(num)) continue; //we don't want duplicate elements in our permutation
            tempList.add(num);
            backtrack(permutations, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }

    }

}
