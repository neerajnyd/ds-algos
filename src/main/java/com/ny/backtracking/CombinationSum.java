package com.ny.backtracking;

import java.util.*;

/*
https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public static void main(String[] args) {

        System.out.println(combinationSum(
                new int[]{2,3,6,7}, 7
        ));
    }

    /*
    constraints: unique candidates,
                candidates can be used multiple times in a combination to reach target
                order change does not change the combination i.e. 2,2,3 is same as 2,3,2
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;

    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remainingSum, int start) {
        if(remainingSum < 0) return;
        if(remainingSum == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remainingSum - candidates[i], i);
            tempList.remove(tempList.size()-1);
        }
    }
}
