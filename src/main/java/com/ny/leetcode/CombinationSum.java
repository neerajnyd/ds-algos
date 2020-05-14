package com.ny.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));

    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> R = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(R, new ArrayList<>(), candidates, target, 0);
        return R;
    }

    private static void backtrack(List<List<Integer>> R, List<Integer> temp, int[] candidates, int target, int start) {
        if(target < 0) {
            return;
        } else if(target == 0) {
            R.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(R, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }

}
