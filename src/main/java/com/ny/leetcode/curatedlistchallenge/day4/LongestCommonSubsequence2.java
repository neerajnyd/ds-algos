package com.ny.leetcode.curatedlistchallenge.day4;

/*
https://leetcode.com/problems/longest-common-subsequence
 */
public class LongestCommonSubsequence2 {

    public static void main(String[] args) {

        System.out.println(lcs2("AGGTAB", "GXTXAYB"));
    }

    private static int lcs2(String s1, String s2) {
        final int m = s1.length();
        final int n = s2.length();

        final int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ?
                        1 + dp[i - 1][j - 1] :
                        Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp[m][n];
    }

    //TODO:
    public static int longestCommonSubsequence_recursive(String s1, String s2) {
        return lcs_recursive(s1.toCharArray(), s1.length() - 1, s2.toCharArray(), s2.length() - 1);
    }

    private static int lcs_recursive(char[] s1, int i, char[] s2, int j) {
        if (i < 0 || j < 0) return 0;
        //we go diagonal
        if (s1[i] == s2[j]) return 1 + (i - 1 < 0 || j - 1 < 0 ? 0 : lcs_recursive(s1, i - 1, s2, j - 1));
        else {
            int upLcs = lcs_recursive(s1, i - 1, s2, j);
            int leftLcs = lcs_recursive(s1, i, s2, j - 1);
            return Math.max(upLcs, leftLcs);
        }
    }

}