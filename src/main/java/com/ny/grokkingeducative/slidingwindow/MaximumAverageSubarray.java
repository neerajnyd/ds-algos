package com.ny.grokkingeducative.slidingwindow;

/*
https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class MaximumAverageSubarray {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int l = 0, r = 0;
        int sum = 0;
        while(r < k) {
            sum += nums[r++];
        }
        int max = sum;
        while(r < nums.length) {

            sum -= nums[l];
            sum += nums[r];
            max = Math.max(max, sum);

            l++;
            r++;
        }
        return (double)max/k;
    }

}


