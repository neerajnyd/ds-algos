package com.ny.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3};

        System.out.println(majorityElement(nums));
    }


    public static int majorityElement(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(Integer num : nums) {
            Integer x = frequencyMap.compute(num, (key, value) -> value == null ? 1 : value + 1);
            if(x > n/2) return num;
        }
        return -1;
    }
}
