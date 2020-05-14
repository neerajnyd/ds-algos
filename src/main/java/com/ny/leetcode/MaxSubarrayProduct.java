package com.ny.leetcode;

public class MaxSubarrayProduct {
    public static void main(String[] args) {
        int[] nums = {-2,0,-4};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] A) {
        int imax = A[0];
        int imin = A[0];
        int max = A[0];

        for(int i=1; i<A.length; i++) {
            int n = A[i];
            int num1 = imax* n;
            int num2 = imin* n;
            imax = Math.max(n, num1);
            imax = Math.max(imax, num2);
            imin = Math.min(n, num1);
            imin = Math.min(imin, num2);
            max = Math.max(max, imax);
        }
        return max;

    }

    int maxProduct(int A[], int n) {
        // store the result that is the max we have found so far
        int max = A[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = max, imin = max; i < n; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (A[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);

            // the newly computed max value is a candidate for our global result
            max = Math.max(max, imax);
        }
        return max;
    }
}
