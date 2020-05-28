package com.ny.leetcode.may2020;

public class Day25_UncrossedLines {

    //so this is just lcs
    public static int maxUncrossedLines(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                dp[i+1][j+1] = A[i] == B[j] ?
                        dp[i][j] + 1 :Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] A = {1,3,7,1,7,5}, B = {1,9,2,5,1};

        System.out.println(maxUncrossedLines(A, B));
    }

}
