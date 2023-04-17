package com.ny.leetcode.curated.binary;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
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
        int n = nums.length;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        int expectedSum = n * (n + 1) / 2;
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {

        System.out.println(
                missingNumber(
                        new int[]{
                                3, 0, 1
                        }
                )
        );

    }
}
