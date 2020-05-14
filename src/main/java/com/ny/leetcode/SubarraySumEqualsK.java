package com.ny.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] A = {3,4,7,2,-3,1,4,2};

        System.out.println(subarraySum(A, 7));

    }

    public static int subarraySum(int[] nums, int target) {
        int sum = 0, count = 0;
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - target, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0));
        }
        return count;
    }

}
