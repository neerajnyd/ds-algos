package com.ny.leetcode.april2023;

import java.util.List;

public class MaxValueOfKCoinsFromPiles {


    public int maxValueOfCoins(List<List<Integer>> piles, int K) {
        int n = piles.size();
        int[][] dp = new int[n + 1][K + 1];
        return recurse(0, K, piles, dp);
    }

    public int recurse(int i, int k, List<List<Integer>> piles, int[][] dp) {
        if (dp[i][k] > 0) return dp[i][k];

        if (i == piles.size() || k == 0) return 0;

        int result = recurse(i + 1, k, piles, dp);

        int curSum = 0;

        List<Integer> ithPile = piles.get(i);
        for (int j = 0; j < ithPile.size() && j < k; ++j) {
            curSum += ithPile.get(j);
            int rest = recurse(i + 1, k - j - 1, piles, dp);
            result = Math.max(result, rest + curSum);
        }

        dp[i][k] = result;
        return result;
    }
}
