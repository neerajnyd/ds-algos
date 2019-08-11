package com.ny.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        final int[] nums = {1, 2, 3};
        final List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> R = new ArrayList<>();
        backtrack(R, new ArrayList<>(), nums);
        return R;
    }

    private static void backtrack(List<List<Integer>> r, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            r.add(new ArrayList<>(temp));
            return;
        }
        for (Integer i : nums) {
            if (temp.contains(i)) {
                continue;
            }
            temp.add(i);
            backtrack(r, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
