package com.ny.leetcode.curatedlistchallenge.day1;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(
                uniquePaths(7, 3)
        );
    }

    public static int uniquePaths(int rows, int cols) {
        int[][] dp = new int[rows][cols];

        //only one to reach the positions in row 0 or column 0
        //so populate 1 in these positions
        for(int i=0; i<rows; i++)
            dp[i][0] = 1;
        for(int i=0; i<cols; i++)
            dp[0][i] = 1;

        //for each position paths = paths on the left + paths on the top
        for(int i=1; i<rows; i++)
            for(int j=1; j<cols; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];

        return dp[rows-1][cols-1];
    }

    public static int uniquePaths2(int rows, int cols) {
        int[] cur = new int[rows];
        int[] pre = new int[rows];
        for (int r = 0; r < rows; r++) {
            pre[r] = 1;
            cur[r] = 1;
        }
        for (int c = 1; c < cols; c++) {
            for (int r = 1; r < rows; r++)
                cur[r] = cur[r - 1] + pre[r];
            pre = cur;
        }

        return cur[rows - 1];
    }

    public static int uniquePaths3(int rows, int cols) {
        int[] cur = new int[rows];

        for (int i = 0; i < rows; i++) cur[i] = 1;

        for (int c = 1; c < cols; c++)
            for (int r = 1; r < rows; r++)
                cur[r] += cur[r - 1];

        return cur[rows - 1];
    }
}
