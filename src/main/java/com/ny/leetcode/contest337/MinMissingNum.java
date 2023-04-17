package com.ny.leetcode.contest337;

import java.util.Arrays;

public class MinMissingNum {

    public static void main(String[] args) {

        MinMissingNum num = new MinMissingNum();
        System.out.println(num.findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5));

    }

    public int findSmallestInteger(int[] nums, int value) {

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int abs = Math.abs(num);
            int times = abs / value;
            if (times > 0) {
                if (num > 0) {
                    int num2 = num - value * times;
                    nums[i] = num2;
                } else if (num < 0) {
                    int num2 = num + value * (times + 1);
                    int num3 = num + value * (times);
                    if (num3 < 0) {
                        nums[i] = num2;
                    } else {
                        nums[i] = num3;
                    }
                }
            }
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int i = 0;
        for (int n : nums) {
            if (n != i) return i;
            i++;
        }
        return -1;
    }
}