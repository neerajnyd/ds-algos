package com.ny.leetcode.curatedlistchallenge.day4;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        /*
        for linear space
            we need to know the expected value and then subtract the actual value from it
        */
        /*
        9,6,4,2,3,5,7,0,1
        actualValue = 37
        expectedValue = cumulativeSum from 0 (1 really) to 9 = 1+2+3+4+5+6+7+8+9 = 45
        result = eV - aV = 2
        */
        return (nums.length * nums.length-1)/2 - Arrays.stream(nums).sum();
    }
}
