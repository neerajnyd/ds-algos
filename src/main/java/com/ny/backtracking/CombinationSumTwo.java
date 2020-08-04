package com.ny.backtracking;

import java.util.*;

/*
https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumTwo {

    public static void main(String[] args) {
        System.out.println(combinationSum2(
                new int[]{2,5,2,1,2}, 8
        ));
    }

    /*
     constraints: candidates not guaranteed to be unique,
                candidates can be used ONLY ONCE in a combination to reach target
                order change does not change the combination i.e. 2,2,3 is same as 2,3,2
      */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remainingSum, int pos) {
        if(remainingSum < 0) return;
        if(remainingSum == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if(i > pos && candidates[i] == candidates[i-1]) continue;//ignore duplicate numbers
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remainingSum-candidates[i], i+1);
            tempList.remove(tempList.size()-1);

        }
    }
}
