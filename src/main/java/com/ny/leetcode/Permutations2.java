package com.ny.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        final int[] nums = {1, 1, 2};
        final List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> R = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(R, new ArrayList<>(), nums, new boolean[nums.length]);
        return R;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(
                used[i] ||
                (
                    (i > 0) && (nums[i - 1] == nums[i]) && !used[i - 1]
                )
            ) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(list, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
