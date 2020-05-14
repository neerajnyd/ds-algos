package com.ny.leetcode;

public class MaximalSquare {
    public static void main(String[] args) {

        char[][] M = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalSquare(M));
    }

    public static int maximalSquare(char[][] A) {
        int rows = A.length;
        int cols = rows == 0 ? 0 : A[0].length;
        int[][] dp = new int[rows + 1][cols + 1];

        int maxSqSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char x = A[i][j];
                if (x == '1') {
                    int sqSide = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    dp[i + 1][j + 1] = sqSide;
                    maxSqSide = Math.max(maxSqSide, sqSide);
                }
            }
        }
        return maxSqSide*maxSqSide;
    }

    public static int maximalSquare_BetterDp(char[][] A) {
        int rows = A.length;
        int cols = rows > 0 ? A[0].length : 0;
        int maxSqSide = 0, prev = 0;
        int[] dp = new int[cols + 1];
        for (int i = 1; i <= rows; i++)
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (A[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxSqSide = Math.max(maxSqSide, dp[j]);
                } else
                    dp[j] = 0;
                prev = temp;
            }
        return maxSqSide * maxSqSide;
    }

    public static int maximalSquare2(char[][] A) {
        int max = 0;
        int m = A.length;
        int n = A[0].length;
        if (m == 0 || n == 0) return 0;
        boolean rowMatrix = m >= n;
        int maxSqSide = Math.min(m, n);
        int diagonals = Math.abs(m - n) + 1;
        int[][] dp = new int[m][n];

        /* we check all the diagonals starting from the bottom right */
        for (int d = diagonals - 1; d >= 0; d--) {
            int i, j;
            if (rowMatrix) {
                i = maxSqSide + d - 1;
                j = maxSqSide - 1;
            } else {
                j = maxSqSide + d - 1;
                i = maxSqSide - 1;
            }

            while ((rowMatrix && i >= d && j >= 0) || (j >= d && i >= 0)) {
                boolean allOnes = true;
                int sqSize;
                if (i < m - 1 && j < n - 1 && A[i + 1][j + 1] == '1') {
                    int prevSquareSize = dp[i + 1][j + 1];
                    for (int x = j + 1; x <= j + prevSquareSize; x++) {
                        if (A[i][x] != '1') {
                            allOnes = false;
                            break;
                        }
                    }
                    if (allOnes) {
                        for (int y = i + 1; y <= i + prevSquareSize; y++) {
                            if (dp[y][j] == 0 && A[y][j] != '1') {
                                allOnes = false;
                                break;
                            }
                        }
                    }
                    if (allOnes) {
                        sqSize = prevSquareSize + 1;
                        dp[i][j] = sqSize;
                        max = Math.max(sqSize, max);
                    }
                } else if ((i == m - 1 && j == n - 1) && A[i][j] == '1') {
                    dp[i][j] = 1;
                    max = Math.max(1, max);
                }
                i--;
                j--;
            }

        }
        return max * max;
    }
}
