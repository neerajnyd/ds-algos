package com.ny.leetcode.may2020;

public class Day21_SquareSubMatrices {

    public static int countSquares(int[][] M) {

        int sum = 0;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (i > 0 && j > 0 && M[i][j] == 1) {
                    int top = M[i][j - 1];
                    int left = M[i - 1][j];
                    int topLeft = M[i - 1][j - 1];
                    M[i][j] = Math.min(topLeft, Math.min(top, left)) + 1;
                }
                sum += M[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        final int[][] m1 =
                {
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}
                };
        System.out.println(countSquares(
                m1
        ));
        final int[][] m2 = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(countSquares(
                m2
        ));
    }

}
