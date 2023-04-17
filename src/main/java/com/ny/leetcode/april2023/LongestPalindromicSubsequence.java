package com.ny.leetcode.april2023;

public class LongestPalindromicSubsequence {


    public int longestPalindromeSubseq_Iterative(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {

                dp[i][j] = s.charAt(i) == s.charAt(j) ?
                        dp[i + 1][j - 1] + 2 :
                        Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }

        return dp[0][s.length() - 1];
    }

    public int longestPalindromeSubseq_Recursive(String s) {

        int[][] dp = new int[s.length()][s.length()];

        return lcs(s, 0, s.length() - 1, dp);
    }

    private int lcs(String s, int i, int j, int[][] dp) {

        if (dp[i][j] != 0) return dp[i][j];

        if (i > j) return 0;

        if (i == j) return 1;

        dp[i][j] = s.charAt(i) == s.charAt(j) ?
                2 + lcs(s, i + 1, j - 1, dp) : Math.max(lcs(s, i, j - 1, dp), lcs(s, i + 1, j, dp));
        return dp[i][j];
    }
}
