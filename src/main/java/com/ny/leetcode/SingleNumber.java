package com.ny.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1};

        System.out.println(singleNumber(nums));

    }

    private static int singleNumber1(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            map.compute(i, (key, value) -> value == null ? 1 : value + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;

    }

    static int singleNumber(int[] nums) {
        int R = 0;
        for (int num : nums) {
            R ^= num;
        }
        return R;
    }


}
