package com.ny.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandidateSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, nums, target, new ArrayList<>(), 0);
        return list;
    }

    private void backtrack(List<List<Integer>> R, int[] C, int target, List<Integer> tempList, int start){
        if(target < 0) return;
        else if(target == 0) {
            R.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i < C.length; i++){
            tempList.add(C[i]);
            backtrack(R, C, target - C[i], tempList, i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}
