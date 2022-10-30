package com.ny.grokkingeducative.slidingwindow;

import java.util.Arrays;

public class AvgContiguousSubarrays {

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        System.out.println(Arrays.toString(avgContiguousSubarray(A, K)));
    }

    private static double[] avgContiguousSubarray(int[] A, int k) {

        /*
        first I need sum of numbers till K
        then we can start calculating the sums and at the end we can do an average operation
         */

        int n = A.length;

        int sumsCount = n - k + 1;

        double[] sums = new double[sumsCount];

        double runningSum = 0.0;

        int i = 0;
        for (int j = 0; j < n; j++) {
            runningSum += A[j];
            if (j >= k-1) { //first window is from 0 to k-1
                //when j becomes equal to window-size, we calculate our first average
                sums[i] = runningSum/k;
                runningSum -= A[i++];
            }
        }
        return sums;
    }

}
