package com.ny.leetcode.march2023;

import java.util.Arrays;

public class ReducingDishes {

    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        if (satisfaction[n - 1] <= 0) return 0;

        int maxSum = Integer.MIN_VALUE;

        int k = 0; //keep track of numbers to include in the sum calculation, in each loop we drop off a number on the left till we are in positive range
        while (k < n) {

            if (k > 0 && satisfaction[k - 1] > 0) break; //if previously we have dealt with all positive set, then we already have the biggest sum possible

            int m = 1; //multiple for each no being considered

            int sum = 0;

            for (int i = k; i < n; i++) sum += satisfaction[i] * m++;

            maxSum = Math.max(maxSum, sum);
            k++;
        }
        return maxSum;
    }


}
