package com.ny.leetcode.may2020;

public class Day15_CircularSubarraySum {

    public static void main(String[] args) {
        System.out.println(
                maxSubarraySumCircular(
                        new int[]{
                                5, -3, 5
                        }
                )
        );
    }

    public static int maxSubarraySumCircular(int[] A) {
        int total = 0, max = A[0], curMax = 0, min = A[0], curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + a, a);
            min = Math.min(min, curMin);
            total += a;
        }
        if (max < 0) { //if negative return the max subarray sum
            return max;
        } else { //else return max of max sum and total sum - min subarray sum
            return Math.max(max, total - min);
        }
    }
}
