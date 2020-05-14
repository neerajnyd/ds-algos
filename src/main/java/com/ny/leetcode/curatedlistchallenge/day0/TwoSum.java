package com.ny.leetcode.curatedlistchallenge.day0;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(num, i);
            }
        }
        return new int[]{-1,-1};
    }

}
