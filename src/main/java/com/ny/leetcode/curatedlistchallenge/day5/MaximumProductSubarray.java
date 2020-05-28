package com.ny.leetcode.curatedlistchallenge.day5;

public class MaximumProductSubarray {

    public static int maxProduct(int[] A) {
        int n = A.length;

        if(n==1) return A[0];

        int max = A[0], min = A[0];
        int gMax = A[0];
        int gMin = A[0];
        for(int i=1; i<n; i++) {

            int x = A[i];

            int one = x * max;
            int two = x * min;

            max = Math.max(x, Math.max(one, two));
            min = Math.min(x, Math.min(one, two));

            gMax = Math.max(gMax, max);
            gMin = Math.min(gMin, min);
        }
        return gMax;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2,1,-3,1,-4,-1}));
    }
}
