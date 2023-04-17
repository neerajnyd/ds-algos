package com.ny.leetcode.april2023;

public class MinimizeMaxInArray {

    public int minimizeArrayValue(int[] nums) {

        long prefixSum = 0, max = 0;
        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];

            long ceil = (prefixSum + i) / (i + 1); //integer division for -> ceil(double(sum) / (i + 1))
            max = Math.max(max, ceil);
            /*
            ceil(a / b) can be written as (a + b - 1) / b
            Here, a = prefixSum and b = i + 1. Why i + 1? Because 0 index array
             */
        }
        return (int) max;
    }

}
